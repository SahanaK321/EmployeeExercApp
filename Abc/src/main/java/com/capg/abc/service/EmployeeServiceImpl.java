package com.capg.abc.service;

import com.capg.abc.dao.EmployeeDAOImpl;
import com.capg.abc.dao.IEmployeeDAO;
import com.capg.abc.db.EmployeeDB;
import com.capg.abc.dto.Employee;
import com.capg.abc.exceptions.InvalidEmployeeIdException;
import com.capg.abc.exceptions.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
   // Animal a = new Dog();
	IEmployeeDAO dao;

	public EmployeeServiceImpl()
	{
		dao = new EmployeeDAOImpl();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		
			//System.out.println(" ------------>> inside service "+e);
		
			if(e.getSalary()> 50000)
			{
				throw new WrongSalaryException();
			}
			else return dao.addEmployee(e);		
		
	}

	public Employee[] getAllEmployees() {

		return dao.getAllEmployees();
	}
	
	
	// ================================================================================

	public boolean editSalaryByEmployeeId(int id,int salary) throws InvalidEmployeeIdException {
		if(dao.editSalaryByEmployeeId(id,salary)) 
			return true;
		else
		return false;
	}

	public boolean editExpByEmployeeId(int id,int exp) throws InvalidEmployeeIdException {
		if(dao.editExpByEmployeeId(id,exp)) 
			return true;
		else
		return false;
	}

	public Employee[] getEmployeeBySalary(int salary) {
		
		return dao.getEmployeeBySalary(salary);
	}

	public Employee[] getEmployeesBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
	
		return dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}
	
	public Employee[] getEmployeesByExperience(int exp) {
	
		return dao.getEmployeeByExperience(exp);
	}

}
