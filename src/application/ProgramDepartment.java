package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department Insert ===");
		Department newDepartment = new Department(null, "TI");    
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 2: Department FindById ===");
		Department department = departmentDao.findById(7);
		System.out.println(department);
		
		System.out.println("\n=== TEST 4: Department FindAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
				
		System.out.println("\n=== TEST 4: Department Update ===");
		Department department2 = departmentDao.findById(8);
		department2.setName("Education");
		departmentDao.update(department2);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: Department Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		scanner.close();
	}
} 
