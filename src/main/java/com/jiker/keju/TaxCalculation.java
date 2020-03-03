package com.jiker.keju;

import java.math.BigDecimal;

public class TaxCalculation {

    // 2公里距离
    private static Integer minDistance = 2;

    // 8公里距离
    private static Integer midDistance = 8;

    // 不大于2公里时只收起步价6元
    private static BigDecimal minPrice = new BigDecimal(6);

    // 超过2公里的部分每公里收取0.8元
    private static BigDecimal midPrice = new BigDecimal(0.8);

    // 每公里加收50%长途费
    private static BigDecimal addItionalPrice = new BigDecimal(0.5);

    // 每公里加收50%长途费
    private static BigDecimal waitPrice = new BigDecimal(0.25);

    public static BigDecimal calAll(Integer distance, Integer minute) {
        // 不大于2公里时只收起步价6元
        return distance - minDistance > 0 ? minPrice.add(calTow(distance, minute)).add(calMinute(minute)) : minPrice.add(calMinute(minute));
    }

    public static BigDecimal calTow(Integer distance, Integer minute) {
        // 超过2公里的部分每公里收取0.8元
        return (distance - minDistance) - midDistance > 0 ? calEight(distance, minute) : new BigDecimal((distance - minDistance)).multiply(midPrice);
    }

    public static BigDecimal calEight(Integer distance, Integer minute) {
        // 超过8公里的部分，每公里加收50%长途费
        BigDecimal morethan = new BigDecimal((distance - minDistance)).multiply(midPrice);
        return morethan.add(midPrice.multiply(addItionalPrice.add(new BigDecimal(1))));
    }

    public static BigDecimal calMinute(Integer minute) {
        // 停车等待时加收每分钟0.25元
        return waitPrice.multiply(new BigDecimal(minute));
    }
}
