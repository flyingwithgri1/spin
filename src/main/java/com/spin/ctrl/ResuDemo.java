package com.spin.ctrl;

import com.spin.bean.Product;
import com.spin.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@RestController
public class ResuDemo {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/imgs")
    public Map<String,List<Product>> imgs(int pageNo){
        log.info("查询页码" + pageNo);
        List<Product> products = productService.show(pageNo);
        Map<String,List<Product>> map = new HashMap<>();
        map.put("products",products);
        return map;
    }

    @RequestMapping(value = "/products")
    public List<Product> products(int pageNo){
        log.info("查询页码" + pageNo);
        List<Product> products = productService.show(pageNo);
        return products;
    }
    @RequestMapping(value = "/products")
    public String test(){
        log.info("查询页码" + 1);
        return "1";
    }
}
