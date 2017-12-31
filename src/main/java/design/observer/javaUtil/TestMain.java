package design.observer.javaUtil;

/**
 * java.util包提供的观察者方法
 * 主题角色：继承Observable
 * 观察者：实现Observer接口，实现update方法
 */
public class TestMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student("zhangsan");
        teacher.addObserver(student);//增加观察者
        teacher.setHomework("第三页第六题");
    }
}
