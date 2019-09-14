package com.spin.ctrl;

import com.spin.bean.Product;
import com.spin.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Log
@Controller
@RequestMapping(value = "spin")
public class Demo {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/wy")
    public String wy(){
        return "wy";
    }

    @RequestMapping(value = "/vue")
    public String vue(){
        System.out.println(1);
        return "vue"; 
    }

    @GetMapping(value = "/file")
    public String file(){
        return "file";
    }


    @PostMapping(value = "/fileUpload")
    @GetMapping(value = "/fileUpload")
    public String upload(@RequestParam(value = "file")MultipartFile file,Product product){
        if(file.isEmpty()){
            log.info("文件为空....");
        }
        String fileName = file.getOriginalFilename();//文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D:\\uploadimg\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setColorId(1);
        product.setCreateTime(System.currentTimeMillis());
        product.setPath("/image/"+fileName);
        product.setCreateUserId(1);
        product.setTexture(1);
        productService.insert(product);
        log.info("插入成功");
        return "home";
    }


}
