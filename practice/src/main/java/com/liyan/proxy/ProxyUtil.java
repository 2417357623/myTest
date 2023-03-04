package com.liyan.proxy;

import java.lang.reflect.*;

public class ProxyUtil {
    public static Star createProxy(final BigStar bigStar){
        Star Star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("sing".equals(method.getName())){
                            System.out.println("准备话筒");
                        }else if("dance".equals(method.getName())){
                            System.out.println("准备场地");
                        }
                        return method.invoke(bigStar,args);
                    }
                }

        );

        return Star;

    }

    public static Object createProxy_2(final Object target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //得到代理类对象，这个对象是根据接口而实现，通过类对象的构造器newInstance来创建代理对象实例
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        System.out.println(proxyClass);

        //选择参数为InvocationHandler的构造器
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);

        Object o = constructor.newInstance(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
        return o;
    }
}
