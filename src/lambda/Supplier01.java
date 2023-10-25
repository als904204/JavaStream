package lambda;

import java.util.function.Supplier;

public class Supplier01 {

    static class Hello { }

    static String getName() {
        return "SIUUUU";
    }


    public static void main(String[] args) {

        Supplier<String> lazySupplier = () -> {
            System.out.println("cache Hello");
            return "lazy Hello";
        };
        String lazyValue = lazySupplier.get();
        System.out.println("lazyValue = " + lazyValue);
        System.out.println("====");


        // String Supplier 리턴
        Supplier<String> StringSup = () -> "HI";
        System.out.println(StringSup.get());

        // 객체 Supplier
        Supplier<Hello> helloSupplier = () -> new Hello();
        System.out.println(helloSupplier.get());
        System.out.println(helloSupplier.getClass());


    }

}
