package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class API {
	JSONArray platformArray;
  @Test(enabled=true)
  public void f() {
	// request the server
		RequestSpecification reqSpec = RestAssured.given();
//body 
		JSONObject jo = new JSONObject();
		jo.put("username", "VcCodexAdmin");
		jo.put("password", "MvPvCcOdExAdMiN");
		//here can set body, content type, API call and Auth using reqSpec
		reqSpec.body(jo.toString());
		reqSpec.contentType("application/json");
		// API call
		Response resp = reqSpec.post("https://codex-backend.virtualcontrol.com/admin_portal/login/");
		//Data extraction from JSON response
		ResponseBodyExtractionOptions respo=resp.getBody();
		String accessToken =respo.jsonPath().getString("data.token");
		System.out.println(accessToken);
		//Setting access token for following API
		reqSpec.auth().oauth2(accessToken);
		Response resp1=reqSpec.get("https://codex-backend.virtualcontrol.com/admin_portal/employee/130/");
		//converting json to string
		String respBody=resp1.getBody().asString();
		
		System.out.println(respBody);
  }	
	
  @Test(enabled=false)
  public void g() {
	  
	  final JsonNodeFactory factory = JsonNodeFactory.instance; //Main class
	  final ObjectNode nodeTop = factory.objectNode(); //Object node is seeting object
	  final ObjectNode node = factory.objectNode();
	  final ArrayNode platform = factory.arrayNode(); // Array node is setting array within a key
	  final ObjectNode child = factory.objectNode(); // the child
	//can create as much as child
	  child.put("message", "test");
	  platform.add("ael");
	  platform.add("sam");
	  child.put("asada", platform);
	  child.put("text", "teadadst");

	  // and then can set the child to some other parent using set method

	  node.set("notification", child);
	  nodeTop.set("mankatha", node);
	  
	String samp=  nodeTop.toString();
	System.out.println(samp);
  }
  
}
