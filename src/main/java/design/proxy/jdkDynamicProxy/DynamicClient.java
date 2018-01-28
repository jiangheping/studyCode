package design.proxy.jdkDynamicProxy;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import design.proxy.staticProxy.ICoder;
import design.proxy.staticProxy.JavaCoder;

/**
 * 模拟用户找产品经理更改需求
 */
public class DynamicClient {
    public static void main(String args[]){
        //要代理的真实对象
        ICoder coder = new JavaCoder("Zhang");
        //创建中介类实例
        InvocationHandler handler = new CoderDynamicProxy(coder);
        //获取类加载器
        ClassLoader cl = coder.getClass().getClassLoader();
        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(cl, coder.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.implDemands("Modify user management");
    }
}
