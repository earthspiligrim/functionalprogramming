package Topic3Consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    /*
    Docs At: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
        Consumer<T>: Represents an operation that accepts a single input argument and returns no result.
     */

    static Consumer<Customer> printCustomerConsumer = customer -> {
        System.out.println("print your stuff like " + customer.customerName + " and phone "+ customer.customerPhone);
    };

    static BiConsumer<Customer, Boolean> showPhoneNumber = (customer, printPhone) -> {
        System.out.println("hello " + customer.customerName + ", thanks for registering phone number "
                            + (printPhone ? customer.customerPhone : "********"));
    };
    /*
    the below is the old way of doing this rather than use Consumer like above
     */
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + " your phone : " + customer.customerPhone);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhone;

        public Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }
    }


    public static void main(String[] args) {
        Customer earth = new Customer("Gopi", "856999");
        //old way
        greetCustomer(earth);

        //using Consumer -> Functional interface
        printCustomerConsumer.accept(earth); // NOTE: you would be using accept instead of apply like in Function.

        //using BiConsumer
        showPhoneNumber.accept(earth, true);
    }

}
