package lk.ijse.kingsland.bo.custom;

import lk.ijse.kingsland.bo.SuperBO;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.dto.CustomDTO;
import lk.ijse.kingsland.dto.RegistrationDTO;
import lk.ijse.kingsland.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {

    public boolean addRegistration(StudentDTO studentDTO)throws ClassNotFoundException, SQLException, Exception;

    public String getRegIdAuto() throws ClassNotFoundException, SQLException, Exception;

    public String getStudentId()throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CustomDTO> searchOrderFromID(String id) throws ClassNotFoundException, SQLException, Exception;

    public CourseDTO serachCourse(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<CourseDTO> getAll() throws ClassNotFoundException, SQLException, Exception;
}
