package design.observer.javaUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者对象（实现Observer接口）
 */
public class Student implements Observer {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Teacher t = (Teacher) o;
        System.out.println(name + "收到作业信息:" + t.getInfo());

    }

}
