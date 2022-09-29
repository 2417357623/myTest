package com.learn.bean.item.web;


import com.learn.bean.item.pojo.Brand;
import com.learn.bean.item.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ItemServlet01")
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
