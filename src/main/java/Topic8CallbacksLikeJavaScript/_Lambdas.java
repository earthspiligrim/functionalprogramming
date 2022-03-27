package Topic8CallbacksLikeJavaScript;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Lambdas {
    public static void main(String[] args) {
        Function<String, String> nameInUpperCase = name -> name.toUpperCase();

        // the above is a lambda without any extra logic say if you want to add any extra logic

        Function<String, String> toUpperCaseName = name -> {
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> twoArgumentLambdaOne = (name, age) -> {
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };
        String twoArgumentLambdaTrial = twoArgumentLambdaOne.apply("Gopi", 23);


    }
}
