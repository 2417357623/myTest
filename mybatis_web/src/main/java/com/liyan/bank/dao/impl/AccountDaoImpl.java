//package com.liyan.bank.dao.impl;
//
//import com.liyan.bank.dao.AccountDao;
//import com.liyan.bank.pojo.Account;
//import com.liyan.bank.utils.MybatisUtil;
//import org.apache.ibatis.session.SqlSession;
//
///**
// * @ClassName AccountDaoImpl
// * @Description TODO
// * @Author Li Yan
// * @Date 2023/3/5 21:08
// * @Version 1.0
// */
//public class AccountDaoImpl implements AccountDao {
//    public Account selectByActno(String actno) {
//        SqlSession sqlSession = MybatisUtil.openSession();
//        Account selectByActno = (Account) sqlSession.selectOne("account.selectByActno", actno);
//        return selectByActno;
//    }
//
//    public int updateByActno(Account act) {
//        SqlSession sqlSession = MybatisUtil.openSession();
//        int updateByActno = sqlSession.update("account.updateByActno", act);
//        return updateByActno;
//    }
//}
