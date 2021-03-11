
package com.capg.abc.dao;

import com.capg.abc.dto.Employee;
import com.capg.abc.exceptions.InvalidEmployeeIdException;
import com.capg.abc.exceptions.WrongSalaryException;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e)throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(int id,int salary)throws InvalidEmployeeIdException;
	 
	 public boolean editExpByEmployeeId(int id,int exp)throws InvalidEmployeeIdException;
	 
	 public Employee[] getAllEmployees();
	 
	 public Employee[] getEmployeeBySalary(int salary);
	 
	 public Employee[] getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

	 public Employee[] getEmployeeByExperience(int exp);
}
