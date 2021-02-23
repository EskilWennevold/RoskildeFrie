package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        FileHandler.loadChildren();
        Scanner scan = new Scanner(System.in);

        menu(scan);
        FileHandler.saveChildren();
    }
    public static void menu(Scanner scan){
        int svar = 1;
        while(svar != 0) {
            System.out.println("Roskilde Free Kindergarten");
            System.out.println("==================================");
            System.out.println();
            System.out.println("Enter 1 for Child menu");
            System.out.println("Enter 2 for Caretaker menu");
            System.out.println("Enter 3 for Parent menu");
            System.out.println("Enter 0 to save and end program");
            svar = scan.nextInt();
            switch(svar){
                case 0:
                    System.out.println("Saving and ending program");
                    break;
                case 1:
                    childMenu(scan);
                    break;
                case 2:
                    //caretakerMenu();
                    break;
                case 3:
                    //parentMenu();
                    break;
            }
        }
    }

    public static void childMenu(Scanner scan) {
        int svar = 1;
        while(svar != 0) {
            System.out.println("Child Menu");
            System.out.println("==================================");
            System.out.println();
            System.out.println("Enter 1 to Create new Child");
            System.out.println("Enter 2 to Edit a Child");
            System.out.println("Enter 3 to Read the child's information");
            System.out.println("Enter 4 to Delete a Child from the register");
            System.out.println("Enter 5 to Print child list");
            System.out.println("Enter 6 to Print waiting list");
            System.out.println("Enter 0 to return to Main Menu");
            svar = scan.nextInt();

            switch(svar){
                case 0:
                    System.out.println("Returning to Main Menu");
                    break;
                case 1:
                    ChildHandler.createChild();
                    break;
                case 2:
                    ChildHandler.updateChild();
                    break;
                case 3:
                    ChildHandler.readChild();
                    break;
                case 4:
                    ChildHandler.deleteChild();
                    break;
                case 5:
                    ChildHandler.printChildList();
                    break;
                case 6:
                    ChildHandler.printWaitingList();
                    break;
                default:
                    System.out.println("Enter valid number");
                    break;
            }
        }

    }

}
