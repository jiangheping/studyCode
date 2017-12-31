package design.observer.javaUtil;

import java.util.Observable;

/**
 * 主题角色类（继承Observable类）
 */
public class Teacher extends Observable {
    private String info;

    public void setHomework(String info) {
        this.info = info;
        System.out.println("布置的作业是" + info);
        setChanged();
        notifyObservers();//这里使用了拉模式观察，如果使用推模式可以在改方法传参数，会在观察者update方法的第二个参数获取到
    }

    public String getInfo() {
        return info;
    }
}
