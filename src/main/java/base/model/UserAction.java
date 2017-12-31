package base.model;

import base.type.UserEvent;

public class UserAction {
    private String userId;
    private UserEvent event;
    private String eventAndRemark;

    public String getUserId() {
        return userId;
    }

    public UserAction setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public UserEvent getEvent() {
        return event;
    }

    public UserAction setEvent(UserEvent event) {
        this.event = event;
        return this;
    }

    public UserAction setEventAndRemark(String eventAndRemark) {
        this.eventAndRemark = eventAndRemark;
        return this;
    }

    public String getEventAndRemark() {
        return eventAndRemark;
    }

    public UserAction setEventAndRemark(UserEvent event, String... agrs) {
        this.event = event;
        this.eventAndRemark = event.buildRemark(agrs);
        return this;
    }

    @Override
    public String toString(){
        return  "userId:"+this.userId
                +",remark:"+this.eventAndRemark;
    }
}
