package lk.ijse.kingsland.bo.custom;

import lk.ijse.kingsland.bo.SuperBO;
import lk.ijse.kingsland.dto.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseBO extends SuperBO {

    public boolean addCourse(CourseDTO course) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateCourse(CourseDTO course) throws ClassNotFoundException, SQLException, Exception;

    public boolean deleteCourse(String id) throws ClassNotFoundException, SQLException, Exception;

    public CourseDTO serachCourse(String id) throws ClassNotFoundException, SQLException, Exception;

    ArrayList<CourseDTO> getAll() throws ClassNotFoundException, SQLException, Exception;

}
