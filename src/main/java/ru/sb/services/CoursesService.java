package ru.sb.services;

import com.google.inject.Inject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.sb.helper.UserHelper;
import ru.sb.model.CourseModel;

public class CoursesService extends AbsBaseService {

  @Inject
  private UserHelper userHelper;

  public CourseModel getCourseByName(String name){
    Response response = RestAssured.given(requestSpecification())
            .when()
            .get("/courses");

    return userHelper.extractResultFromArray(response, CourseModel.class)
            .stream()
            .filter(item -> item.getName().equals(name)).findFirst().get();
  }
}
