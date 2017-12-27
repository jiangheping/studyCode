package baseCode;

import base.model.Person;
import base.model.UserAction;
import com.google.common.base.*;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;

/**
 * guava使用
 */
public class GuavaDemo {

    /**
     * optional使用
     */
    @Test
    public void optionalTest() {
        Person p1 = new Person("周杰伦", 37);
        Person p2 = null;
        Optional<Person> optPer1 = Optional.of(p1);
        //Optional<Person> optPer2 =  Optional.of(p2);//报空指针异常
        Optional<Person> optPer2 = Optional.fromNullable(p2);//可以放空值
        System.out.println(optPer1.get().getName());
        //System.out.println(optPer2.get());//如果p2是空，使用formNullable，调用get则报java.lang.IllegalStateException: Optional.get() cannot be called on an absent value
        System.out.println(optPer1.isPresent());//true
        System.out.println(optPer2.isPresent());//false
    }

    /**
     * 前置条件检查，当条件不满足时，就会抛出异常
     */
    @Test
    public void testPreconditions() {
        //1、不输出任何代码
        String str = "abc";
        Preconditions.checkNotNull(str, "str 为 null");

        //2、空值检查，报java.lang.NullPointerException：constantName 为 null
        String constantName = null;
        //Preconditions.checkNotNull(constantName, "constantName 为 null");

        //3、参数检查，报java.lang.IllegalArgumentException: 5小于0是错误的
        Preconditions.checkArgument(5 < 0, "5小于0是错误的");
    }

    @Test
    public void stringGuava() {
        //连接器
        Joiner joiner = Joiner.on(";").skipNulls();//如果不加skipNulls，参数中有null将会报空指针
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));//输出Harry;Ron;Hermione

        Joiner joiner2 = Joiner.on(";").useForNull("****");//代替null值
        System.out.println(joiner2.join("Harry", null, "Ron", "Hermione"));//输出Harry;****;Ron;Hermione

        //拆分器
        String str = ",a,,b,";
        String[] strArr = str.split(",");
        System.out.println(strArr.length);//输出4
        for (String s : strArr) {
            System.out.println(s == null ? "NULL" : s);//输出"",a,"",b,只有尾部的空字符串被忽略
        }
        System.out.println("----------");
        //omitEmptyStrings():从结果中自动忽略空字符串
        //trimResults()	:移除结果字符串的前导空白和尾部空白
        //trimResults(CharMatcher):给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
        Iterable<String> strs = Splitter.on(",").trimResults().omitEmptyStrings().split(str);
        for (String s : strs) {
            System.out.println(s);//只输出a,b
        }
        //如果你想要拆分器返回List，只要使用Lists.newArrayList(splitter.split(string))或类似方法
    }

    //测试过滤掉50岁以上的人
    @Test
    public void testFilter() {
        Person p1 = new Person("周杰伦", 37);
        Person p2 = new Person("王力宏", 43);
        Person p3 = new Person("李易峰", 23);
        Person p4 = new Person("许镜清", 70);
        Person p5 = new Person("贝多芬", 72);
        List<Person> persons = asList(p1, p2, p3, p4, p5);
        List<Person> persons1 = from(persons).filter(getPersomAgeUnder30()).toList();
        for (Person p : persons1) {
            System.out.println(p.getName() + "  " + p.getAge());
        }
    }

    //过滤大于50岁的，返回true则获取该条数据到返回list中
    private Predicate<Person> getPersomAgeUnder30() {
        return new Predicate<Person>() {
            public boolean apply(Person input) {
                return input.age < 50;
            }
        };
    }

}
