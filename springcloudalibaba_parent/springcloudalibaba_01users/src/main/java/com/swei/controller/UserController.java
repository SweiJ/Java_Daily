package com.swei.controller;

import com.swei.feignclients.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-13 10:47
 */
@RestController
public class UserController {
    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 服务发现客户端
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 负载均衡客户端组件
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 注入具有负载均衡的RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/invoke")
    public String invokeProduct() {
        log.info("调用用户服务...");
        /**
         * 1. 直接使用RestTemplate
         * 调用商品服务 缺点: 1. 无法实现请求负载均衡 2. 路径写死代码中不利于后期维护
         */
//        String result = new RestTemplate().getForObject("http://localhost:9090/product?id=21", String.class);

        /**
         * 使用ribbon组件实现负载均衡 1. 引入ribbon依赖(nacos client 存在依赖) 2. 使用ribbon完成负载均衡
         * 1. DiscoveryClient 服务发现 拉取服务注册中心中的所有集群服务
         */
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PRODUCTS");
        for (ServiceInstance instance : serviceInstances) {
            log.info("服务主机: {} 服务端口: {} 服务uri: {}", instance.getHost(), instance.getPort(), instance.getUri());
        }
        // 使用第一个服务 缺点: 手动实现负载均衡策略 比较麻烦
//        String result = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/product?id=21", String.class);

        /**
         * 2. LoadBalanceClient 提供负载均衡策略 返回确定的单个服务
         */
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTS");
//        String result = new RestTemplate().getForObject(serviceInstance.getUri() + "/product?id=21", String.class);

        /**
         * 3. @LoadBalance 注解实现负载均衡
         */
//        String result = restTemplate.getForObject("http://PRODUCTS/product?id=21", String.class);

        /**
         * 4. 使用openfeign实现
         */
        String result = productClient.product(21);

        log.info("调用商品服务结果... {}", result);
        return result;
    }
}
