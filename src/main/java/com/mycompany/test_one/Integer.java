/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_one;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Babak
 */
public class Integer {

    List mylist = new ArrayList();
    public int num;

    Integer() {
        num = 0;
    }

    public void printFunc() {
        //list initialization
        for (int i = 0; i <= 100; i++) {

            mylist.add(i);

        }
        for (int i = 1; i <= 100; i++) {

            num = mylist.indexOf(i);

          //casting string to integer
            int number = (int) mylist.get(i);
            if (number % 3 == 0) {
                mylist.set(num, "Hello");
            } else if (number % 5 == 0) {
                mylist.set(num, "World");

            } else if ((number % 3 == 0) & (number % 5 == 0)) {
                mylist.set(num, "Hello World");
            }

        }

    }

}
