
package client;

import service.DepartmentService;
import model.Department;
import exception.DepartmentException;

import java.util.Scanner;

public class DepartmentClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentService service = new DepartmentService();
        int choice;

        do {
            System.out.println("\n1. Add Department\n2. Get by ID\n3. View All\n4. Update\n5. Delete\n6. Exit");
            System.out.println("Enter choice (1 to 6): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, DeptName, Location:");
                    Department d = new Department(sc.nextInt(), sc.next(), sc.next());
                    System.out.println("Add Successfully.");
                    service.addDepartment(d);
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    try {
                        System.out.println(service.getDepartmentById(sc.nextInt()));
                    } catch (DepartmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                	for(Department dept : service.getAllDepartments()){
                	    System.out.println(dept);
                	}
                    break;
                case 4:
                    System.out.println("Enter ID to update, new DeptName, new Location:");
                    try {
                        service.updateDepartment(new Department(sc.nextInt(), sc.next(), sc.next()));
                        System.out.println("Updated successfully.");
                    } catch (DepartmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter ID to delete:");
                    try {
                        service.deleteDepartment(sc.nextInt());
                        System.out.println("Deleted successfully.");
                    } catch (DepartmentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}
