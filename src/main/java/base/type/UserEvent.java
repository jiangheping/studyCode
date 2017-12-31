package base.type;

public enum UserEvent {
    RECHARGE("充值", "用户%s，充值%s");

    private String event;
    private String remark;

    UserEvent(String event, String remark) {
        this.event = event;
        this.remark = remark;
    }

    public String buildRemark(String... args) {
        return String.format(this.remark, (Object[]) args);
    }
}
