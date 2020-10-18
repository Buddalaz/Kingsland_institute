package lk.ijse.kingsland.dao.custom;

import lk.ijse.kingsland.dao.SuperDAO;
import lk.ijse.kingsland.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {

    public ArrayList<CustomEntity> getOrderDetailsFromOID(String oid) throws ClassNotFoundException, SQLException;
}
