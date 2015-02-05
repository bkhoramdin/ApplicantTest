/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_one;

/**
 *
 * @author Babak
 */
public class TestONE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Integer obj = new Integer();

        obj.num = 0;
        obj.printFunc();

        for (int i = 1; i <= 100; i++) {
            System.out.println("\t" + obj.mylist.get(i));

        }

    }

}
