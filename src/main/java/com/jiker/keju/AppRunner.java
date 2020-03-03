package com.jiker.keju;

public class AppRunner {

    public static void main(String[] args) throws Exception {
        String testDataFile = "src/main/resources/testData.txt";
        CalPrint.clearCalString();
        String receipt = CalPrint.getCalString(testDataFile);
        System.out.println(receipt);
    }
}
