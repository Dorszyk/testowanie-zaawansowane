package com.sda.testing.solution.conversion;

public class MeasurementConverter {

    public double convert(double value, ConversionType conversionType) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }
        return conversionType.getConverter().apply(value);
    }
}
