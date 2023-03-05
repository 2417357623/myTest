package com.liyan.bank.service;

import com.liyan.bank.dao.impl.AccountDaoImpl;
import com.liyan.bank.exception.MoneyNotEnoughException;
import com.liyan.bank.exception.TransferException;

/**
 * @ClassName AccountService
 * @Description
 * @Author Li Yan
 * @Date 2023/3/5 20:50
 * @Version 1.0
 */
public interface AccountService {

    /**
     * @description: 转账方法
     * @param: 转出账户，转入账户，转账金额
     * @return:
     * @author Administrator LiYan
     * @date: 2023/3/5 20:58
     */
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException;

}
