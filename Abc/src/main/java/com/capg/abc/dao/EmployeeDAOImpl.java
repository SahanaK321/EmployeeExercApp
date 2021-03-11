package com.capg.abc.dao;
import java.util.Scanner;
import com.capg.abc.db.EmployeeDB;
import com.capg.abc.dto.Employee;
import com.capg.abc.exceptions.InvalidEmployeeIdException;
import com.capg.abc.exceptions.WrongSalaryException;
 
public class EmployeeDAOImpl implements IEmployeeDAO {

	private Employee emp;

	public boolean addEmployee(Employee e) throws WrongSalaryException{
         // SQL  insert into employee ...... 
		
		//System.out.println(" =====>> DAO Impl employee "+e);
		return EmployeeDB.addEmployee(e);
	}

	public Employee[] getAllEmployees() {

		return EmployeeDB.employees;
	}
	
	//============================================================

	
	
	public boolean editSalaryByEmployeeId(int id,int salary) throws InvalidEmployeeIdException {
	
		for(Employee emp : EmployeeDB.employees) {
			Scanner sc = new Scanner(System.in);
			if(emp.getEmployeeId()==id)
			{
				System.out.println("enter new salary");
				int x=Integer.parseInt(sc.nextLine());
				emp.setSalary(x);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean editExpByEmployeeId(int id,int exp) throws InvalidEmployeeIdException {
		Scanner sc = new Scanner(System.in);
		for(Employee emp : EmployeeDB.employees)
		{
			if(emp.getEmployeeId()==id)
			   {
			        System.out.println("Enter new experience");
					int x=Integer.parseInt(sc.nextLine());
					emp.setExp(x);
					return true;
				}
			return false;
		}
		
		return false;
	}

	

	public Employee[] getEmployeeBySalary(int salary) {
		
		return EmployeeDB.getEmployeeBySalary(salary);
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
	
		return EmployeeDB.getEmployeesBySalaryRange( salaryRangeMin,  salaryRangeMax);
	}

	public Employee[] getEmployeeByExperience(int exp) {
		
		return EmployeeDB.getEmployeeByExperience(exp);
	}
}

