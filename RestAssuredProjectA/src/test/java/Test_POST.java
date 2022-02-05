import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
public class Test_POST {
@Test
	public void test_01post() {
//	Map<String, Object> map= new HashMap<String, Object>();
//	map.put("name", "Shreya");
//	map.put("job", "QA");
	//System.out.println(map);
    JSONObject request= new JSONObject();
    request.put("name", "Shreya");
    request.put("job", "QA");
    System.out.println(request);
    		System.out.println(request.toJSONString());
	given()
	.header("Content-Type", "application/json")
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(request.toJSONString())
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201);
	
	}
  

@Test
public void test_02put() {

JSONObject request= new JSONObject();
request.put("name", "Shreya");
request.put("job", "QA");
System.out.println(request);
		System.out.println(request.toJSONString());
given()
.header("Content-Type", "application/json")
.contentType(ContentType.JSON)
.accept(ContentType.JSON)
.body(request.toJSONString())
.when()
.put("https://reqres.in/api/users/2")
.then()
.statusCode(200)
.log().all();

}

@Test
public void test_03patch() {

JSONObject request= new JSONObject();
request.put("name", "Shreya");
request.put("job", "QA");
//System.out.println(request);
		System.out.println(request.toJSONString());
given()
.header("Content-Type", "application/json")
.contentType(ContentType.JSON)
.accept(ContentType.JSON)
.body(request.toJSONString())

.when()
.patch("https://reqres.in/api/users/2")

.then()
.statusCode(200)
.log().all();
}

@Test
public void test_04delete() {

when()
.delete("https://reqres.in/api/users/2")

.then()
.statusCode(204)
.log().all();
}
}
