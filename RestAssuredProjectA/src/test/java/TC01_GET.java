import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.response.Response;

public class TC01_GET {
	
	
@Test  
 void test_01() {
	Response res= get("https://reqres.in/api/users?page=2");
	//Response is class from REst Assured to store 
	
	System.out.println(res.asString());
	System.out.println(res.getBody().asString());
	System.out.println(res.getStatusCode());
	System.out.println(res.getStatusLine());
	System.out.println(res.getHeader("content-type"));
	
	
	int statuscode=res.getStatusCode();
	Assert.assertEquals(statuscode, 200);
}
//@Test
//void test_02() {
//	given()
//	.get("https://reqres.in/api/users?page=2")
//	.then()
//	.statusCode(200)
//	.body("data.id[0]", equalTo(7));
//}

}
