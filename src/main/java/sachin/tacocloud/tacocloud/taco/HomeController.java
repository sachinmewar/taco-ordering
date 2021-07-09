package sachin.tacocloud.tacocloud.taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// The primary purpose of Controller is to identify this class as a component for component
// scanning. Because HomeController is annotated with @Controller, Spring’s
// component scanning automatically discovers it and creates an instance of Home-
// Controller as a bean in the Spring application context.

@Controller
public class HomeController {

    // home() method is annotated with @GetMapping to indicate that if an HTTP GET request
    // is received for the root path /, then this method should handle that request.
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
