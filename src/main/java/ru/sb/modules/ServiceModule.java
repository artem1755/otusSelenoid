package ru.sb.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import ru.sb.helper.UserHelper;
import ru.sb.services.CoursesService;
import ru.sb.services.UserService;

public class ServiceModule extends AbstractModule {

  @Singleton
  @Provides
  public UserService getUserService(){
    return new UserService();
  }

  @Singleton
  @Provides
  public CoursesService getCoursesService(){
    return new CoursesService();
  }

  @Provides
  @Singleton
  public UserHelper getUserHelper(){
    return new UserHelper();
  }
}
