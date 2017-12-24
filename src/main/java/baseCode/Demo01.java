package baseCode;

import org.junit.Test;

public class Demo01 {

    //for循环子方法抛异常并在子方法处理了，不影响父方法运行
    @Test
    public void testDoThrowCatch() {
        for (int i = 0; i <= 5; i++) {
            doThrowException(i);
        }
    }

    private void doThrowException(int i) {
        if (i == 2) {
            try {
                throw new Exception("在方法里面抛出异常");
            } catch (Exception e) {//catch后的代码照常执行,且不影响其他数据的（i）的运行
                System.out.println("抓住了异常,进行异常处理");
                e.printStackTrace();
                return;//加return结束改次异常运行，其他参数继续，不加return会打印下面那个****2
            }
        }
        System.out.println("********  " + i);
    }


    //for循环子方法抛异常到父类
    //父类接受到异常之后就不会再继续执行
    @Test
    public void testDoThrowsException() throws Exception {
        for (int i = 0; i <= 5; i++) {
            doThrowsException(i);
        }
    }

    //父类获取到了异常并进行了捕获处理，则会继续for循环
    @Test
    public void testDoThrowsException2() {
        for (int i = 0; i <= 5; i++) {
            try {
                doThrowsException(i);
            } catch (Exception e) {
                System.out.println("抓取到异常："+i);//抓取到异常后面还会继续进行
                e.printStackTrace();
            }
            System.out.println("------："+i);
        }
    }

    private void doThrowsException(int i) throws Exception {
        if (i == 2) {
            throw new Exception("在方法里面抛出异常");//抛出异常后，后面的方法就不会再继续运行了
        }
        System.out.println("********  " + i);
    }
}
