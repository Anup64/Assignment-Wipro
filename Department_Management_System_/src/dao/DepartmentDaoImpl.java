package dao;

import model.Department;
import util.DbUtil;

import java.sql.*;
import java.util.*;

import exception.DepartmentException;

public class DepartmentDaoImpl implements DepartmentDao {

    public void addDepartment(Department dept) {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO department VALUES (?, ?, ?)")) {
            ps.setInt(1, dept.getDeptId());
            ps.setString(2, dept.getDeptName());
            ps.setString(3, dept.getLocation());
            ps.executeUpdate();
        } catch (SQLException | DepartmentException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(int id) throws DepartmentException {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM department WHERE deptId = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Department(rs.getInt(1), rs.getString(2), rs.getString(3));
            } else {
                throw new DepartmentException("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        try (Connection conn = DbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM department")) {
            while (rs.next()) {
                list.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException | DepartmentException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateDepartment(Department dept) throws DepartmentException {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE department SET deptName=?, location=? WHERE deptId=?")) {
            ps.setString(1, dept.getDeptName());
            ps.setString(2, dept.getLocation());
            ps.setInt(3, dept.getDeptId());
            int updated = ps.executeUpdate();
            if (updated == 0) throw new DepartmentException("Department not found to update.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(int id) throws DepartmentException {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM department WHERE deptId = ?")) {
            ps.setInt(1, id);
            int deleted = ps.executeUpdate();
            if (deleted == 0) throw new DepartmentException("Department not found to delete.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}