package com.javalearning.item.mapper;

import com.javalearning.item.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /*
    查询所有
     */
    List<Brand> selectAll();
}
