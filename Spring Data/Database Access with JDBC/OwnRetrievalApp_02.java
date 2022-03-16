import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class OwnRetrievalApp_02 {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user","root");
        // props.setProperty("password","ПАРОЛА");  парола,ако има такава

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo",props);

        Scanner scanner = new Scanner(System.in);
        PreparedStatement statement = connection.prepareStatement(
                "SELECT first_name,last_name,COUNT(*) AS count FROM users_games AS ug JOIN users AS u ON ug.user_id = u.id WHERE user_name = ? GROUP BY u.id");
        String username = scanner.nextLine();

        statement.setString(1,username);

        ResultSet result = statement.executeQuery();

        if(result.next()){
            System.out.println("User: " + username + System.lineSeparator()+
                    result.getString("first_name") + " " +  result.getString("last_name")
                    + " has played " + result.getInt("count") + " games");
        } else{
            System.out.println("No such user exists");
        }
    }
}
