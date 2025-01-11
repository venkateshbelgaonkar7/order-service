package com.techie.microservices.order.client;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Component
//@FeignClient(value = "inventory", url = "${inventory.url}")

public interface InventoryClient {

//    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

}
