package design.proxy.cglibDynamicProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * 1、首先定义业务类
 * 无需实现接口（当然，实现接口也可以，不影响的）
 */
class JavaCoderImpl {
    private String name;

    public JavaCoderImpl(String name) {
        this.name = name;
    }

    public JavaCoderImpl() {

    }

    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand:" + demandName + " in JAVA!");
    }
}

/**
 * 2、实现 MethodInterceptor方法代理接口，创建代理类
 */
class JavaCoderCglib implements MethodInterceptor {

    private Object obj;//业务类对象，供代理方法中进行真正的业务方法调用

    //相当于JDK动态代理中的绑定
    public Object getInstance(Object target, Class[] argumentTypes, Object[] arguments) {
        this.obj = target;  //给业务对象赋值
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(this.obj.getClass());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create(argumentTypes, arguments);//不带参数则方法enhancer.create()
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(System.currentTimeMillis());
        methodProxy.invokeSuper(obj, args); //调用业务类（父类中）的方法
        System.out.println(System.currentTimeMillis());
        return null;
    }

}

/**
 * 测试
 */
public class TestCglib {
    public static void main(String[] args) {
        JavaCoderImpl javaCoder = new JavaCoderImpl();//创建业务类对象
        JavaCoderCglib javaCoderCglib = new JavaCoderCglib();//
        JavaCoderImpl javaCoderProxy = (JavaCoderImpl) javaCoderCglib.getInstance(javaCoder, new Class[]{String.class}, new Object[]{"zhangsan"});//创建代理对象
        javaCoderProxy.implDemands("create proxy by cglib");
    }
}
