package com.liyan.bank.service.impl;

import com.liyan.bank.dao.AccountDao;
import com.liyan.bank.dao.impl.AccountDaoImpl;
import com.liyan.bank.exception.MoneyNotEnoughException;
import com.liyan.bank.exception.TransferException;
import com.liyan.bank.pojo.Account;
import com.liyan.bank.service.AccountService;
import com.liyan.bank.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 20:51
 * @Version 1.0
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = MybatisUtil.openSession().getMapper(AccountDao.class);

    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {

        //现在是没有开启事务的，无法保证两个update同时进行，事务是mybatis写的用的sqlsession,底层仍然是jdbc.
        //并且事务不写在Dao层，写在service层，一般一个业务方法对应一个事务
        //如果需要实现事务，需要保证整个方法用的sqlSession是同一个，即底层的conn是同一个，这样开启的才是同一个事务
        //可以通过传参，传sqlSession到每一个Dao的方法里，但是很丑
        //由于transfer和这个dao的方法是在一个线程下的，所以通过把线程和sqlSession绑定，从而获取唯一的sqlSession。
        //这里用到threadLocal技术

        SqlSession sqlSession = MybatisUtil.openSession();

        //mapper代理之后，实现了AccountDao接口，实现类里面封装了sqlSession.selectOne，所以这里是拿接口实现类的对象在调用查询方法
        Account fromAccount = accountDao.selectByActno(fromActno);
        Double fromAccountBalance = fromAccount.getBalance();
        if( money>fromAccountBalance){
            throw new MoneyNotEnoughException("余额不足");

        }else {
            fromAccount.setBalance(fromAccountBalance - money);
            Account toAccount = accountDao.selectByActno(toActno);

            toAccount.setBalance(toAccount.getBalance() + money);
            int count = accountDao.updateByActno(fromAccount);

//            String s = null;
//            s.toString();

            count += accountDao.updateByActno(toAccount);
            if(count != 2){
                throw new TransferException("转账异常");

            }

            sqlSession.commit();
            MybatisUtil.close(sqlSession);

        }
    }
}
