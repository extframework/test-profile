package dev.extframework.test.profile;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(args));

        while (true) {
            System.out.println("Still going strong");

            Thread.sleep(500);
        }
    }
}
