package ru.sb.services;

import com.google.inject.Inject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.sb.helper.UserHelper;
import ru.sb.model.UserModel;
import ru.sb.model.UserScoreModel;

public class UserService extends AbsBaseService {

  @Inject
  private UserHelper userHelper;

  public UserModel getUserById(int id){
     Response response = RestAssured.given(requestSpecification())
            .when()
            .get("/user/" + id);

     return userHelper.extractResultFromArray(response, UserModel.class)
             .stream()
             .filter((UserModel userModel) -> userModel.getId() == id).findFirst().get();
  }

  public UserScoreModel getUserScoreById(int id){
    Response response = RestAssured.given(requestSpecification())
            .when()
            .get("/score/" + id);

    return userHelper.extractResultFromArray(response, UserScoreModel.class)
            .stream()
            .filter((UserScoreModel userScoreModel) -> userScoreModel.getId() == id).findFirst().get();
  }

}
