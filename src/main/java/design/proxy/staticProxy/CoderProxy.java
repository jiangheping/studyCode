package design.proxy.staticProxy;

/**
 * 代理角色 （产品经理）
 */
public class CoderProxy implements ICoder{

    private ICoder coder;

    public CoderProxy(ICoder coder){
        this.coder = coder;
    }

    @Override
    public void implDemands(String demandName) {
        if(demandName.startsWith("Add")){
            System.out.println("No longer receive 'Add' demand");
            return;
        }
        coder.implDemands(demandName);
    }

}
