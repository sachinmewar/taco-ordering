package sachin.tacocloud.tacocloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sachin.tacocloud.tacocloud.taco.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/*
@WebMvcTest is a special test annotation provided by Spring Boot that arranges for the test to run in
the context of a Spring MVC application. More specifically, in this case, it arranges for
HomeController to be registered in Spring MVC so that you can throw requests against it.

@WebMvcTest also sets up Spring support for testing Spring MVC. Although it
could be made to start a server, mocking the mechanics of Spring MVC is sufficient for
your purposes. The test class is injected with a MockMvc object for the test to drive the
mockup.
*/
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)  // Web test for home controller.
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injects MockMvc


//  The testHomePage() method defines the test you want to perform against the homepage.
//  It starts with the MockMvc object to perform an HTTP GET request for / (the root path).
/*
    From that request, it sets the following expectations:
            The response should have an HTTP 200 (OK) status.
             The view should have a logical name of home.
             The rendered view should contain the text “Welcome to....”
 */
// If, after the MockMvc object performs the request, any of those expectations aren’t
// met, then the test fails.
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))

                .andExpect(status().isOk())

                .andExpect(view().name("home"))

                .andExpect(content().string(
                        containsString("Welcome to...")));
    }
}
