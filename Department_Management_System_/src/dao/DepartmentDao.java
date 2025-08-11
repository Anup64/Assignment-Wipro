package dao;

import model.Department;
import java.util.List;
import exception.DepartmentException;

public interface DepartmentDao {
    void addDepartment(Department dept);
    Department getDepartmentById(int id) throws DepartmentException;
    List<Department> getAllDepartments();
    void updateDepartment(Department dept) throws DepartmentException;
    void deleteDepartment(int id) throws DepartmentException;
}