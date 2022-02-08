import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Exercise_1_all {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";
    public static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws IOException, SQLException {

        connection = getConnection();

        System.out.println("Enter ex num:");
        int exNum = Integer.parseInt(reader.readLine());


        switch (exNum) {
            case 2 -> exTwo();
            case 3 -> exThree();
            case 4 -> exFour();
            case 5 -> exFive();
            case 6 -> exSix();
            case 7 -> exSeven();
            case 8 -> exEight();
            case 9 -> exNine();

        }
    }

    private static void exNine() throws IOException, SQLException {
        System.out.println("Enter minion id:");
        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection
                .prepareCall("Call usp_get_older(?)");
        callableStatement.setInt(1,minionId);

        int affected = callableStatement.executeUpdate();
        if(affected == 0){
            System.out.printf("Minion with id %d doesn't exist.",minionId);
        } else {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT name,age FROM minions WHERE id = ?");
            preparedStatement.setInt(1, minionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.println("Name:" + resultSet.getString("name") + System.lineSeparator()
                    + " Age:" + resultSet.getInt("age"));
        }
    }

    private static void exEight() throws IOException, SQLException {
        System.out.println("Enter id's:");
        String [] ids = reader.readLine().split("\\s+");

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE minions SET age = age+1,name = LOWER(name) WHERE id = ?");
        for (String id : ids) {
            preparedStatement.setInt(1,Integer.parseInt(id));
            preparedStatement.executeUpdate();
        }

        PreparedStatement printAllMinions = connection
                .prepareStatement("SELECT name,age from minions");
        ResultSet resultSet = printAllMinions.executeQuery();
        while(resultSet.next()){
            System.out.printf("%s %d%n",resultSet.getString("name"),resultSet.getInt("age"));
        }
    }

    private static void exSeven() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT name FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> names = new ArrayList<>();
        while(resultSet.next()){
            names.add(resultSet.getString(1));
        }

        int start = 0;
        int end = names.size() -1;

        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    i % 2 == 0
            ? names.get(start++) : names.get(end--)
            );
        }
    }

    private static void exSix() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

        int affectedEntities =  deleteMinionsByVillainId(villainId);

        String villainName = findEntityNameById("villains",villainId);

        int delete = deleteEntityById("villains",villainId);
        if(delete == 0){
            System.out.println("No such villain was found");
        } else{
            System.out.printf("%s was deleted%n%d minions released",
                    villainName,affectedEntities);
        }

    }

    private static void exFive() throws IOException, SQLException {
        System.out.println("Enter country name:");
        String countryName = reader.readLine();

        PreparedStatement preparedStatement =
                connection.prepareStatement
                        ("UPDATE towns SET name = UPPER(name) WHERE  country = ?");
        preparedStatement.setString(1,countryName);

        int affectedRolls = preparedStatement.executeUpdate();
        if(affectedRolls == 0){
            System.out.println("No town names were affected.");
        } else{
            System.out.printf("%d town names were affected.%n",affectedRolls);

            PreparedStatement preparedStatementTowns = connection.prepareStatement
                    ("SELECT name FROM towns WHERE country = ?;" +
                            "");
            preparedStatementTowns.setString(1,countryName);
            ResultSet resultSetOne = preparedStatementTowns.executeQuery();
            Set<String> towns  = new LinkedHashSet<>();
            while(resultSetOne.next()){
                towns.add(resultSetOne.getString("name"));
            }
            System.out.println("[" + String.join(", ",towns) + "]");
        }



    }

    private static void exFour() throws IOException, SQLException {
        System.out.println("Enter input:");
        String [] minionInfo = reader.readLine().split("\\s+");
        String [] villainInfo = reader.readLine().split("\\s+");
        String town = minionInfo[3];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionName = minionInfo[1];
        String villainName = villainInfo[1];

        int existingTown = doesEntityExist("towns",town);
        if( existingTown == 0){
            insertEntityIntoTableOnlyName("towns",town);
            System.out.printf("Town %s was added to the database.%n",town);
        }
        int existingVillain = doesEntityExist("villains",villainName);
        if(existingVillain == 0){
            PreparedStatement townStatement = connection.prepareStatement
                    ("INSERT INTO villains(name,evilness_factor) VALUES (?,?)");
            townStatement.setString(1, villainName);
            townStatement.setString(2, "evil");
            townStatement.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n",villainName);
        }
        int existingMinion = doesEntityExist("minions",minionName);

        if(existingMinion == 0) {
            int townId = findEntityIdByName("towns", town);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO minions (name,age,town_id) VALUES (?,?,?);");
            preparedStatement.setString(1, minionName);
            preparedStatement.setInt(2, minionAge);
            preparedStatement.setInt(3, townId);
            preparedStatement.executeUpdate();
        }

        int one = findEntityIdByName("minions",minionName);
        int two = findEntityIdByName("villains",villainName);
        PreparedStatement setMinionAsServant = connection.prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) VALUES (?,?)");
        setMinionAsServant.setInt(1,findEntityIdByName("minions",minionName));
        setMinionAsServant.setInt(2,findEntityIdByName("villains",villainName));

        if(setMinionAsServant.executeUpdate() == 1){
            System.out.printf("Successfully added %s to be minion of %s.",minionName,villainName);
        }
    }

    private static void exThree() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villain = Integer.parseInt(reader.readLine());

        String villainName = findEntityNameById("villains", villain);
        if(villainName.isEmpty()){
            System.out.println("No villain with ID 10 exists in the database.");
        }else {
            System.out.println("Villain name : " + villainName);
            Set<String> allMinionByVillainId = getAllMinionByVillainId(villain);

            for (String s : allMinionByVillainId) {
                System.out.println(s);
            }
        }
    }

    private static void exTwo() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT v.name,COUNT(DISTINCT mv.minion_id) AS `m_count` FROM villains v JOIN minions_villains mv on v.id = mv.villain_id GROUP BY v.name HAVING m_count > ? ORDER BY m_count DESC");

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n",
                    resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }

    private static Set<String> getAllMinionByVillainId(int villain) throws SQLException {
        Set<String> result = new LinkedHashSet<>();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT m.name,m.age FROM minions AS m JOIN minions_villains mv on m.id = mv.minion_id WHERE mv.villain_id = ?");
        preparedStatement.setInt(1, villain);

        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;

        while (resultSet.next()) {
            result.add(String.format("%d. %s %d", ++counter,
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            ));
        }
        return result;
    }
    private static String findEntityNameById(String tableName, int entityId) throws SQLException {
        String query = String.format(
                "SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, entityId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return "";
        }
    }
    private static int findEntityIdByName(String tableName,String name) throws SQLException {
        String query = String.format(
                "SELECT id FROM %s WHERE name = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            return 0;
        }
    }
    private static int deleteEntityById(String tableName,int id) throws SQLException {
        String query = String.format(
                "DELETE FROM  %s WHERE id = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement
                (query);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();

    }
    private static int deleteMinionsByVillainId(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");

        preparedStatement.setInt(1,villainId);
        return preparedStatement.executeUpdate();
    }
    private static int doesEntityExist(String tableName,String entityName) throws SQLException {
        String query = String.format("SELECT COUNT(*) AS 'count' FROM %s WHERE name = ?",tableName);
        PreparedStatement preparedStatement = connection.prepareStatement
                (query);
        preparedStatement.setString(1,entityName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count");
    }
    private static void insertEntityIntoTableOnlyName(String table, String name) throws SQLException {
        String query = String.format("INSERT INTO %s(name) VALUES (?)",table);
        PreparedStatement townStatement = connection.prepareStatement
                (query);
        townStatement.setString(1, name);
        townStatement.executeUpdate();
    }


    private static Connection getConnection() throws IOException, SQLException {
//        System.out.println("Enter user:");
//        String user = reader.readLine();
//        System.out.println("Enter password:");
//        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", "root");

        // !!!!!! props.setProperty("password","ПАРОЛА");  парола,ако има такава !!!!!

        return DriverManager.getConnection
                (CONNECTION_STRING + DATABASE_NAME, properties);
    }
}
