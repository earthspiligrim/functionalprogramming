package Topic2functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

//the function name can either be _Function or any name without an "_"
public class _Function {

        static int increment(int number){
            return number + 1;
        }
            /*
            The above was our usual approach lets try to Function<T,R>
            Note: Function<T,R> : represents a function that accepts one argument and produces a result..., T -> input type and R -> Return type
             */
        static Function<Integer, Integer> incrementByOneFunction = x -> x + 1;

        static Function<Integer, Integer> multiplyByTenFunction = x -> x * 10;

        /*
            Topic: Chaining --> say you want to combine multiple functions to obtain a desired result
        */
        static Function<Integer, Integer> addOneAndMultiplyTenFunction = incrementByOneFunction.andThen(multiplyByTenFunction);
            /*
            TPOIC: BiFunction
                Takes in two parameters and produces one desired result
             */
        static BiFunction<Integer, Integer, Integer> addOneMultiplyTenBiFunction =
                    (noToIncrementByOne, noToMultiplyByTen) -> (noToIncrementByOne + 1) * noToMultiplyByTen;


        /*
           TYPES OF BI FUNCTIONS Link(https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
           ToDoubleBiFunction<T,U> --> Represents a function that accepts two arguments and produces a double-valued result
           ToIntBiFunction<T,U> --> Represents a function that accepts two arguments and produces an int-valued result
           ToLongBiFunction<T,U> -->  Represents a function that accepts two arguments and produces an long-valued result
           BiFunction<T,U,R> --> Represents a function that accepts two arguments of types T and U and produces an output of type R

         */

        public static void main(String[] args) {
            int increment = increment(0);
            System.out.println(increment);
            System.out.println("Using Function<T, R> and applying the function");
            // using Function<T, R>
            int increment2 = incrementByOneFunction.apply(1);
            System.out.println(increment2);

            /*
            Topic: Chaining --> say you want to combine multiple functions to obtain a desired result
             */
            int multiply = multiplyByTenFunction.apply(increment2);
            System.out.println(multiply);

            System.out.println("Applying Chaining of two functions");
            //applying chaining
            int addByOneandMultiplyByTen = addOneAndMultiplyTenFunction.apply(1);
            System.out.println(addByOneandMultiplyByTen);

            /*
            TPOIC: BiFunction
                Takes in two parameters and produces one desired result
             */
            System.out.println("Applying BiFunction");
            int addOneMulTenBifunctionResult = addOneMultiplyTenBiFunction.apply(4, 100);
            System.out.println(addOneMulTenBifunctionResult);

        }
}
