package jobDesign;

import base.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 总结下：
 * 首先调用接口方法
 * 然后在接口execute实现方法里调用process方法
 * 在process方法里进行分页处理等
 * 分页batch数据可以固定，获取总条数的方法可以抽象出来又子类实现
 *
 * 当父类子类有相同的方法时，优先调用子类方法
 */
public class TestJob extends BatchPagingJob<Person> {

    @Override
    int getTotalAmount() {
        return 2;//调用数据查询的方法
    }

    @Override
    List<Person> fetchList(int from, int batch) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("zhangsan", 23));
        personList.add(new Person("lisi", 33));
        return personList;//调用数据库分页的方法
    }

    @Override
    public void processList(List<Person> items) {
        //这里可以调用一个service处理job逻辑
        for (Person person : items) {
            System.out.println("姓名：" + person.getName() + ",年龄：" + person.getAge());
        }
    }

    public static void main(String[] args) {
        SimpleJob job = new TestJob();
        job.execute("test");
    }
}
