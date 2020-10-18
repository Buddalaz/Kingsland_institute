package lk.ijse.kingsland.dao.custom.impl;

import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.QueryDAO;
import lk.ijse.kingsland.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> getOrderDetailsFromOID(String oid) throws ClassNotFoundException, SQLException {
        String sql = "SELECT course.code, student.studentName FROM course INNER JOIN registration ON course.code = registration.code \n" +
                     " INNER JOIN student ON student.id = registration.id WHERE course.code=?";
        ResultSet rst = CrudUtil.executeQuery(sql, oid);
        ArrayList<CustomEntity> cruStdList = new ArrayList<>();
        while (rst.next()){
            String cruCode = rst.getString(1);
            String stuName = rst.getString(2);

            CustomEntity cutmEntity = new CustomEntity(cruCode, stuName);
            cruStdList.add(cutmEntity);
        }
        return cruStdList;
    }
}
