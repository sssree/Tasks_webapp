package com.satya;

import java.util.List;

public interface FileRepository {
    public void addTask(Task task) ;
    public List<Task> display() ;
    public List<Task> search(int input) ;
    public  void delete(String input) ;
    public  Task filter(Status status) ;
    public void updateByStatus(int newid, Status newStatus);
}
