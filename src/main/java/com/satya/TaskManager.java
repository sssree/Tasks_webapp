package com.satya;

import java.sql.SQLException;
import java.util.List;

public class TaskManager {
    public FileRepository database=new database();
   // int idcount=1;
   //int idcount = UUID.randomUUID().variant();
    public TaskManager() {
    }

    /*
        public TaskManager() throws SQLException {
        }
    */
    public void addTask(int id,String s1,String s2,String s3,String s4) {
     Task task=   new Task(id, s1, s2, s3, Status.valueOf(s4));
        database.addTask(task);
      //  idcount += 1;

    }
    public List<Task> display() throws SQLException {
        List<Task> tasks= database.display();
        return  tasks;
    }
    public List<Task> search(int  ab) throws SQLException {
       List<Task> task= database.search(ab);
       return task;
    }
    public void delete(int a) throws SQLException {
        database.delete(String.valueOf(a));
    }
    public  void filter(Status status) throws SQLException{
       database.filter(status);
       // return (List<Task>) task;
    }

    public void updateByStatus(int newid, Status newStatus) {
        database.updateByStatus(newid,newStatus);
    }
}
