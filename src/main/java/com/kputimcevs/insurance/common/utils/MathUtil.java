package com.kputimcevs.insurance.common.utils;

public class MathUtil {
    public static double roundTo2DecimalPositions(double f) {
        return Math.round(f * 100.0) / 100.0;
    }
}
