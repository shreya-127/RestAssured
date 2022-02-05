import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {
@Test
	 public void testget() {
	     baseURI = "http://localhost:3000/";
		 given()
		 .param("name", "Automation")
		 .get("/Subjects").then().statusCode(200).log().all();
	 }
@Test
public void testpost() {
   JSONObject request= new JSONObject();
   request.put("firstname", "Tom");
   request.put("Lastname", "Sawyer");
   request.put("SubjectId", "1");
   
   baseURI = "http://localhost:3000/";
   
   given()
   .contentType(ContentType.JSON)
   .accept(ContentType.JSON)
   .header("ContentType", "application/json")
   .body(request.toJSONString())
   .when()
   .post("/users")
   .then()
   .statusCode(201).log().all();

}
}