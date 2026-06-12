
import dal.StudentDAO;
import java.util.ArrayList;
import java.util.List;
import models.Student;

public class TestMain {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<Student> myList = new ArrayList<>();

        myList = dao.getAllStudent();
        
        for (Student s : myList) {
            System.out.println(s.toString());
        }
        System.out.println("");
//        dao.deleteStudent("He200009");
//        dao.addStudent("He200009", "Adam Smith", "2000-01-01", "5.5");
        
        dao.updateStudent("He200009","Người Anh Quốc", "2000-01-03", "9.8");
        myList = dao.getAllStudent();
        
        for (Student s : myList) {
            System.out.println(s.toString());
        }
        System.out.println("\n--GetStudent by Id--");
        Student x = dao.getStudentById("He200009");
        System.out.println(x.toString());
        
        
    }
}
