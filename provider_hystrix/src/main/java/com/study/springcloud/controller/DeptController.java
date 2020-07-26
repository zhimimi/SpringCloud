package com.study.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.springcloud.entities.Dept;
import com.study.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return deptService.add(dept);
    }


    @RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "HystrixFallBack")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该id:"+ id + "无对应信息");
        }
        return dept;
    }


    @RequestMapping(value="/dept/list",method= RequestMethod.GET)
    public List<Dept> list()
    {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }
    public Dept HystrixFallBack(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("Hystrix");
    }
}
