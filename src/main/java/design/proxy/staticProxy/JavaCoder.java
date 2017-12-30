package design.proxy.staticProxy;

/**
 * 真实角色，实现真正业务
 */
public class JavaCoder implements ICoder{

    private String name;

    public JavaCoder(String name){
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand:" + demandName + " in JAVA!");
    }
}
