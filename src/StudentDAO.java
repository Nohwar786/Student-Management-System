import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                "(name, age, gender, course, email, phone, address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setString(7, student.getAddress());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== STUDENT LIST =====");

            while (rs.next()) {

                System.out.println("----------------------------");
                System.out.println("ID      : " + rs.getInt("id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Age     : " + rs.getInt("age"));
                System.out.println("Gender  : " + rs.getString("gender"));
                System.out.println("Course  : " + rs.getString("course"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));
                System.out.println("Address : " + rs.getString("address"));
            }

        } catch (SQLException e) {
            System.out.println("Error viewing students: " + e.getMessage());
        }
    }

    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== STUDENT FOUND =====");
                System.out.println("ID      : " + rs.getInt("id"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Age     : " + rs.getInt("age"));
                System.out.println("Gender  : " + rs.getString("gender"));
                System.out.println("Course  : " + rs.getString("course"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("Phone   : " + rs.getString("phone"));
                System.out.println("Address : " + rs.getString("address"));

            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name=?, age=?, gender=?, " +
                "course=?, email=?, phone=?, address=? WHERE id=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());
            ps.setString(7, student.getAddress());
            ps.setInt(8, student.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}