package ru.sb;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;

@ContextConfiguration(classes = com.consol.citrus.config.CitrusSpringConfig.class)
public class SoapStubTest extends TestNGCitrusSpringSupport {

  @Test
  @CitrusTest
  public void getUserTest() {
    run(soap()
            .client("soapClient")
            .send()
            .message()
            .contentType("text/xml"));

    run(soap()
            .client("soapClient")
            .receive()
            .message()
            .body(
                    "<getUserResponse>" +
                            "<return>" +
                            "<id>1</id>" +
                            "<name>John</name>" +
                            "<cource>Java</cource>" +
                            "<email>john@example.com</email>" +
                            "<age>25</age>" +
                            "</return>" +
                            "<return>" +
                            "<id>2</id>" +
                            "<name>Anna</name>" +
                            "<cource>QA</cource>" +
                            "<email>anna@example.com</email>" +
                            "<age>30</age>" +
                            "</return>" +
                            "<return>" +
                            "<id>3</id>" +
                            "<name>David</name>" +
                            "<cource>Java QA</cource>" +
                            "<email>david@example.com</email>" +
                            "<age>22</age>" +
                            "</return>" +
                            "</getUserResponse>"
            )
    );
  }
}
