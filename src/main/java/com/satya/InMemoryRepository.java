package com.satya;

import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository {

        List<Task> alist = new ArrayList<>();

    //return alist;


    //List<Task> alist = new ArrayList<>();
    public void addTask(Task task) {

        alist.add(task);
    }
    public List<Task> display(){
      return alist;
    }
    public Task search(String input){
        Task l = null;
        for (Task s:alist)
        {
            if(s.name.matches(input)){
                l=s;
            }
        }
        return l;
    }

    public  void delete(int input) {
        for (Task task:alist){
           if(task.getTaskId() ==input)
                 alist.remove(task);
            }
    }
    public  List<Task> filter(String status){
        Task l = null;
        for (Task s:alist)
        {
            if(s.name.matches(status)){
                l=s;
                return (List<Task>) l;
            }
        }
        return null;
    }

}
