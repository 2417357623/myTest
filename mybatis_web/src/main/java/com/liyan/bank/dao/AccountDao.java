package com.liyan.bank.dao;

import com.liyan.bank.pojo.Account;

/**
 * @ClassName AccountDao
 * @Description Dao层，负责表中数据的CRUD。Dao层中任何一个方法和业务不挂钩，没有任何业务逻辑，
 * 从而做到层与层之间分工明确，业务层可以重复调用dao层方法.*
 * @Author Li Yan
 * @Date 2023/3/5 20:59
 * @Version 1.0
 */
public interface AccountDao {
    /**+
     * @description: 根据账号查询账号信息
     * @param: actno
     * @return:  Account
     * @author Administrator LiYan
     * @date: 2023/3/5 21:05
     */
    Account selectByActno(String actno);

    int updateByActno(Account act);

    Account selectByActnoAndId(String actno,int id);

}
