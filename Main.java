/*
 * Welcome to Student Management Application !!!
 * Here we implement our database by the jdbc api.
 */

import java.util.*;

public class Main{

    public static Scanner sc = new Scanner(System.in);
    public static StudentDaoInterface dao = new StudentDao();

    

    public static void main(String[] args) {
        
        System.out.println("Welcome to Student Management application.");

        while(true){
            System.out.println("\n1.Add Student"+
                                "\n2.Show all students"+
                                "\n3.Get student based on rollnumber"+
                                "\n4.delete student"+
                                "\n5.update student"+
                                "\n6.exit"
                                );
        
            System.out.println("Enter choice : ");
            int ch = sc.nextInt();

                if(ch == 1){
                    System.out.println("Add Student");

                    System.out.println("Enter Student name ");
                    String name = sc.next();
            
                    System.out.println("Enter college name ");
                    String clgName = sc.next();
                    
                    System.out.println("Enter city");
                    String city=sc.next();
                    System.out.println("Enter Percentage");
                    double percentage=sc.nextDouble();
            
                    Student s =new Student(name,clgName,city,percentage);
                    boolean ans = dao.insert(s);
            
                    if(ans)System.out.println("Record inserted successfully..");
                    else System.out.println("something went wrong..");
                }

                else if(ch == 2){
                    System.out.println("****** Show all students ****");
                    dao.showAllStudent();
                }
                else if(ch  == 3){
                    System.out.println("Get student based on roll number");
                    System.out.println("Enter roll : ");
                    int roll = sc.nextInt();
                    boolean ans =  dao.showStudentById(roll);
                    if(!ans)System.out.println("This student is not available ..");
                }
                    
                else if(ch == 4)
                {
                    System.out.println("Delete Student");
                    System.out.println("Enter roll no to delete : ");
                    int rollnum = sc.nextInt();
                    boolean ans = dao.delete(rollnum);
                    if(ans)System.out.println("Record deleted successfully !!!");
                    else System.out.println("Something went wrong....");
                }
                else if(ch == 5)
                    System.out.println("Update the student");    
            
                else if(ch == 6){
                    System.out.println("Thank you for using student management app");
                    System.exit(0);
                }
                else
                    System.out.println("Please  enter valid choice..");
            }
        
        
}



}