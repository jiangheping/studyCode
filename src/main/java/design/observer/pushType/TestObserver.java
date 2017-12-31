package design.observer.pushType;

/**
 * 测试类
 * 观察者模式：推
 */
public class TestObserver {
    public static void main(String[] args) {

        TeacherSubject teacher = new TeacherSubject();
        StudentObserver zhangSan = new StudentObserver("张三", teacher);
        StudentObserver liSi = new StudentObserver("李四", teacher);
        StudentObserver wangWu = new StudentObserver("王五", teacher);

        teacher.notifyObserver("第二页第六题");
        teacher.notifyObserver("第三页第七题");
        teacher.notifyObserver("第五页第八题");
    }
}
