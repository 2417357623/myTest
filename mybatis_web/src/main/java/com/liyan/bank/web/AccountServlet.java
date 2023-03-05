package com.liyan.bank.web;

import com.liyan.bank.exception.MoneyNotEnoughException;
import com.liyan.bank.exception.TransferException;
import com.liyan.bank.service.AccountService;
import com.liyan.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AccountServlet
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 19:05
 * @Version 1.0
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取表单数据
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));

        //调用转账服务
        try {
            accountService.transfer(fromActno,toActno,money);
            resp.sendRedirect(req.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            resp.sendRedirect(req.getContextPath() + "/error1.html");

        } catch (TransferException e) {
            resp.sendRedirect(req.getContextPath() + "/error2.html");

        }

        //返回view

    }
}
