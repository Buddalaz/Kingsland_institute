package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.RegistrationDAO;
import lk.ijse.kingsland.entity.Registration;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean add(Registration reg) throws Exception {
        String sql="INSERT INTO registration VALUES(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, reg.getRegNo(),reg.getRegDate(),reg.getRegFee(),reg.getRegDuration(),reg.getRegStudent(),reg.getRegCourse());

    }

    @Override
    public boolean update(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Registration serach(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        return null;
    }

    @Override
    public String getRegIdAuto() throws Exception {
        String sql ="SELECT COUNT(regNo) FROM registration";
        ResultSet rst = CrudUtil.executeQuery(sql);
        while (rst.next()){
            int anInt = rst.getInt(1);
            return String.valueOf(anInt);
        }
        return null;
    }
}
