package lk.ijse.kingsland.bo.custom.impl;

import lk.ijse.kingsland.bo.custom.CourseBO;
import lk.ijse.kingsland.dao.DAOFactory;
import lk.ijse.kingsland.dao.custom.CourseDAO;
import lk.ijse.kingsland.dao.custom.StudentDAO;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean addCourse(CourseDTO course) throws ClassNotFoundException, SQLException, Exception {
        return courseDAO.add(new Course(course.getCourseCode(),course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws ClassNotFoundException, SQLException, Exception {
        return courseDAO.update(new Course(course.getCourseCode(),course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration()));
    }

    @Override
    public boolean deleteCourse(String id) throws ClassNotFoundException, SQLException, Exception {
        return courseDAO.delete(id);
    }

    @Override
    public CourseDTO serachCourse(String id) throws ClassNotFoundException, SQLException, Exception {
        Course courseEntity = courseDAO.serach(id);
        if (courseEntity != null){
            return new CourseDTO(courseEntity.getCourseCode(),courseEntity.getCourseName(),courseEntity.getCourseIntake(),courseEntity.getCourseFee(),courseEntity.getCourseDuration());
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<CourseDTO> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Course> itemEntities = courseDAO.getAll();
        ArrayList<CourseDTO> list=new ArrayList<>();
        for (Course i : itemEntities) {
            list.add(new CourseDTO(i.getCourseCode(),i.getCourseName(),i.getCourseIntake(),i.getCourseFee(),i.getCourseDuration()));
        }
        return list;
    }


}
