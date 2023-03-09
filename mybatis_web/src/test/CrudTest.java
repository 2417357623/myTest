import com.liyan.bank.dao.PersonDao;
import com.liyan.bank.dao.StudentDao;
import com.liyan.bank.pojo.Person;
import com.liyan.bank.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public void insertBatch(){
        SqlSession sqlSession = MybatisUtil.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        List<Person> persons = new ArrayList<Person>();
        Person person1 = new Person(null,"jj","cx");
        Person person2 = new Person(null,"jj2", "cx");
        persons.add(person1);
        persons.add(person2);
        mapper.insertBatch(persons);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAllByResultMapTest(){
        SqlSession sqlSession = MybatisUtil.openSession();
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);

        List<Person> people = mapper.selectAllByResultMap();
        for(Person person :people){
            System.out.println(person);
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = MybatisUtil.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        mapper.selectById(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
