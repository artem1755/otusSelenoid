package ru.sb.services;

import com.google.inject.Guice;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.sb.modules.ServiceModule;

public abstract class AbsBaseService {

  public AbsBaseService(){
    Guice.createInjector(new ServiceModule()).injectMembers(this);
  }

  protected RequestSpecification requestSpecification(){
    RestAssured.defaultParser = Parser.JSON;
    return RestAssured.given()
            .baseUri("http://185.251.89.34:8066")
            .basePath("/api");
  }

  protected ResponseSpecification responseSpecification(){
    RestAssured.defaultParser = Parser.JSON;
    return RestAssured.given()
            .then().statusCode(200);
  }
}
