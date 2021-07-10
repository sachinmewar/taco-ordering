package sachin.tacocloud.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
The most unusual thing about this Ingredient class is that it seems to be missing the usual set of
getter and setter methods and other useful methods like equals(), hashCode(),
toString(), and others.
We are using an amazing library called Lombok to automatically generate those methods at runtime.

The @Data annotation at the class level is provided by Lombok and tells
Lombok to generate all of those missing methods as well as a constructor that accepts
all final properties as arguments.
Lombok isn’t a Spring library, but it’s so incredibly useful.
 */

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type  {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
