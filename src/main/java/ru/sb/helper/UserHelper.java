package ru.sb.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;

public class UserHelper {
  public <T> List<T> extractResultFromArray(Response response, Class<T> clazz) {
    JsonPath jsonPath = response.then().extract().jsonPath();
    return jsonPath.getList("", clazz);
  }
}
