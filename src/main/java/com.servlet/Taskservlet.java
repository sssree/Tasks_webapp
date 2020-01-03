package com.servlet;

import com.satya.Task;
import com.satya.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Taskservlet extends HttpServlet {

    public Taskservlet() {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TaskManager taskManager=new TaskManager();
        try {
         List<Task> list=taskManager.display();
         PrintWriter out=resp.getWriter();
         out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
           String des=req.getParameter( "des");
           String date=req.getParameter("date");
           String status=req.getParameter("status");

           TaskManager taskManager=new TaskManager();

            taskManager.addTask(id,name,des,date,status);


    }


}
