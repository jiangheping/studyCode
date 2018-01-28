package baseCode;

import java.util.Random;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer num = local.get();
                    if(num == null){
                        num = new Random().nextInt();
                        System.out.println(num);
                        local.set(num);
                    }
                    System.out.println(local.get());
                }
            });
            threads[i].start();
        }
    }
}
