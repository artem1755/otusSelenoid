package ru.sb.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ru.sb.model.UserModel;

import java.util.List;
import java.util.Map;

public class UserHelper {
  public <T> List<T> extractResultFromArray(Response response, Class<T> clazz) {
    JsonPath jsonPath = response.then().extract().jsonPath();
    return jsonPath.getList("", clazz);
  }

  public List<UserModel> extractFromXml(Response response) {
    return response.xmlPath()
            .getList("**.return", Map.class)
            .stream()
            .map(map -> UserModel.builder()
                    .id(Integer.parseInt(String.valueOf(map.get("id"))))
                    .name((String) map.get("name"))
                    .cource((String) map.get("cource"))
                    .email((String) map.get("email"))
                    .age(Integer.parseInt(String.valueOf(map.get("age"))))
                    .build())
            .toList();
  }
}
