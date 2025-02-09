package com.example.todoapp;

public class TaskModel {

    int id;
    String task;
    boolean isCompleted;

    public TaskModel(int id, String task, boolean isCompleted) {
        this.id = id;
        this.task = task;
        this.isCompleted = isCompleted;
    }

}
