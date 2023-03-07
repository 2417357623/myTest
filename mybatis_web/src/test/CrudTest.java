import com.liyan.bank.dao.AccountDao;
import com.liyan.bank.dao.PersonDao;
import com.liyan.bank.pojo.Account;
import com.liyan.bank.pojo.Person;
import com.liyan.bank.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CrudTest
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/6 22:46
 * @Version 1.0
 */
public class CrudTest {

    @Test
    public void insertTest(){


        SqlSession sqlSession = MybatisUtil.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        mapper.insert(new Person(2,"liyan2","cahngxing"));
        sqlSession.commit();
    }

    @Test
    public void deleteTest(){


        SqlSession sqlSession = MybatisUtil.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        mapper.deleteById(1);
        sqlSession.commit();
    }

    @Test
    public void selectTest(){


        SqlSession sqlSession = MybatisUtil.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        Person p = mapper.selectById(1);
        List<Person> people = mapper.selectAll();
        for(Person person : people){
            System.out.println(person);

        }
        System.out.println(p);
        sqlSession.commit();
    }

    @Test
    public void paramTest(){
        SqlSession sqlSession = MybatisUtil.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account act001 = mapper.selectByActnoAndId("act001", 1);
        System.out.println(act001);

    }
}
