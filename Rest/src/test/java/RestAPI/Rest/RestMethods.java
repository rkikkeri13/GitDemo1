package RestAPI.Rest;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.*;
public class RestMethods {


public static void main(String[] args) throws Exception
{
  String sUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
  RestAssured.baseURI = sUrl;
  Response res = RestAssured.given().body("{\"username\":\"rachana@ta.com\",\"password\":\"rachana\"}").when().contentType("application/json").post();
  System.out.println(res.asString());
  System.out.println(res.jsonPath().getString("token").toString());
  String s= res.jsonPath().getString("token").toString();
  String s1 = s.replace("[", "").replace("]", "");
  System.out.println(s1);
  if(res.jsonPath().getString("token").contains(" "))
  {
	  throw new Exception("it's an empty string");
  }
  String userid = res.jsonPath().getString("userid").toString();
  userid = userid.replace("[", "").replace("]","");
  String getUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata";
  RestAssured.baseURI=getUrl;
  HashMap<String,String> map = new HashMap<String,String>();
  map.put("token", s1);
  Response resGet =RestAssured.given().contentType("application/json").when().headers(map).get();
  System.out.println(resGet.asString().toString());
  
  String addUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData";
  RestAssured.baseURI=addUrl;
  HashMap<String,String> mapadd = new HashMap<String,String>();
  mapadd.put("token", s1);
  Response resAdd = RestAssured.given().body("{\"accountno\": \"23444708\", \"departmentno\": \"5\", \"salary\": \"56\", \"pincode\": \"353454\"}").when().contentType("application/json").headers(map).post();
  System.out.println(resAdd.asString().toString());
  
  String updateUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData";
  RestAssured.baseURI=updateUrl;
  HashMap<String,String> mapUpdate = new HashMap<String,String>();
  mapUpdate.put("token", s1);
  Response resUpdate = RestAssured.given().body("{\"accountno\": \"23444708\", \"departmentno\": \"3\", \"salary\": \"56\", \"pincode\": \"353454\", \"userid\": \"6FgNWCVN5n20bJEXAbKP\",\"id\": \"LHUPPaBOOLJoECCuIx3w\"}").when().contentType("application/json").headers(mapUpdate).put();
  
  System.out.println(resUpdate.asString().toString());
  
  String deleteUrl = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/deleteData";
  RestAssured.baseURI = deleteUrl;
  HashMap<String,String> deleteU = new HashMap<String,String>();
  deleteU.put("token",s1);
  Response resDelete = RestAssured.given().body("{\"id\": \"LHUPPaBOOLJoECCuIx3w\", \"userid\": \"6FgNWCVN5n20bJEXAbKP\"}").when().contentType("application/json").headers(deleteU).delete();
  System.out.println(resDelete.asString().toString());
}
}
