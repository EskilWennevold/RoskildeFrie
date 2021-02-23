package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ChildHandler {
    static ArrayList<Child> children=new ArrayList<>();
    static ArrayList<Child> waitingList=new ArrayList<>();
    static void createChild(){

        Scanner input=new Scanner(System.in);

        boolean createMoreChildren=true;
        while(createMoreChildren) {
            System.out.println("Enter First Name:");
            String firstName = input.next();

            System.out.println("Enter Last Name:");
            String lastName = input.next();

            int age = 0;
            boolean typedInt = false;
            while (!typedInt) {
                System.out.println("Enter Age:");
                try {
                    age = input.nextInt();
                    typedInt = true;
                } catch (InputMismatchException ime) {
                    System.out.println("You need to enter a whole number!");
                }
            }

            System.out.println("Enter Gender:");
            String gender = input.next();

            System.out.println("Enter Address:");
            input.nextLine();
            String address = input.nextLine();

            System.out.println("Enter Phone Number:");
            String phoneNumber = input.next();

            Child newChild=new Child(firstName, lastName, age, gender, address, phoneNumber);
            if(children.size()<30) {
                children.add(newChild);
                System.out.println("Added " + firstName + " to the kindergarten");
            }else {
                waitingList.add(newChild);
                System.out.println("Added " + firstName + " to the waiting list");
            }

            System.out.println();
            System.out.println("Enter 1 to create more children");
            System.out.println("Enter anything else to return to Children Menu");
            String choice=input.next();
            switch(choice){
                case "1":
                    break;
                default:
                    createMoreChildren=false;
                    break;
            }
        }

    }
    static void readChild(){
        Scanner input=new Scanner(System.in);
        boolean readMoreChildren=true;
        while(readMoreChildren) {
            int index = selectChild();
            Child kid = children.get(index);
            System.out.println(kid);
            System.out.println("Enter 1 to read more children");
            System.out.println("Enter anything else to return to Children Menu");
            String choice=input.next();
            switch(choice){
                case "1":
                    break;
                default:
                    readMoreChildren=false;
                    break;
            }
        }
    }
    static void updateChild(){
        Scanner input = new Scanner(System.in);
        input.useDelimiter(";");
        boolean updateMoreChildren=true;
        while(updateMoreChildren) {
            int index = selectChild();
            Child kid = children.get(index);
            boolean editMoreFields=true;
            while (editMoreFields) {
                System.out.println(kid + "\n");
                System.out.println("What do you want to change:");
                System.out.println("Enter 1 to change First Name");
                System.out.println("Enter 2 to change Last Name");
                System.out.println("Enter 3 to change Age");
                System.out.println("Enter 4 to change Gender");
                System.out.println("Enter 5 to change Address");
                System.out.println("Enter 6 to change Phone Number");
                System.out.println("Enter 0 to return to Update Child Menu");
                int fieldChoise = input.nextInt();
                switch (fieldChoise) {
                    case 1:
                        System.out.println("Enter new first name of kid");
                        kid.firstName = input.next();
                        break;
                    case 2:
                        System.out.println("Enter new last name of kid");
                        kid.lastName = input.next();
                        break;
                    case 3:
                        int age = 0;
                        boolean typedInt = false;
                        while (!typedInt) {
                            System.out.println("Enter age of kid");
                            try {
                                age = input.nextInt();
                                typedInt = true;
                            } catch (InputMismatchException ime) {
                                System.out.println("You need to enter a whole number!");
                            }
                        }
                        kid.age = age;
                        break;
                    case 4:
                        System.out.println("Enter gender of kid");
                        kid.gender = input.next();
                        break;
                    case 5:
                        System.out.println("Enter address of kid");
                        kid.address = input.next();
                        break;
                    case 6:
                        System.out.println("Enter phone number of kid");
                        kid.phoneNumber = input.next();
                        break;
                    case 0:
                        editMoreFields = false;
                        break;
                    default:
                        System.out.println("Enter valid number");
                        break;
                }

                System.out.println(kid);
                System.out.println("Enter 1 to edit more fields");
                System.out.println("Enter anything else to return to Update Children Menu");
                String continueFieldsChoice=input.next();
                switch(continueFieldsChoice){
                    case "1":
                        break;
                    default:
                        editMoreFields=false;
                        break;
                }
            }

            System.out.println("Enter 1 to update more children");
            System.out.println("Enter anything else to return to Children Menu");
            String continueFieldsChoice=input.next();
            switch(continueFieldsChoice){
                case "1":
                    break;
                default:
                    updateMoreChildren=false;
                    break;
            }
        }
    }
    static void deleteChild(){
        int index = selectChild();
        System.out.println("You deleted: " + children.get(index).firstName+"\n");
        children.remove(index);
        if(waitingList.size()>0){
            children.add(waitingList.get(0));
            System.out.println("Added " + waitingList.get(0).firstName + "\nfrom the waiting list to the kindergarten\n");
            waitingList.remove(0);
        }
        printChildList();
    }
    static void printChildList(){
        System.out.println("Children List:");
        for(int i=0;i<children.size();i++){
            Child kid=children.get(i);
            System.out.println((i+1)+" "+kid.firstName+" "+kid.lastName);
        }
        System.out.println();
    }
    static void printWaitingList(){
        System.out.println("Waiting List:");
        for(int i=0;i<waitingList.size();i++){
            Child kid=waitingList.get(i);
            System.out.println((i+1)+" "+kid.firstName+" "+kid.lastName);
        }
        System.out.println();
    }
    static int selectChild(){
        printChildList();
        Scanner input=new Scanner(System.in);
        int index=0;

        boolean typedInt=false;
        while(!typedInt){
            System.out.println("Select Child:");
            try {
                index = input.nextInt();
                if(index>0 && index<=children.size()) {
                    typedInt = true;
                }else{
                    System.out.println(index+ "is not valid!");
                }
            }catch(InputMismatchException ime){
                System.out.println("You need to enter a whole number!");
            }
        }
        System.out.println();

        return index-1;
    }
}
