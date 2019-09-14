package com.spin.dao;

import com.spin.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "path", column = "path"),
//            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createUserId", column = "create_user"),
            @Result(property = "colorId", column = "color_id"),
            @Result(property = "tianmaoUrl", column = "tianmao_url"),
            @Result(property = "texture", column = "texture")
    })
    @Select("select * from product limit #{pageNo}")
    List<Product> get(int pageNo);

    @Insert("INSERT INTO product(`name`,path,color_id,texture,create_user,create_time,tianmao_url) VALUES (#{name},#{path},#{colorId},#{texture},#{createUserId},now(),#{tianmaoUrl})")
    void insert(Product product);
}
