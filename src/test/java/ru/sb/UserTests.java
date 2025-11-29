package ru.sb;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.sb.extensions.APIExtensions;
import ru.sb.model.UserModel;
import ru.sb.model.UserScoreModel;
import ru.sb.services.UserService;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ExtendWith(APIExtensions.class)
public class UserTests {

  @Inject
  private UserService userService;

  @Test
  void checkGetUser() {
    UserModel userModel = userService.getUserById(2);

    assertSoftly(softly -> {
      softly.assertThat(userModel.getName()).isEqualTo("Test user");
    });
  }

  @Test
  void checkUserScore(){
    UserScoreModel userScoreModel = userService.getUserScoreById(1);

    assertSoftly(softly -> {
      softly.assertThat(userScoreModel.getName()).isEqualTo("Test user");
      softly.assertThat(userScoreModel.getScore()).isEqualTo(78);
    });
  }
}
