package com.swei.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-13 14:20
 */
@FeignClient(name = "PRODUCTS")
public interface ProductClient {

    @GetMapping("/product")
    String product(@RequestParam("id") Integer id);
}
