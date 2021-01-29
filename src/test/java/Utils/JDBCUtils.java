package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * This method establishes the connection.
     * @throws SQLException
     */
    public static void establishConnection() throws SQLException {
        connection= DriverManager.getConnection(
                ConfigReader.getProperty("dbhost"),
                ConfigReader.getProperty("dbusername"),
                ConfigReader.getProperty("dbpassword"));
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * This method returns data stored in List<Map<String,Object>>.
     * @param query
     * @return
     * @throws SQLException
     */



    public static List<Map<String,Object>> runQuery(String query) throws SQLException {
        resultSet=statement.executeQuery(query);
        List<Map<String, Object>> data=new ArrayList<>();
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        while (resultSet.next()){
            Map<String,Object> map=new HashMap<>();
            for (int i=1;i<=resultSetMetaData.getColumnCount();i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        return data;
    }

    /**
     * This method returns number of rows.
     * @param query
     * @return
     * @throws SQLException
     */

    public static int getRowsNumber(String query) throws SQLException {
        resultSet=statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();

    }

    /**
     * This method closes the connection, statement and resultSet
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
