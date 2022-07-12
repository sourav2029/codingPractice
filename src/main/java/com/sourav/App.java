package com.sourav;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int sum = 0;
        if (args.length > 0) {
            for (String arg : args) {
                int temp = Integer.parseInt(arg);
                sum += temp;
            }
            System.out.println(sum);

        } else {
            System.out.println("Please provide two space separated integer inputs");
        }
    }
}
