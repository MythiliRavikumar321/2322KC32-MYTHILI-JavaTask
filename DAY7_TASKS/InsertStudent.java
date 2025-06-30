import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 1);
            ps.setString(2, "Alice");
            ps.setInt(3, 20);
            ps.setString(4, "Computer Science");
            ps.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
}