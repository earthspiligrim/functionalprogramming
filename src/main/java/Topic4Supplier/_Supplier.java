package Topic4Supplier;

import java.util.List;
import java.util.function.*;

public class _Supplier {

    /*
        Supplier<T> Represents a supplier of results
     */

    static Supplier<String> sendDbConnectionUrl = () -> "emm";

    static Supplier<List<String>> getDbUrlsList = () ->
            List.of(
                    "dbUrlOne",
                    "dbUrlTwo"
            );

    static String getDbConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }
    public static void main(String[] args) {

        System.out.println(getDbConnectionUrl());
        System.out.println(sendDbConnectionUrl.get());
        System.out.println(getDbUrlsList.get());
    }
}
