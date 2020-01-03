package com.satya;

import java.util.ArrayList;

public class Task extends ArrayList {
   public String name;
    public String des;
    public String date;
    public Status status;
    public int taskId;
   // public Task(String s1, String s2, String s3, Status status, int taskId){};


    public Task( int taskId,String name, String des, String date, Status status) {
        this.taskId = taskId;
        this.name = name;
        this.des = des;
        this.date = date;
        this.status = status;

    }

    public Task(String s1, String s2, String s3, Status status) {

    }

    public Task() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public boolean setTaskId(int taskId) {
        this.taskId = taskId;
        return false;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", taskId=" + taskId +
                '}';
    }
}
