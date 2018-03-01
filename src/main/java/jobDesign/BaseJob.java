package jobDesign;


public abstract class BaseJob implements SimpleJob {

    private String jobName = this.getClass().getName();
    protected static final int MIN_ALARM_SECONDS = 60 * 5;
    protected static final int BATCH_AMOUNT = 100;


    @Override
    public void execute(String str) {
        System.out.println("调用的job是：" + jobName);
        System.out.println("调用了接口方法execute方法，参数：" + str);
        execute();
    }

    public abstract void execute();

    public int getAlarmSeconds() {
        return MIN_ALARM_SECONDS;
    }
}
