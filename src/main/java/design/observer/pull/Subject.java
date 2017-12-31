package design.observer.pull;

/**
 * 主题接口
 * 三个方法：添加／删除观察者，通知观察者的方法
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String info);
}
