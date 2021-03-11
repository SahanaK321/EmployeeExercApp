package com.capg.abc.db;
import java.util.Scanner;

import com.capg.abc.dto.Employee;

public class EmployeeDB {
	// Employee cannot be resolved to a type
	public static Employee employees[]  = new Employee[100];
	
	public static int count = 0;
	
	static {
		employees[count++] = 	new Employee(101, "ramesh", 8, 7000);
		employees[count++] = 	new Employee(102, "suresh", 2, 14000);
		employees[count++] = 	new Employee(103, "rakesh", 1, 25000);
		employees[count++] = 	new Employee(104, "lokesh", 5, 40000);
		 }
			
	public static boolean addEmployee(Employee e)
	{
		employees[count++] = e;
	
		return true;
	}
	public static int getCount()
	{
		return count;
	}

	public static Employee[] getEmployeeBySalary(int salary)
	{
		Employee arr[]=new Employee[count];
		for(int i=0;i<count;i++) {
			if(employees[i].getSalary()==salary) {
				arr[i]=employees[i];
			}
		}
		return arr;
	}
	
	public static Employee[] getEmployeesBySalaryRange(int salaryRangeMin, int salaryRangeMax)
	{
		Employee arr1[]=new Employee[count];
	
		for(int i=0;i<count;i++) {
			if(employees[i].getSalary()>=salaryRangeMin && employees[i].getSalary()>=salaryRangeMax) {
				arr1[i]=employees[i];
				
		}
	}
		return arr1 ;
	}

	
	public static Employee[] getEmployeeByExperience(int exp) {
		Employee exps[]=new Employee[count];
		for(int i=0;i<count;i++) {
			if(employees[i].getExp()==exp) {
				exps[i]=employees[i];		
			}
				
		}
		
		return exps;
	}
	
	}//end of class

