package design.observer.eventBus;

import base.model.UserAction;
import base.type.UserEvent;

/**
 * google guava提供的eventBus观察者模式
 */
public class TestMain {
    public static void main(String[] args) {
        UserAction userAction = new UserAction()
                .setUserId("3006")
                .setEventAndRemark(UserEvent.RECHARGE,"3006","1000RMB");
        UserActionHandler handler = new UserActionHandler();
        handler.recordUserAction(userAction);
    }
}
