import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class SimpleJavaAccess_1 {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty( "user","root");
        // props.setProperty("password","ПАРОЛА");  парола,ако има такава

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni",props);

        Scanner scanner = new Scanner(System.in);
        PreparedStatement stmt = connection.prepareStatement
                ("SELECT first_name,last_name FROM employees WHERE salary > ?");
        String salary = scanner.nextLine();
        stmt.setDouble(1,Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("first_name") + " "
            + rs.getString("last_name") );
        }
    }
}
