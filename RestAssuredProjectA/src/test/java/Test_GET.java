import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.Assert;

import io.restassured.http.Header;
import io.restassured.response.Response;
public class Test_GET {
@Test
	public void test_1() {
		given()
		.header("Content-Type", "application/json")
		//.param(parameterName, parameterValues)
		.get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Michael", "Lindsay"));
		//.log()
		//.all();
	}
}
