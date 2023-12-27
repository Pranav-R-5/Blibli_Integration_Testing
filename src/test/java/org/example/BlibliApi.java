package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BlibliApi {

    public static Response getResponse(String url){
        RestAssured.baseURI=url;
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();
        response.prettyPrint();
        return  response;
    }

    public static String getKeyword(Response response){
        JsonPath jsonPath= response.jsonPath();
        List<String> keywords=jsonPath.getList("data.keyword");
        System.out.println(keywords);
        return keywords.get(0);
    }

}
