package com.kputimcevs.insurance.common.utils;

public class MathUtil {
    public static float roundTo2DecimalPositions(float f) {
        return (float) (Math.round(f * 100.0) / 100.0);
    }
}
