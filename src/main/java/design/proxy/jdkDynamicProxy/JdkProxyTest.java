package design.proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 2017/9/10.
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        System.out.println(userService.getClass());
        System.out.println(userService.getClass().getClassLoader());
        System.out.println(userService.getClass().getInterfaces());
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance
                (userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),invocationHandler);
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(2));
    }
}
