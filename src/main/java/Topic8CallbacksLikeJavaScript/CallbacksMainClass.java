package Topic8CallbacksLikeJavaScript;

import java.util.function.Consumer;

public class CallbacksMainClass {
    /*
        JAVASCRIPT CODE
        function hello(firstName, lastName, callback){
            console.log(firstName);
            if(lastName) {
                console.log(lastName)
            } else {
                callback();
            }
        }

     */

    static void firstCallBackInJava(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(!lastName.isEmpty()) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    //callbacks using Runnable
    static void callBackWithRunnable(String firstName, String lastName, Runnable runnable){
        System.out.println(firstName);
        if(!lastName.isEmpty()) {
            System.out.println(lastName);
        } else {
            runnable.run();
        }
    }

    public static void main(String[] args) {

//        firstCallBackInJava("Gopi", null, null);
        firstCallBackInJava("king", "", (firstName) -> { System.out.println("no lastname for " + firstName);});

        callBackWithRunnable("Gopi", "", () -> {
            System.out.println("no last name provided");
        });
    }

}
