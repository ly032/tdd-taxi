package com.jiker.keju;

import org.hamcrest.Matcher;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppRunnerTest {

    @Test
    public void lessTowTest() throws Exception {
        // 小于2公里,等待0分钟
        calTaxPrice(1,0,6);
    }

    @Test
    public void equalsTowTest() throws Exception {
        // 等于2公里,等待0分钟
        calTaxPrice(2,0,6);
    }

    @Test
    public void lessEightTest() throws Exception {
        // 大于2公里并小于8公里,等待0分钟
        calTaxPrice(4,0,8);
    }

    @Test
    public void equalsEightTest() throws Exception {
        // 等于8公里,等待0分钟
        calTaxPrice(8,0,11);
    }

    @Test
    public void moreEightTest() throws Exception {
        // 大于8公里,等待0分钟
        calTaxPrice(12,0,16);
    }

    @Test
    public void equalsTowWaitTest() throws Exception {
        // 等于2公里,等待6分钟
        calTaxPrice(2,6,8);
    }

    @Test
    public void equalsEightWaitTest() throws Exception {
        // 等于8公里,等待5分钟
        calTaxPrice(8,5,13);
    }

    @Test
    public void moreEightWaitTest() throws Exception {
        // 大于8公里,等待3分钟
        calTaxPrice(12,3,16);
    }

    private void calTaxPrice(Integer distance, Integer minute, Integer value) {
        assertThat(TaxCalculation.calAll(distance,minute), is(value));
    }
}
