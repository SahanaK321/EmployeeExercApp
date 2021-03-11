package com.capg.abc.main;

import java.util.Scanner;

import com.capg.abc.db.EmployeeDB;
import com.capg.abc.dto.Employee;
import com.capg.abc.service.EmployeeServiceImpl;
import com.capg.abc.service.IEmployeeService;

public class EmployeeMain {
	
	IEmployeeService empService = new EmployeeServiceImpl();
	
	public static void main(String[] args) {
		
		EmployeeMain app = new EmployeeMain();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" === MENU ==== ");
			System.out.println("1. add employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Edit salary based on id ");
			System.out.println("4. Edit experience based on id ");
			System.out.println("5. Get Employees by Salary ");
			System.out.println("6. Get employees by salary range ");
			System.out.println("7. Get employees by exp ");
			System.out.println("0. EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch(option)
			{
			
			case 1:
				
				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();
				
				Employee e = new Employee(empId, name, empExp, empSalary);
				
				try
				{
					boolean isInserted = app.empService.addEmployee(e);
					if(isInserted)
					{
						System.out.println(" Employee Added !!!");
					}
					else
					{
						 throw new Exception("Cannot added Employee ...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				
				break;
			case 2:
				
				Employee arr[] = app.empService.getAllEmployees();
				int count = EmployeeDB.count;  // not the code
				System.out.println("  --->>  count in main "+count);
				for (int i = 0; i < count; i++) {
					System.out.println(arr[i]);
					System.out.println(" ========================================================");
				}
				break;
				
			case 3:
				   System.out.println("Enter employee id");
			       int EmpId= Integer.parseInt(sc.nextLine());
			       
				   System.out.println("Enter  salary");
				   int EmpSalary= Integer.parseInt(sc.nextLine());
				 
				   try {  
				        if(app.empService.editSalaryByEmployeeId(EmpId,EmpSalary))
					         System.out.println("salary changed");
				        else
				        {
					         throw new Exception("cant find emp id");
				        }
				     }  catch(Exception ex) {
				    	 
					 System.out.println("customer care"+ex);
				 }
				   break;
			case 4:
				
	            System.out.println("Enter employee id");
				int EmpID= Integer.parseInt(sc.nextLine());
				System.out.println("Enter exp");
				int EmpExp= Integer.parseInt(sc.nextLine());
				
				try {
					if(app.empService.editExpByEmployeeId(EmpID,EmpExp))
						System.out.println("exp changed");
					else {
						    throw new Exception("cant find emp id");
					     }
				    } catch(Exception ex) {
					System.out.println("customer care"+ex);
				   }
					break;
					
			case 5:
				System.out.println("Enter employee salary");
				 int Empsalary= Integer.parseInt(sc.nextLine());
				 
				 Employee[] emp=app.empService.getEmployeeBySalary(Empsalary);
				 for(int i=0;i<emp.length;i++)
				 {
					 System.out.println(emp[i]);
				 }
				break;
				
			case 6:
				 System.out.println("Enter min salary");
				 int Empsalary1= Integer.parseInt(sc.nextLine());
				 
				 System.out.println("Enter max salary");
				 int Empsalary2= Integer.parseInt(sc.nextLine());
				 
				 Employee[] emps=app.empService.getEmployeesBySalaryRange(Empsalary1,Empsalary2);
				 for(int i=0;i<emps.length;i++)
				 {
					 System.out.println(emps[i]);
				 }
				 break;
				 
			case 7:
				System.out.println("Enter exp");
				int Empexp = Integer.parseInt(sc.nextLine());
				
				Employee[] emp1=app.empService.getEmployeesByExperience(Empexp);
				 for(int i=0;i<emp1.length;i++)
				 {
					 System.out.println(emp1[i]);
				 }
				break;
				
				
				
			case 0:
				System.exit(0);
			
			
			
			}//end switch
			
		}// end while
		
		
		
	}//end main

}//end class
