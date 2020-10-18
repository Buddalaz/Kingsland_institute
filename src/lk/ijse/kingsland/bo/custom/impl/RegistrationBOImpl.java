package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.RegistrationBO;
import lk.ijse.kingsland.dao.DAOFactory;
import lk.ijse.kingsland.dao.custom.CourseDAO;
import lk.ijse.kingsland.dao.custom.QueryDAO;
import lk.ijse.kingsland.dao.custom.RegistrationDAO;
import lk.ijse.kingsland.dao.custom.StudentDAO;
import lk.ijse.kingsland.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.kingsland.db.DBConnection;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.dto.CustomDTO;
import lk.ijse.kingsland.dto.RegistrationDTO;
import lk.ijse.kingsland.dto.StudentDTO;
import lk.ijse.kingsland.entity.Course;
import lk.ijse.kingsland.entity.CustomEntity;
import lk.ijse.kingsland.entity.Registration;
import lk.ijse.kingsland.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
    StudentDAO stdDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDAO curDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    QueryDAO qerDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public boolean addRegistration(StudentDTO studentDTO) throws ClassNotFoundException, SQLException, Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);

        Student std = new Student(studentDTO.getStudId(),studentDTO.getStudName(),studentDTO.getStudAddress(),studentDTO.getStudContact(),studentDTO.getStudDate(),studentDTO.getStudGender());
        boolean add = stdDAO.add(std);
        try {
            if (add){
                for (RegistrationDTO regDo: studentDTO.getRegistrationDetails()) {
                    Registration registration = new Registration(regDo.getRegId(), regDo.getRegDate(), regDo.getRegFee(), regDo.getRegDuration(), regDo.getRegStudent(), regDo.getRegCourse());
                    boolean respone = registrationDAO.add(registration);
                    if (respone) {
                        conn.commit();
                    }
                }
                return true;
            }else {
                conn.rollback();
                return false;
            }
        }finally {
            conn.setAutoCommit(true);
        }

    }

    @Override
    public String getRegIdAuto() throws ClassNotFoundException, SQLException, Exception {
        return registrationDAO.getRegIdAuto();
    }

    @Override
    public String getStudentId() throws ClassNotFoundException, SQLException, Exception {
        return stdDAO.getStudentId();
    }

    @Override
    public ArrayList<CustomDTO> searchOrderFromID(String id) throws ClassNotFoundException, SQLException, Exception {
        ArrayList<CustomEntity> orderDetailsFromOID = qerDAO.getOrderDetailsFromOID(id);
        ArrayList<CustomDTO> customDTOArrayList = new ArrayList<>();
        for (CustomEntity customEntity : orderDetailsFromOID) {
            customDTOArrayList.add(new CustomDTO(customEntity.getCurCode(),customEntity.getStdName()));
        }
        return customDTOArrayList;
    }

    @Override
    public CourseDTO serachCourse(String id) throws ClassNotFoundException, SQLException, Exception {
        Course courseEntity = curDAO.serach(id);
        if (courseEntity != null){
            return new CourseDTO(courseEntity.getCourseCode(),courseEntity.getCourseName(),courseEntity.getCourseIntake(),courseEntity.getCourseFee(),courseEntity.getCourseDuration());
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<CourseDTO> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Course> itemEntities = curDAO.getAll();
        ArrayList<CourseDTO> list=new ArrayList<>();
        for (Course i : itemEntities) {
            list.add(new CourseDTO(i.getCourseCode(),i.getCourseName(),i.getCourseIntake(),i.getCourseFee(),i.getCourseDuration()));
        }
        return list;
    }
}
