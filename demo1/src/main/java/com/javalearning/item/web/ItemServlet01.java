package com.javalearning.item.web;


import com.javalearning.item.pojo.Brand;
import com.javalearning.item.service.BrandService;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ItemServlet01 extends HttpServlet {

    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Brand> brands = brandService.selectAll();

        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/item01.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }



}
