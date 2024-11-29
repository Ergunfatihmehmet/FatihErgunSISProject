package gmail.fatihmergunqa.steps.backend;

import gmail.fatihmergunqa.utils.Configs;
import gmail.fatihmergunqa.utils.Constants;
import gmail.fatihmergunqa.utils.SQLReader;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StoringData {
    @Test
    public void getAndStoreData() throws SQLException {
        Configs.readProperties(Constants.CONFIGURATION_FILEPATH);
        Connection conn = DriverManager.getConnection(
                Configs.getProperty("db_url"),
                Configs.getProperty("db_username"),
                Configs.getProperty("db_password")
        );

        System.out.println("Connected to database!");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select employeenumber, lastname, firstname, email from employees limit 5");

        List<Map<String, String>> listOfMaps = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> user = new LinkedHashMap<>();
            user.put("Employee Number", rs.getString("employeenumber"));
            user.put("Last Name", rs.getString("lastname"));
            user.put("First Name", rs.getString("firstname"));
            user.put("Email", rs.getString("email"));
            listOfMaps.add(user);
        }

        System.out.println(listOfMaps);

        rs.close();
        st.close();
        conn.close();
    }


    @Test
    public void getAndStoreDataEnhanced() throws SQLException {
        Configs.readProperties(Constants.CONFIGURATION_FILEPATH);
        Connection conn = DriverManager.getConnection(
                Configs.getProperty("db_url"),
                Configs.getProperty("db_username"),
                Configs.getProperty("db_password")
        );

        System.out.println("Connected to database!");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select employeeNumber, lastName, firstName, email from employees limit 5");

        ResultSetMetaData rsMetaData = rs.getMetaData();
        int columnCount = rsMetaData.getColumnCount();

        List<Map<String, String>> listOfMaps = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> user = new LinkedHashMap<>();

            for (int i = 1; i <= columnCount; i++) {
                user.put(rsMetaData.getColumnName(i), rs.getString(i));
            }

            listOfMaps.add(user);
        }

        System.out.println(listOfMaps);

        rs.close();
        st.close();
        conn.close();
    }

    @Test
    public void getAndStoreDataPretty() throws SQLException {
        SQLReader.getConnection();
        List<Map<String, String>> data =
                SQLReader.getData("select employeeNumber, lastName, firstName, email from employees limit 5");
        System.out.println(data);
        SQLReader.closeConnection();
    }
}
