package design.proxy.staticProxy;

/**
 * 产品经理实现编程
 * 代理模式包含如下角色：
 * Subject:抽象主题角色。可以是接口，也可以是抽象类。
 * RealSubject:真实主题角色。业务逻辑的具体执行者。
 * ProxySubject:代理主题角色。内部含有RealSubject的引用,负责对真实角色的调用，并在真实主题角色处理前后做预处理和善后工作。
 */
public class TestMain {
    public static void main(String args[]){
        //定义一个java码农
        ICoder coder = new JavaCoder("Zhang");
        //定义一个产品经理
        ICoder proxy = new CoderProxy(coder);
        //让产品经理实现一个需求
        proxy.implDemands("Add user manageMent");
    }
}
