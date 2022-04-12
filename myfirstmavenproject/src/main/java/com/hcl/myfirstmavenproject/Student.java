package com.hcl.myfirstmavenproject;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String rollno; // Student number
    private String name; // full name
    private int age; // Age
    private String ContactNo; // ContactNo

    public Student() {
    }

    public Student(String rollno, String name, int age, String ContactNo) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.ContactNo = ContactNo;
    }

    public String getrollno() {
        return rollno;
    }

    public void setrollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }



    public static void main(String[] args) {

        // Create a collection container object
        ArrayList<Student> list = new ArrayList<>();

        lo:
        while (true) {
            // 1. Build the main interface menu
            System.out.println("--------Welcome to the student management system--------");
            System.out.println("1 Add students");
            System.out.println("2 Delete students");
            System.out.println("3 Update students");
            System.out.println("4 View students");
            System.out.println("Please enter your choice:");

            String choice = new Scanner(System.in).next();

            switch (choice) {
                case "1":
                    //System.out.println("add student");
                    addStudent(list);
                    break;
                case "2":
                    //System.out.println("delete student");
                    deleteStudent(list);
                    break;
                case "3":
                    //System.out.println (the "revised student");
                    updateStudent(list);
                    break;
                case "4":
                    // System.out.println("view students");
                    queryStudents(list);
                    break;
   
                default:
                    System.out.println("Your input is wrong");
                    break lo;
            }
        }


    }

    // How to modify students
    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("Please input the student number you want to modify:");
        Scanner sc = new Scanner(System.in);
        String updaterollno = sc.next();
        // 3. Call getIndex method to find the index position of the student number in the collection
        int index = getIndex(list,updaterollno);
        // 4. Judge whether the student number exists in the set according to the index
        if(index == -1){
            // Does not exist: prompt
            System.out.println("No information, Please re-enter");
        }else{
            // Presence: receiving new student information
            System.out.println("Please enter a new student name:");
            String name = sc.next();
            System.out.println("Please enter the new student age:");
            int age = sc.nextInt();
            System.out.println("Please enter a new student's ContactNo:");
            String ContactNo = sc.next();
            // Encapsulate as a new student object
            Student stu = new Student(rollno, name, age, ContactNo);
            // Call the set method of the collection to complete the modification
            list.set(index, stu);
            System.out.println("Modified successfully!");
        }
    }

    // How to delete students
    public static void deleteStudent(ArrayList<Student> list) {
        // 1. Give prompt information
        System.out.println("Please enter the student number you want to delete:");
        // 2. The keyboard receives the student number to be deleted
        Scanner sc = new Scanner(System.in);
        String deleterollno = sc.next();
        // 3. Call getIndex method to find the index position 
        int index = getIndex(list,deleterollno);
        // 4. Judge whether the student number exists in the set according to the index
        if(index == -1){
            // Does not exist: prompt
            System.out.println("No information, Please re-enter");
        }else{
            // Existing: delete
            list.remove(index);
            System.out.println("Successfully deleted!");
        }
    }

    // How to view students
    public static void queryStudents(ArrayList<Student> list) {
        // 1. Judge whether there is data in the set, if not, give a prompt directly
        if(list.size() == 0){
            System.out.println("no message, Please add and query again");
            return;
        }
        // 2. Presence: displays the header data
        System.out.println("Roll No\t\t full name\t Age\t ContactNo");
        // 3. Traverse the collection, get the information of each student object, and print it on the console
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getrollno() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getContactNo());
        }
    }

    // How to add students
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        // 1. Give the input prompt information

        String rollno;

        while(true){
            System.out.println("Please input student number:");
            rollno = sc.next();

            int index = getIndex(list, rollno);

            if(index == -1){
                // rollno does not exist, student number can be used
                break;
            }
        }

        System.out.println("Please enter your name:");
        String name = sc.next();
        System.out.println("Please enter age:");
        int age = sc.nextInt();
        System.out.println("Please enter your ContactNo:");
        String ContactNo = sc.next();
        // 2. Encapsulate the information entered by the keyboard as the student object
        Student stu = new Student(rollno,name,age,ContactNo);
        // 3. Add the encapsulated Student object to the collection container
        list.add(stu);
        // 4. Give the message of adding success
        System.out.println("Added successfully!");
    }

    /*
        getIndex : Receive a collection object, receive a student number

        Find the index position of the student number in the collection
     */
    public static int getIndex(ArrayList<Student> list, String rollno){
        // 1. Suppose the incoming student number does not exist in the set
        int index = -1;
        // 2. Traverse the collection, get each student object, ready to search
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            // 3. Get the student number of each student
            String id = stu.getrollno();
            // 4. Use the obtained student number to compare with the incoming student number
            if(id.equals(rollno)){
                // Existence: let the index variable record the correct index position
                index = i;
            }
        }

        return index;
    }
}