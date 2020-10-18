package lk.ijse.kingsland.dao.custom.impl;

import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;
import lk.ijse.kingsland.dao.CrudUtil;
import lk.ijse.kingsland.dao.custom.CourseDAO;
import lk.ijse.kingsland.entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean add(Course course) throws Exception {
        String sql = "INSERT INTO COURSE VALUES(?,?,?,?,?)";//INSERT INTO COURSE VALUES('C002','BCSC','SPRING,SUMMER,FALL','3YEAR')
        return CrudUtil.executeUpdate(sql,course.getCourseCode(),course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        String sql = "UPDATE COURSE SET courseName=?, courseIntake=?, courseFee=?, duration=? WHERE code=?";
        return CrudUtil.executeUpdate(sql, course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration(),course.getCourseCode());
    }

    @Override
    public boolean delete(String s) throws Exception {
        String sql = "DELETE FROM COURSE WHERE code=?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public Course serach(String s) throws Exception {
        String sql = "SELECT * FROM COURSE WHERE code=?";
        ResultSet rst = CrudUtil.executeQuery(sql,s);
        while (rst.next()){
            return new Course(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5));
        }
        return null;
    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
        String sql = "SELECT * FROM course";
        ResultSet rs = CrudUtil.executeQuery(sql);
        ArrayList<Course> courseList = new ArrayList<>();
       while (rs.next()){
           courseList.add(new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
       }
        return courseList;
    }


}
