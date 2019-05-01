package com.example.cs125_final_project;

public class MyTaskItem {

    String task_title;
    String task_detail;
    String task_length;

    public MyTaskItem() {
    }

    public MyTaskItem(String task_title, String task_detail, String task_length) {
        this.task_title = task_title;
        this.task_detail = task_detail;
        this.task_length = task_length;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getTask_detail() {
        return task_detail;
    }

    public void setTask_detail(String task_detail) {
        this.task_detail = task_detail;
    }

    public String getTask_length() {
        return task_length;
    }

    public void setTask_length(String task_length) {
        this.task_length = task_length;
    }
}
