import com.liyan.proxy.*;
import com.liyan.reflect.Student;
import com.liyan.reflect.Teacher;
import org.junit.Test;

import java.lang.reflect.*;

public class TestDemo {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BigStar star = new BigStar("liyan");
        Star proxy_2 = (Star) ProxyUtil.createProxy_2(star);
        System.out.println("代理对象执行");
        proxy_2.sing("lala");

        Player player = new Player();
        Run proxy_21 = (Run) ProxyUtil.createProxy_2(player);
        proxy_21.run();

    }
}
