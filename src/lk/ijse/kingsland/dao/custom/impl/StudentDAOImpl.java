package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.StudentDAO;
import lk.ijse.kingsland.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean add(Student std) throws Exception {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,std.getStudId(),std.getStudName(),std.getStudAddress(),std.getStudContact(),std.getStudDate(),std.getStudGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Student serach(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        return null;
    }

    @Override
    public String getStudentId() throws Exception {
        String sql = "SELECT COUNT(id) FROM STUDENT";
        ResultSet rst = CrudUtil.executeQuery(sql);
        while (rst.next()){
            int stuRegId = rst.getInt(1);
            return String.valueOf(stuRegId);
        }
        return null;
    }
}
