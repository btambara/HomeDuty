package com.app.tambara.homeduty.domain;


import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskID;

    @Column(name = "TASK_NAME", nullable = false)
    private String taskName;

    @Column(name = "TASK_DESCRIPTION", nullable = false)
    private String taskDescription;

    @Column(name = "TASK_PRIORITY", nullable = false)
    private int taskPriority;

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        StringBuilder objString = new StringBuilder();
        objString.append("Task-ID\t" + getTaskID());
        objString.append("\tTask-name\t" + getTaskName());
        objString.append("\tTask-description:\t" + getTaskDescription());
        objString.append("\tTask-priority:\t" + getTaskPriority());
        return objString.toString();
    }
}
