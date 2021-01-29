package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class TestExcel {
    public static void main(String[] args) throws IOException {
        File file=new File("src\\test\\resources\\data\\Book1.xlsx");
        System.out.println(file.exists());
        FileInputStream inputStream=new FileInputStream(file);
        Workbook workbook=new XSSFWorkbook(inputStream);//it is reading the excel file
        Sheet sheet=workbook.getSheet("Sheet1");
        Row row=sheet.getRow(1);
        Cell cell=row.getCell(1);
        System.out.println(cell);
        System.out.println(sheet.getRow(2).getCell(1));
        System.out.println(sheet.getRow(2).getCell(3));
        Cell cell1=sheet.getRow(2).getCell(3);
        cell1.setCellValue("PASS");
        sheet.getRow(2).createCell(4).setCellValue("8/5/2020");
        //sheet.getRow(2).getCell(4).setCellValue("8/5/2020");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();


    }



}
