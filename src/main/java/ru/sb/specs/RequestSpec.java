package ru.sb.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RequestSpec {

  public static RequestSpecification baseReqSpec = new RequestSpecBuilder()
          .setBaseUri("http://185.251.89.34:8066")
          .setContentType(JSON)
//          .log().all()
          .build();
}
