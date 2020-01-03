package com.satya;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database  implements FileRepository {
    Connection connection;
    Statement statement;
    public database()  {
  
     createconnection();
    }
    public void createconnection(){
        String url="jdbc:mysql://localhost:3306/testdb";
        String username="testuser";
        String password="password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection( url,username,password);
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addTask(Task task)  {
        String q = "insert into task values(" + task.getTaskId() + ",\"" + task.getName() + "\",\"" + task.getDes() + "\",\"" + task.getDate()
                    + "\",\"" + task.getStatus() + "\")";
            System.out.println(q);
        try {
            statement.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public List<Task> display()  {
        List<Task> n= new ArrayList();
        try {
            String q = "select * from task";
            ResultSet rs = statement.executeQuery(q);
            if(rs.next()){
                do{
                    Task t=new Task();
                    t.setTaskId(rs.getInt(1));
                    t.setName(rs.getString(2));
                    t.setDes(rs.getString(3));
                    t.setDate(rs.getString(4));
                    t.setStatus(Status.valueOf(rs.getString(5)));
                    n.add(t);
                    System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
                }while(rs.next());
            }
            else{
                System.out.println("Record Not Found...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }



        return n;
    }

    @Override
    public List<Task> search(int input)  {
      ArrayList list=new ArrayList() ;
        try {

            String q="Select * from task where taskId='"+input+"'";
       //    System.out.println(q);

         ResultSet  rs = statement.executeQuery(q);
            while(rs.next())
            {
                Task t=new Task();
              t.setTaskId(rs.getInt(1));
              t.setName(rs.getString(2));
              t.setDes(rs.getString(3));
              t.setDate(rs.getString(4));
              t.setStatus(Status.valueOf(rs.getString(5)));
               // System.out.println(t);
              list.add(t);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //finally {


       // System.out.println(list);
        return list;
    }

    @Override
    public void delete(String input)  {

        // to execute query
        try {
            String q=" delete from task where taskId ="+input;
            statement.executeUpdate(q);
            System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Task filter(Status status) {
        Task t = new Task();
        try {
            String q = " select * from task where status ='" + status + "'";
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {

                t.setTaskId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setDes(rs.getString(3));
                t.setDate(rs.getString(4));
                t.setStatus(Status.valueOf(rs.getString(5)));
                System.out.println(t);
                // list.add(t);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public void updateByStatus(int newid, Status newStatus) {
        try {
            String q = " update task set status ='" + newStatus + "'where id='"+newid;
            String rs = String.valueOf(statement.executeUpdate(q));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}