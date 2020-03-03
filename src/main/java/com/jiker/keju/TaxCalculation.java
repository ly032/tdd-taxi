package com.jiker.keju;

import java.math.BigDecimal;

public final class TaxCalculation {

    private static Integer minDistance = 2;

    private static Integer midDistance = 8;

    private static BigDecimal minPrice = new BigDecimal(6);

    private static BigDecimal midPrice = new BigDecimal(0.8);

    private static BigDecimal addItionalPrice = new BigDecimal(0.5);

    private static BigDecimal waitPrice = new BigDecimal(0.25);

    public static Integer calAll(Integer distance, Integer minute) {
        if (distance - minDistance > 0) {
            return minPrice.add(calTow(distance, minute)).add(calMinute(minute)).setScale(0, BigDecimal.ROUND_UP).intValue();
        } else {
            return minPrice.add(calMinute(minute)).setScale(0, BigDecimal.ROUND_UP).intValue();
        }
    }

    private static BigDecimal calTow(Integer distance, Integer minute) {
        return (distance - minDistance) - midDistance > 0 ? calEight(distance, minute) : new BigDecimal((distance - minDistance)).multiply(midPrice);
    }

    private static BigDecimal calEight(Integer distance, Integer minute) {
        BigDecimal moreLenght = new BigDecimal((distance - midDistance));
        BigDecimal morethanPrice = moreLenght.multiply(midPrice.add(midPrice.multiply(addItionalPrice)));
        return midPrice.multiply(new BigDecimal(midDistance - minDistance)).add(morethanPrice);
    }

    private static BigDecimal calMinute(Integer minute) {
        return waitPrice.multiply(new BigDecimal(minute));
    }
}
