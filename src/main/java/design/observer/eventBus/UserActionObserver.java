package design.observer.eventBus;

import base.model.UserAction;
import com.google.common.eventbus.Subscribe;

/**
 * 观察者
 */
public class UserActionObserver {

    /**
     * eventBus.post(Object)方法会通过@Subscribe注解通知观察者执行
     * 所以观察者接收通知的方法必须要有@Subscribe注解的方法
     */
    @Subscribe
    private void onSave(UserAction userAction) {
        System.out.println("这里调用service，数据库记录下用户行为！");
        System.out.println(userAction.getEventAndRemark());
    }
}
