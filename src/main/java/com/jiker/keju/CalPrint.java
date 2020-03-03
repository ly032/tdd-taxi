package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalPrint {

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
            list.add(item.length() == 0 ? 0 : Integer.parseInt(item));
        }
        return list;
    }

    public static String getCalString(String fileStr) throws Exception {
        List<String> list = fileStringList(new File(fileStr));
        String receipt = "";
        for (String item : list) {
            List<Integer> numbers = getNumberfromString(item);
            BigDecimal allPrice = TaxCalculation.calAll(numbers.get(0), numbers.get(1));
            receipt = receipt + String.format("收费%d元", allPrice.setScale(0, BigDecimal.ROUND_UP).intValue()) + System.lineSeparator();
        }
        return receipt;
    }
}
