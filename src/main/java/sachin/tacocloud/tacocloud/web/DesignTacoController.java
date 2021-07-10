
package sachin.tacocloud.tacocloud.web;

/*
This class will :
  1) Handle HTTP GET requests where the request path is /design
  2) Build a list of ingredients
  3) Hand the request and the ingredient data off to a view template to be rendered
     as HTML and sent to the requesting web browser
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sachin.tacocloud.tacocloud.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    The first, @Slf4j, is a Lombok-provided annotation that, at runtime,
    will automatically generate an SLF4J (Simple Logging Facade for Java,
    https://www.slf4j.org/) Logger in the class.

    This modest annotation has the same effect as if you were to explicitly add
    the following line within the class:
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

    The next annotation applied to DesignTacoController is @Controller. This
    annotation serves to identify this class as a controller and to mark it as a candidate for
    component scanning, so that Spring will discover it and automatically create an
    instance of DesignTacoController as a bean in the Spring application context.

    The @RequestMapping annotation, when applied at the class level, specifies the kind of requests that
    this controller handles. In this case, it specifies that DesignTacoController will handle requests
    whose path begins with /design.
*/

@Slf4j // ?
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        /*
        Model is an object that ferries data between a controller and whatever view is charged with rendering that data.
         Ultimately, data that’s placed in Model attributes is copied into the servlet response attributes,
         where the view can find them. The showDesignForm() method concludes by returning "design", which is the
         logical name of the view that will be used to render the model to the browser.
         */
        Ingredient.Type [] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
