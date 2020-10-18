package lk.ijse.kingsland.dao;

import lk.ijse.kingsland.dao.custom.impl.CourseDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.QueryDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.kingsland.dao.custom.impl.StudentDAOImpl;
import lk.ijse.kingsland.entity.Registration;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;

    }

    public enum DAOTypes {
        STUDENT, COURSE, REGISTRATION, QUERY;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;

        }
    }

}
