package dbPractice;

import Utils.ConfigReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        /* in order to make connection:
        Connection interface
        Statement interface
        ResultSet interface
         */

        Connection connection= DriverManager.getConnection(
                ConfigReader.getProperty("dbhost"),
                ConfigReader.getProperty("dbusername"),
                ConfigReader.getProperty("dbpassword"));
                //host(URL),username and password

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("select * from employees");
        resultSet.next();//HOLDS ALL DATA AND GOES TO FIRST RAW
        System.out.println(resultSet.getString("FIRST_NAME")+" "+resultSet.getString("salary"));
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));
        while (resultSet.next()){
            System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("salary"));
        }

        //******************Data Base Meta Data**************************//
        //to get information about data

        DatabaseMetaData metaData=connection.getMetaData();
        System.out.println("User: "+metaData.getUserName());
        System.out.println("Product name: "+metaData.getDatabaseProductName());
        //********************** ResultSetMetaData->to get column names**********************************//

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        System.out.println("Column amount "+resultSetMetaData.getColumnCount());
        System.out.println("Column name "+resultSetMetaData.getColumnName(1));
        System.out.println(resultSetMetaData.getColumnClassName(2));
        System.out.println(resultSetMetaData.getColumnTypeName(3));

        List<Map<String,Object>> data=new ArrayList<>();
        resultSet.beforeFirst();
        while (resultSet.next()){
            Map<String,Object> map= new HashMap<>();
            for (int i=1;resultSetMetaData.getColumnCount()>=i;i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        System.out.println(data.get(0).get("FIRST_NAME"));
        // Using data list of maps print first_name who has salary more than 10000
        for(int i=0; i<data.size(); i++){
            if(Integer.parseInt(data.get(i).get("salary").toString())>=10000){
                System.out.println(data.get(i).get("first_name"));
            }
        }


    }
}
