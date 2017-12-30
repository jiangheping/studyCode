package countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {
    private static List<BaseHealthChecker> services;
    private static CountDownLatch countDownLatch;
    public static boolean checkExternalServices() throws InterruptedException {
        services = new ArrayList<BaseHealthChecker>();
        countDownLatch = new CountDownLatch(3);
        services.add(new NetworkHealthChecker(countDownLatch));
        services.add(new DatabaseHealthChecker(countDownLatch));
        services.add(new CacheHealthChecker(countDownLatch));
        ExecutorService executor = Executors.newFixedThreadPool(services.size());
        for(BaseHealthChecker service:services){
            executor.execute(service);
        }
        countDownLatch.await();
        executor.shutdown();
        for(BaseHealthChecker service:services){
            if(!service.isServiceUp()){
                return false;
            }
        }
        return true;
    }
}
