package dbPractice;

import Utils.ExcelUtils;
import Utils.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestUtils {
    public static void main(String[] args) throws SQLException, IOException {

        JDBCUtils.establishConnection();
        List<Map<String,Object>> data=JDBCUtils.runQuery("select first_name, last_name, salary from employees");
        JDBCUtils.closeConnection();
        for (int i=0;i<data.size();i++){
            if(data.get(i).get("FIRST_NAME").equals("Steven")){
                System.out.println(data.get(i).get("SALARY"));
            }

        }
        ExcelUtils.openExcel("Book1","Sheet1");
        System.out.println(ExcelUtils.getValue(1,1));
        ExcelUtils.setValue("Srickan",10,0);
        System.out.println(ExcelUtils.getNumberOfCells(1));

        String[][] data1={
                {"John","Doe","TEC-101","open"},
                {"Harsh","Patel","TEC-102","PASS"},
                {"John", "Doe", "TEC - 103","wip"},
                {"Harsh", "Patel", "TEC - 104","pass"},
                {"Srickan Doe", "TEC - 105","open"},
                {"Harsh Patel", "TEC - 106","wip"},
                {"John Doe", "TEC - 107","wip"},
                {"Harsh Patel", "TEC - 108","pass"}
        };
        ExcelUtils.openExcel("Book1","Sheet1");

    }
}
