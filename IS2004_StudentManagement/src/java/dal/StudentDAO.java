package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Student;

public class StudentDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext db;
    
    public List<Student> getAllStudent(){
        List<Student> listStd = new ArrayList<>();
        try {
            db = new DBContext();
            conn = db.getConnection();
            String sql = "SELECT * FROM tbStudent";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                double grade = rs.getDouble(4);
                Student x = new Student(id, name, dob, grade);
                listStd.add(x);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listStd;
    }
    
    public void deleteStudent(String id){
        try {
//            String sql = "DELETE FROM tbStudent\n" +
//                         "WHERE id = '"+id+"'";
            String sql = "DELETE FROM tbStudent\n" +
                         "WHERE id = ?";
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addStudent(String id, String name, String dob, String grade){
        try {
            String sql = "INSERT tbStudent\n" +
                         "VALUES (?, ?, ?, ?)";
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, grade);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Student getStudentById(String id){
        try {
            String sql = "SELECT * FROM tbStudent\n" +
                         "WHERE id = ?";
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                double grade = rs.getDouble(4);
                Student x = new Student(id, name, dob, grade);
                return x;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void updateStudent(String id, String name, String dob, String grade){
        try {
            String sql = "UPDATE tbStudent\n" +
                         "SET name=?, dob=?, grade=?\n" +
                         "WHERE id=?";
            db = new DBContext();
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, grade);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
