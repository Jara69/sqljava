package sql;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT zvirata.jmeno, zvirata.id, druhy.nazev FROM zvirata join druhy on (zvirata.druh = druhy.id) where druhy.nazev like 'mlok' LIMIT 10");

        while(result.next()){
        String title = result.getString("jmeno");
        System.out.println("Jmeno: " + title);
        int id = result.getInt("id");
        System.out.println("Id: " + id);
        String nazev = result.getString("nazev");
        System.out.println("Nazev: " + nazev);
        System.out.println("_____________________");
        }
        connection.close();
    }

}
