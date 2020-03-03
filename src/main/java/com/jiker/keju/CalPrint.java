package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalPrint {

    private static String receipt = "";

    public static List<String> fileStringList(File file) throws Exception {
        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while ((str = br.readLine()) != null) {
            result.add(str + System.lineSeparator());
        }
        br.close();
        return result;
    }

    public static List<Integer> getNumberfromString(String str) {
        List<Integer> list = new ArrayList<>();
        for (String item : str.replaceAll("[^0-9]", ",").split(",")) {
            if (item.length() > 0) {
                list.add(Integer.parseInt(item));
            }
        }
        return list;
    }

    public static void clearCalString() {
        receipt = "";
    }

    public static String getCalString(String fileStr) throws Exception {
        List<String> list = fileStringList(new File(fileStr));
        for (int i = 0; i < list.size(); i++) {
            List<Integer> numbers = getNumberfromString(list.get(i));
            Integer allPrice = TaxCalculation.calAll(numbers.get(0), numbers.get(1)).setScale(0, BigDecimal.ROUND_UP).intValue();
            receipt = receipt + String.format("收费%d元", allPrice) + ((i != list.size() - 1) ? System.lineSeparator() : "");
        }
        return receipt;
    }
}
