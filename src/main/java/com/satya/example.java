package com.satya;

import java.util.ArrayList;
import java.util.Scanner;

public class example {

    public static void main(String arg[]) {
        System.out.println("choose one option");
        System.out.println("1.Add 2.list 3.search 4.exit");
        Scanner sc = new Scanner(System.in);

        ArrayList<String> a = new ArrayList<String>();
       while (true) {
           System.out.print("choice select");
           int x = sc.nextInt();
           switch (x) {
                case 1:
                    String s = sc.next();
                    a.add(s);
                    System.out.println("done");
                    break;
                case 3:
                    String f=sc.next();

                    if(a.contains(f)){System.out.println("Yes");}
                    else
                        System.out.println(("Not found"));
                    break;
                case 2:
                        System.out.println(a);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        }
    }
}
