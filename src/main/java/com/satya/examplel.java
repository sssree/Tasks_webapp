package com.satya;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class examplel {

    public static void main(String arg[]) throws SQLException {
        TaskManager taskManager=new TaskManager();
       // InMemoryRepository repository=new InMemoryRepository();

        System.out.println("choose one option");
        System.out.println("1.Add 2.list 3.search 4.delete 5. filter 6.exit");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("choice select");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter id");
                    int id=sc.nextInt();
                    System.out.println("Enter name");
                    String s1 = sc.next();
                    System.out.println("description");
                    String s2 = sc.next();
                    String s3=sc.next();
                    System.out.print("enter status");
                    String  s4=sc.next();
                    taskManager.addTask(id,s1,s2,s3,s4);
                    System.out.println("done");
                    break;
                case 3:
                    int ab= Integer.parseInt(sc.next());
                    List<Task> n=taskManager.search(ab);

                        System.out.println( n);
                    break;
                case 2:
                    List<Task> t=taskManager.display();
                    System.out.println(t);
                    break;
                case 4:
                    int d= (sc.nextInt());
                    taskManager.delete(d);
                    break;
                case 5:
                    System.out.println("Enter status");
                    Status status=Status.valueOf(sc.next());
                    taskManager.filter(status);

                    break;
                case 6:
                   System.exit(0);
                    break;
                case 7:
                    System.out.println("Enter id");
                    int newid=sc.nextInt();
                    System.out.println("Enter new status");
                    Status newStatus=Status.valueOf(sc.next());
                    taskManager.updateByStatus(newid,newStatus);
                    break;
                    }

            }

        }
    }


