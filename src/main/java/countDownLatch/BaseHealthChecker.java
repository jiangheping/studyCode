package countDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable {
    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    public BaseHealthChecker(CountDownLatch latch, String serviceName, boolean serviceUp) {
        this.latch = latch;
        this.serviceName = serviceName;
        this.serviceUp = serviceUp;
    }

    public abstract void verifyService();

    @Override
    public void run(){
        try{
            verifyService();
        } catch (Throwable t){
            t.printStackTrace(System.err);
            serviceUp = false;
        } finally {
            if(latch!=null){
                latch.countDown();
                System.out.println("service:"+serviceName+",count:"+latch.getCount());
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }
}