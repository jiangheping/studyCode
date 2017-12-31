package design.observer.pull;

/**
 * 观察者
 */
public interface Observer {
    //当主题发送通知给观察者时，观察者改变状态
    void update(Subject subject);
}
