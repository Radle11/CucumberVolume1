package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {
    private static String filePath;
    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;
    private static Cell cell;


    /**
     * Method will open Excel file with provided excel file name and sheet name
     * @param fileName
     * @param sheetName
     * @throws IOException
     */
    public static void openExcel(String fileName,String sheetName) {
        filePath="src\\test\\resources\\data\\"+fileName+".xlsx";
        File file=new File(filePath);
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(file);
            workbook=new XSSFWorkbook(inputStream);
            sheet=workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method will provide the value on specified row number and cell number.
     * @param rowNumber
     * @param cellNumber
     * @return
     */
    public static String getValue(int rowNumber,int cellNumber){
       return sheet.getRow(rowNumber).getCell(cellNumber).toString();
    }

    /**
     * Method will set a new value.
     * @param value
     * @param rowNumber
     * @param cellNumber
     * @throws IOException
     */

    public static void setValue(String value,int rowNumber, int cellNumber) throws IOException {
        try{
            row=sheet.getRow(rowNumber);
            cell=row.getCell(cellNumber);
            cell.setCellValue(value);

        }catch (NullPointerException e){
            cell=sheet.createRow(rowNumber).createCell(cellNumber);
            cell.setCellValue(value);
        }
        FileOutputStream fileOutputStream=new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();

    }

    /**
     * Method will return number of cells on specified row.
     * @return
     */
    public static int getNumberOfCells(int rowNumber){
        try{
            return sheet.getRow(rowNumber).getPhysicalNumberOfCells();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            return -1;
        }

}
}
