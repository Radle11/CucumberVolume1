package StepDefinitions.myApp;

import Pages.myApp.MyAppHomePage;
import Utils.ConfigReader;
import Utils.Driver;
import Utils.JDBCUtils;
import com.google.common.collect.Streams;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class myAppSteps {
    WebDriver driver= Driver.getDriver();
    List<Map<String,Object>> UIdata=new ArrayList<>();
    @Given("go to myApp home page")
    public void go_to_myApp_home_page() {
        driver.get(ConfigReader.getProperty("myApp"));

    }

    @When("gets the data from UI")
    public void gets_the_data_from_UI() {
        List<WebElement> tables=driver.findElements(By.xpath("//tbody[2]//tr[position()>=1]"));
        List<WebElement>columns=driver.findElements(By.xpath("//tr//th"));
        Map<String,Object> data=new HashMap<>();
        IntStream.range(0, columns.size())
                .forEach(x -> data.put(columns.get(x).getText(),tables.get(x).getText()));
        UIdata.add(data);
        System.out.println(UIdata.get(0).get("Name"));
    }

    @Then("validates UI data with DB")
    public void validates_UI_data_with_DB() throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String,Object>> DB=JDBCUtils.runQuery("SELECT FIRST_NAME,LAST_NAME,EMPLOYEE_ID,JOB_TITLE FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID=J.JOB_ID" +
                "WHERE EMPLOYEE_ID IN(100,105,119,125)");

        JDBCUtils.closeConnection();

    }

}
class MyAppSteps {
    WebDriver driver = Driver.getDriver();
    List<Map<String, Object>> UIData = new ArrayList<>();
    @Given("user go to MyApp homepage")
    public void user_go_to_MyApp_homepage() {
        driver.get(ConfigReader.getProperty("myApp"));
    }
    @When("user gets the data from UI")
    public void user_gets_the_data_from_UI() {
        Map<String, Object> row1 = new HashMap<>();
        MyAppHomePage myAppHomePage = new MyAppHomePage();
        List<String> columns = new ArrayList<>();
        for (int i=0; i<myAppHomePage.column.size(); i++){
            columns.add(myAppHomePage.column.get(i).getText());
        }
        for (int i =0; i <myAppHomePage.row1Elements.size(); i++){
            row1.put(columns.get(i), myAppHomePage.row1Elements.get(i).getText());
        }
        Map<String, Object> row2 = new HashMap<>();
        for (int i =0; i<myAppHomePage.row2Elements.size(); i++){
            row2.put(columns.get(i), myAppHomePage.row2Elements.get(i).getText());
        }   Map<String, Object> row3 = new HashMap<>();
        for (int i =0; i<myAppHomePage.row3Elements.size(); i++){
            row3.put(columns.get(i), myAppHomePage.row3Elements.get(i).getText());
        }
        Map<String, Object> row4 = new HashMap<>();
        for (int i =0; i<myAppHomePage.row4Elements.size(); i++){
            row4.put(columns.get(i), myAppHomePage.row4Elements.get(i).getText());
        }
        UIData.add(row1);
        UIData.add(row2);
        UIData.add(row3);
        UIData.add(row4);
    }
    @Then("user validates UI data with DB")
    public void user_validates_UI_data_with_DB() throws SQLException {
        // we need to get first_name, last_name, job_title from database
        JDBCUtils.establishConnection();
        List<Map<String, Object>> DBdata =  JDBCUtils.runQuery("select first_name, last_name, employee_id, job_title\n" +
                "from employees e join jobs j on\n" +
                "e.job_id = j.job_id\n" +
                "where employee_id in (100,105,119,125)");
        // UI data validated with DB data
        for (int i =0; i<UIData.size(); i++){
            Assert.assertEquals(UIData.get(i).get("Name"), DBdata.get(i).get("FIRST_NAME").toString());
            org.junit.Assert.assertEquals(UIData.get(i).get("Last Name"), DBdata.get(i).get("LAST_NAME").toString());
            Assert.assertEquals(UIData.get(i).get("Employee ID"), DBdata.get(i).get("EMPLOYEE_ID").toString());
            Assert.assertEquals(UIData.get(i).get("JOB_TITLE"), DBdata.get(i).get("JOB_TITLE").toString());
        }
    }

}
