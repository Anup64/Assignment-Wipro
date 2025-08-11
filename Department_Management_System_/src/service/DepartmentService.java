package service;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import model.Department;
import exception.DepartmentException;

import java.util.List;

public class DepartmentService {
    private DepartmentDao dao = new DepartmentDaoImpl();

    public void addDepartment(Department dept) {
        dao.addDepartment(dept);
    }

    public Department getDepartmentById(int id) throws DepartmentException {
        return dao.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

    public void updateDepartment(Department dept) throws DepartmentException {
        dao.updateDepartment(dept);
    }

    public void deleteDepartment(int id) throws DepartmentException {
        dao.deleteDepartment(id);
    }
}
