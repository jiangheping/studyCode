package design.observer.eventBus;

import base.model.UserAction;
import com.google.common.eventbus.EventBus;


public class UserActionHandler {
    //Spring中可以用注解构建对象更好，是单例模式！
    private EventBus eventBus = new EventBus();
    private UserActionObserver observer = new UserActionObserver();

    /**
     * ps注意：
     * 这里调用register注册观察者，待执行状态改变之后，要执行取消观察者，不然随着调用次数的增加而不断增加更多的观察者
     * 最好的办法：利用Spring的@PostConstruct注解，在UserActionHandler类初始化的时候就将观察者注册进去
     */
    public void recordUserAction(UserAction userAction){
        eventBus.register(observer);//注册观察者资格，如果在初始化中添加了那么就不用再次添加删除了
        eventBus.post(userAction);
        eventBus.unregister(observer);//取消观察者资格
    }
}
