package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CucumberTestSteps {
    @Given("the user school name")
    public void the_user_school_name() {
        System.out.println("Techtorial");
    }

    @When("the user print the name")
    public void the_user_print_the_name() {
        System.out.println("James");
    }

    @Then("the user print the last name")
    public void the_user_print_the_last_name() {
        System.out.println("Gosling");
    }

    @Then("the user print the city")
    public void the_user_print_the_city() {
        System.out.println("Des Plaines");
    }

    @Then("the user print the state")
    public void the_user_print_the_state() {
        System.out.println("Illinois");
    }
    @Then("the user validate the product titles")
    public void the_user_validate_the_product_titles(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<String> titles=dataTable.asList();
        Iterator<String>title=titles.iterator();
        while (title.hasNext()){
            System.out.println(title.next());
        }
    }

    @Then("the user login to the page")
    public void the_user_login_to_the_page(Map<String,String> data) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        Set<String> keys=data.keySet();
        Iterator<String> key=keys.iterator();
        while (key.hasNext()){
            System.out.println(data.get(key.next()));
        }
    }
    @Then("the user validate order details")
    public void the_user_validate_order_details(List<List<String>> datas) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for (int i=0;i< datas.size();i++){
            for (int k=0;k<datas.get(i).size();k++){
                System.out.print(datas.get(i).get(k)+" | ");
            }
            System.out.println();
        }
    }
    @Then("the user validate order details list of map")
    public void the_user_validate_order_details_list_of_map(List<Map<String,String>> datas) {
        for(Map<String, String> data:datas){
            Set<String> keys=data.keySet();
            for (String key:keys){
                System.out.print(data.get(key)+" | ");

            }
            System.out.println();
        }
    }




}
