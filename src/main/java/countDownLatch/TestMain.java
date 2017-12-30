package countDownLatch;

/**
 * CountDownLatch使用场景：
 * 1、开始执行前等待n个线程完成各自任务，如计数器／统计等
 * 2、实现最大的并行性
 * 3、死锁检测
 */
public class TestMain {
    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was : "+ result);
    }
}
