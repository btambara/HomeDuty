package com.app.tambara.homeduty.domain;

import javax.persistence.*;

@Entity
@Table(name = "DUTIES")
public class Duties {
    @Id
    @Column(name = "DUTY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dutyID;

    @Column(name = "OWNER_ID")
    private long ownerID;

    @Column(name = "TASK_ID")
    private long taskID;

    public long getDutyID() {
        return dutyID;
    }

    public void setDutyID(long dutyID) {
        this.dutyID = dutyID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    @Override
    public String toString() {
        StringBuilder objString = new StringBuilder();
        objString.append("Duties-ID:\t" + getDutyID());
        objString.append("\tOwner-ID:\t" + getOwnerID());
        objString.append("\tTask-ID:\t" + getTaskID());
        return objString.toString();
    }
}
