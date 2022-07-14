import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class Main
{
    static int s_d, p_d;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {        
        store();                                    // this method will store data of Employees 
                                                    // and passengers in the database.
    }   

    static void store()
    {
        Employee[] s = new Employee[50];   // object arrays ;
        Passenger[] p = new Passenger[50]; 
        
        while(true)     // shall run until break is used ; therefore called as an infinite loop
        {   System.out.println("----------------- ");
            System.out.println("1.Employee\n2.Passenger");
            System.out.println("----------------- ");
            System.out.print("Enter whose data you wish to store : ");
            int n1  = sc.nextInt();    
            switch(n1)
            {
                //Storing data for Employee
                case 1:  
                    System.out.print("Enter the number of Employee whose data needs to be stored : ");
                    s_d = sc.nextInt();           
                    for(int i=1;i<=s_d;i++)
                    {
                        System.out.println("\nFor Employee at Position "+ i);
                        
                        s[i] = new Employee();    // new object creation
                        s[i].infoEmployee();        // every s[i] is an object of Employee and will have
                                                    // its own infoEmployee(); and unique_id;
                    }
                    break;
                    
                //Strong data for passengers
                case 2:
                    System.out.print("Enter the number of passengers whose data needs to be stored : ");
                    p_d = sc.nextInt();
                    //p = new Passenger[p_d];
                    for(int i=1;i<=p_d;i++)
                    {
                        System.out.println("\nFor Passenger at Position "+ (i));
                        p[i] = new Passenger();
                        p[i].infoPassenger();
                        // every p[i] is an object of Passenger 
                    }
                    break;
                default:
                    System.out.println("Wrong Choice\nPlease enter correct option!");
            }
            
            System.out.print("\nDo you wish to store more? (Y/N): ");       
            char ans = sc.next().charAt(0);
            System.out.print("\n");
            if (ans == 'N')
            {
                // used N, meaning storing is done now , proceeding for output or retrival if asked for
                display(s,p);
            }
        }       
    }

    static void display(Employee[] s, Passenger[] p)
    {
        while(true)
        {
            System.out.println("----------------- ");
            System.out.println("1.Employee\n2.Passenger");
            System.out.println("----------------- ");
            System.out.print("Enter whose data you wish to retrive : ");
            int n2 = sc.nextInt();
            
            switch(n2)
            {
                // displaying data for Employee
                case 1:
                    System.out.print("Enter the position of staff in data whose Id Card you want to generate : ");
                    int s_p = sc.nextInt();
                    System.out.println("\nGenerating id card............\n");
                    
                    // try catch block is used ; if no error then try is executed else error is caught
                    // using catch and e.getMessage() gives message.
                    try
                    {
                        Thread.sleep(5000);
                        // 5000ms = 5secs 
                        // used to show a pause and pretend that the application is taking time to access the database.
                    }
                    catch(InterruptedException e)
                    {
                        System.err.println(e.getMessage());
                    }
                    
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t-----Employee ID Card-----");
                    System.out.println("\t\t\t\t\tAirport Authority of India");
                    System.out.println("\t\t\t\t  Dr. Babasaheb Amedkar International Airport");
                    s[s_p].displayEmployee();
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    break;
                
                //displaying data for passenger
                case 2:
                    System.out.print("Enter the position of passenger in data whose Boarding Pass you want to generate : ");
                    int p_p = sc.nextInt();
                    System.out.println("\nGenerating Boarding Pass.......... \n");
                    // try catch block is used ; if no error then try is executed else error is caught
                    // using catch and e.getMessage() gives message.
                    try
                    {
                    Thread.sleep(5000);
                    // 5000ms =  5 secs
                    }
                    catch(InterruptedException e)
                    {
                    System.err.println(e.getMessage());
                    }
                    
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t-----Boarding Pass-----");
                    System.out.println("\t\t\t\t\tAirport Authority of India");
                    p[p_p].displayPassenger();
                    System.out.println("\n\t\t\t\t\tWishing you a Happy and Safe journey!");
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Wrong Choice\nPlease enter correct option!");
            }
            System.out.print("\nDo you wish to retrive more? (Y/N): ");
            char ans = sc.next().charAt(0);
        
            System.out.print("\n");
            if (ans == 'N')
            {
                System.exit(0);
                // to end the program abruptly
                
            }
        }
    } 
}

class Details
{
    Scanner sc = new Scanner(System.in);
    String name,age;
    void infoDetails()
    {
        System.out.print("Enter the name : ");
        name = sc.nextLine();
        System.out.print("Enter the age : ");
        age = sc.nextLine();
    }
    void displayDetails()
    {
        System.out.print("Name : " + name +"\t\t\t\t\t\t\t");
        System.out.println("Age : " + age);
    }
}

// Employee class to enter Staff entries


// Employee is child class and uses everything of Details(parent class)
class Employee extends Details
{
    String unique_id;
    
    
    // method overriding is done here ; OOP
    void infoEmployee()
    
    {
        infoDetails();
        System.out.print("Enter unique id of the employee : ");
        unique_id = sc.nextLine();
    }
    void displayEmployee()
    {
        displayDetails();
        System.out.println("Unique id: " + unique_id);
    }
}

// Passenger class to enter Passenger entries

// Passenger is child class ; Details is parent class
class Passenger extends Details
{
    String source, destination;
    int randomSeatNumber;
    int seatNumber()
    {   int j=0;
        boolean flag=true;
        int[] randomNumbers = new int[50];
        while(flag)
        {   Random seat_no =new Random();
        
            // Random class used to generate random number.
            int n = 1 + seat_no.nextInt(50);
            for(int i=0 ;i<50;i++)
            {
               if(n==randomNumbers[i])
                {
                    flag=true;
                    break;
                }
            else if(randomNumbers[i]==0)
            {
                flag=false;
                randomNumbers[i]=n;
                j=n;
                break;
            }
            }
        }
    return j;
    }
    void infoPassenger()
    {   
        infoDetails();
        System.out.print("Enter the Source : ");
        source = sc.nextLine();
        System.out.print("Enter the Destination : ");
        destination = sc.nextLine();
        randomSeatNumber = seatNumber();
        
    }
    void displayPassenger()
    {
        displayDetails();
        System.out.print("Source : " + source+"\t\t\t\t\t\t\t");
        System.out.println("Destination : " + destination);
        System.out.print("Seat Number : "+ randomSeatNumber + "\t\t\t\t\t\t\t");
        System.out.println("Date and Time : "+ new Date());
    }
}
