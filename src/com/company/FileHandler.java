package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    static String filePath="/Users/eskilwennevold/IdeaProjects/RoskildeFrie/src/com/company/children.txt";
    static File childrenFile=new File(filePath);

    public static void loadChildren(){
        Scanner fileReader;
        try{
            fileReader=new Scanner(childrenFile);
            while(fileReader.hasNextLine() && fileReader.hasNext()) {
                Scanner lineScan = new Scanner(fileReader.nextLine());
                lineScan.useDelimiter(";");
                String firstName = lineScan.next();
                String lastName = lineScan.next();
                int age = lineScan.nextInt();
                String gender = lineScan.next();
                String address = lineScan.next();
                String phoneNumber = lineScan.next();
                ChildHandler.children.add(new Child(firstName, lastName, age, gender, address, phoneNumber));
            }
            if(ChildHandler.children.size()>30){
                ChildHandler.waitingList=new ArrayList<Child>(ChildHandler.children.subList(30,ChildHandler.children.size()));
                ChildHandler.children=new ArrayList<Child>(ChildHandler.children.subList(0,30));
            }
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe + "Could not find file.");
        }
    }
    public static void saveChildren() throws FileNotFoundException{
        PrintStream output = new PrintStream(filePath);
        if(ChildHandler.children.size>0) {
            ListNode currentNode=ChildHandler.children.first;
            Child kid = currentNode.data;
            while (currentNode.next != null) {
                kid = currentNode.data;
                writeChildrenData(kid, output);
                currentNode = currentNode.next;
            }
            kid = currentNode.data;
            writeChildrenData(kid, output);
            if(ChildHandler.waitingList.size>0) {
                currentNode = ChildHandler.waitingList.first;
                while (currentNode.next != null) {
                    kid = currentNode.data;
                    writeChildrenData(kid, output);
                    currentNode = currentNode.next;
                }
                kid = currentNode.data;
                writeChildrenData(kid, output);
            }
        }
    }
}
