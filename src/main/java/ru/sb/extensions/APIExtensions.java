package ru.sb.extensions;

import com.google.inject.Guice;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.sb.modules.ServiceModule;

public class APIExtensions implements BeforeEachCallback {

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    Guice.createInjector(new ServiceModule()).injectMembers(
            context.getTestInstance().orElseThrow(
                    () -> new RuntimeException("Error")
            )
    );
  }
}
