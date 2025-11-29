package ru.sb;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.sb.extensions.APIExtensions;
import ru.sb.model.CourseModel;
import ru.sb.services.CoursesService;
import ru.sb.services.UserService;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ExtendWith(APIExtensions.class)
public class CoursesTest {

  @Inject
  private CoursesService coursesService;

  @Test
  public void checkCourse(){
    CourseModel courseModel = coursesService.getCourseByName("Java");

    assertSoftly(softly -> {
      softly.assertThat(courseModel.getName()).isEqualTo("Java");
      softly.assertThat(courseModel.getPrice()).isEqualTo(12000);
    });
  }
}
