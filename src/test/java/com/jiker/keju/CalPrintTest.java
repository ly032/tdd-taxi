package com.jiker.keju;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalPrintTest {

    @Test
    public void calPrintTest() throws Exception {
        // 大于8公里,等待3分钟
        String testDataFile = "src/main/resources/testData.txt";
        String line = System.lineSeparator();
        String testValue = String.format("收费7元" + line + "收费8元" + line + "收费21元");
        calTaxPricePrint(testDataFile, testValue);
    }

    private void calTaxPricePrint(String filePath, String value) throws Exception {
        CalPrint calPrint = new CalPrint();
        assertThat(CalPrint.getCalString(filePath), is(value));
    }
}
