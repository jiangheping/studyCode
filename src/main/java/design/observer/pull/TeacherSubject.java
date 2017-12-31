package design.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题接口实现类
 */
public class TeacherSubject implements Subject {

    //用来存放和记录观察者
    private List<Observer> observers = new ArrayList<Observer>();

    //记录状态的字符串
    private String info;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver(String info) {
        this.info = info;
        System.out.println("今天的作业是" + info);
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getInfo() {
        return info;
    }
}
