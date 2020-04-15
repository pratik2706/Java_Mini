/*Attendance Manager*/
/*
Made by
Ishwari Dawkhar 232012(ROll no)
Sanket Deshmane 232014(ROll no)
Pratik Jagtap 232029(ROll no)
Digvijay Desai 232012(ROll no)
*/
import java.util.Scanner;

class User {
	protected String userName;
	protected String email;
	protected String password;
	Scanner sc=new Scanner(System.in);

	User(){
		
		userName = email = password = " ";
	
	}
	
	public void AcceptDetails(){}

}

class Teacher extends User {
	
	String ID;
	
	public void AcceptDetails() {
		
	
		
		System.out.println("Enter ID: ");
		ID = sc.nextLine();
		
		System.out.println("Enter name:");
		userName = sc.nextLine();
		
		System.out.println("Enter password:");
        password = sc.nextLine();
        
        
	}
	
	public void displayData() {
		System.out.println(ID + "\t\t" + userName);
	}
	
	public int search(final String number, final String password) {
        if (ID.equals(number) && this.password.equals(password)) {
            return 1;
        } else
            return 0;
    }
	
	
}


class Student extends User {
	
	int rollNo;
	String dept;
	int attendance;
	
	Student(){
		
		rollNo = -1;
		dept = "";
		attendance = 0;
	
	}
	public int get_rollno() {
		
      return rollNo;
    
	}

	
	public void AcceptDetails() {
		
		System.out.println("Enter name:");
		userName = sc.nextLine();
		
		System.out.println("Enter password:");
        password = sc.nextLine();
        
		System.out.println("Enter Department:");
	    dept = sc.nextLine();
	      
		System.out.println("Enter Roll number:");
        rollNo = sc.nextInt();
        sc.nextLine();

	}
	
	public int search(final int number, final String password) {
        if (this.rollNo == number && this.password.equals(password)) {
            return 1;
        } else
            return 0;
    }
	public void markAttendance() {
		attendance++;
	}
	public void DisplayAttendance(){
		
		System.out.println(rollNo + "\t" + attendance + "\t\t\t" + userName);
	}
	
	public void displayDetails() {

		System.out.println(rollNo + "\t\t" + dept + "\t\t\t" + attendance + "\t\t\t" + userName);
    
	}
	
	public void changePassword(final String Npassword) {
		password = Npassword;
	}

}


public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Student[] S = new Student[100];
		Teacher[] T = new Teacher[10];		
		 
		int choice ,size = 0;
		String adminID = "ADMIN";
		String adminPassword = "ADMIN";
		String ID, password;
		do {
			
			System.out.println("\n1.Admin\n2.Teacher\n3.Student\n99.EXIT");
			System.out.print("\t\tEnter your choice: ");
			choice = sc.nextInt();
			
			
			switch(choice) {
			
			case 1:
				System.out.print("\nEnter User ID: ");
				ID = sc.next();
				
				System.out.print("\nEnter password: ");
				password = sc.next();
				
				if(ID.equals(adminID) && password.equals(adminPassword)) {
					System.out.println("\t\tLOGIN Successful");
					adminCase(S, T);
					
				}else 
					System.out.println("\t\tERROR : Incorrect credentials! ");
				break;
			case 2:
                               teacherCase(S, T);
                               break;
			case 3:
				studentCase(S);
				break;
			}
				
		}while(choice != 99);

				
		sc.close();
	}
	static int sizeT = 0, sizeS = 0;
	public static void adminCase(Student S[], Teacher T[]) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			
			System.out.println("\n1.Create Students\n2.Display students attendance\n3.Add Teachers\n4.DIsplay Teachers\n99.EXIT");
			System.out.print("\t\tEnter your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter number of students to add(100 max): ");
				sizeS = sc.nextInt();
				if(sizeS > 100) {
					System.out.println("Size limit exceeded");
					System.out.println("Enter number of Students to add again(10 max): ");
					sizeS = sc.nextInt();
				}
				for (int i = 0; i < sizeS; i++)
				    S[i] = new Student();
				
				for(int i = 0; i < sizeS; i++)
					S[i].AcceptDetails();
				break;
			case 2:
				System.out.println("Roll No\tTotal Attendance\tStudent Name");
				for(int i = 0; i < sizeS; i++)
					S[i].DisplayAttendance();
				break;
			case 3:
				System.out.println("Enter number of Teachers to add(10 max): ");
				sizeT = sc.nextInt();
				if(sizeT > 10) {
					System.out.println("Size limit exceeded");
					System.out.println("Enter number of Teachers to add again(10 max): ");
					sizeT = sc.nextInt();
				}
					
				for (int i = 0; i < sizeT; i++)
					T[i] = new Teacher();
			
				for(int i = 0; i < sizeT; i++)
					T[i].AcceptDetails();
				break;
			case 4:
				System.out.println("ID\t\tTeacher Name");
				for(int i = 0; i < sizeT; i++)
					T[i].displayData();
				
			}
			
				
		}while(choice != 99);
	}
	
	public static void teacherCase(Student S[], Teacher T[]) {
		 Scanner sc = new Scanner(System.in);
                String number, pass;
                int i;
                int x = 0;
                int p = 0;
                int k;
                int choice; 
                System.out.println("Enter ID: ");
                number = sc.next();
                System.out.println("Enter Password: ");
    	        pass = sc.next();
    	        
                for(i=0;i<sizeT;i++)
                {
                x=T[i].search(number, pass);
                  if(x==1)
                  {
                     p=i;
                    break;
                  }
                }
                if(x==1)
                {
                     System.out.println("\nLogin Successfull");
                     do {
			
			System.out.println("\n1-Displaydata\n2.Mark Attemdance \n3-Display Attendance\n99.EXIT");
			System.out.print("\t\tEnter your choice: ");
		        choice = sc.nextInt();
			
			switch(choice) {
                       case 1 : System.out.println("ID\t\tTeacher Name");
                    	   T[p].displayData();
                                break;
			
			case 2: System.out.println("If student is present enter 1 else enter 0");
                               for(i=0;i<sizeS;i++)
                               {
                                 k= S[i].get_rollno();
                                 System.out.println("Roll No "+k+" is present/absent");
                                 int e=sc.nextInt();
                                 if(e==1)
                                 S[i].markAttendance();
                               }
				
				break;
			case 3: 
                                 System.out.println(" Displaying Attendace");
                                 System.out.println("Roll No\tTotal Attendance\tStudent Name");
                               for(i=0;i<sizeS;i++)
                               {
                                   S[i].DisplayAttendance();
                               }
				
				break;
                        default : System.out.println("\nWrong Choice");
			}
			
				
		}while(choice != 99);
                     
                     
                  }else      
                   System.out.println("Login unsuccessfull"); 
		
	}
	
	 public static void studentCase(Student S[]) {
	        Scanner sc = new Scanner(System.in);
	        int op,i; int number ; String Npassword,p;
	        int m=0; int n=0;
	        System.out.println("Enter Roll number: ");
	        number = sc.nextInt();
	        System.out.println("Enter Password: ");
	        p = sc.next();
	        
	        for( i=0; i<sizeS;i++)
	        {
	            m=S[i].search(number, p);
	            if(m==1)
	            {
	                n=i;
	                break;
	            }
	        }
	        if(m==1)
	        {
	            System.out.println("\n login sucessful");
	            do{
	            System.out.println("\n1. View Student Information\n2. View Attendance\n3. Change password\n4. EXIT");
	            System.out.println("\t\tEnter your choice: ");
	            op=sc.nextInt();
	            switch(op)
	            {
	            case 1:System.out.println("rollNo" + "\t\t" + "Department" + "\t\t" + "attendance" + "\t\t" + "Student Name");
	            	   S[n].displayDetails();
	                   break;
	            case 2:System.out.println("Roll No\tTotal Attendance\tName");
	            	    S[i].DisplayAttendance();
	                    break;
	            case 3:
	                    System.out.println("enter New password");
	                    Npassword = sc.next();
	                    if(Npassword.equals(p))
	                    {
	                        System.out.println("Password cannot be same as the previous one");
	                    } 
	                    else
	                    {
	                        S[i].changePassword(Npassword);
	                    	System.out.println("Password changed succesfully");
	                    }
	                    break;
	           default:System.out.println("Enter choice according to menu");
	       }
	        }while(op!=4);
	        }else
	        System.out.println("Login Unsucessfull");
	    }

}
