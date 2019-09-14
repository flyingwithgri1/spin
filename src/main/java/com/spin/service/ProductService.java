package com.spin.service;

import com.spin.bean.Product;
import com.spin.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> show(int pageNo){
        if(pageNo == 0){
            pageNo = (pageNo + 2) * 10;
        }else{
            pageNo = (pageNo +1) *10;
        }

        return productDao.get(pageNo);
    }

    public String insert(Product product){
        productDao.insert(product);
        return "ok";
    }
}
