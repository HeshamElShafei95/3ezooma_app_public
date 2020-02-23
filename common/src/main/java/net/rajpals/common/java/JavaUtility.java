package net.rajpals.common.java;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import net.rajpals.common.LibApp;

public class JavaUtility {
    private static String TAG = DateTimeUtility.class.getName();

    // Convert FEET TO METER
    public static double feetToMeter(double feet) {
        try {
            return feet * 0.3048d;
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return 0d;
    }

    // Convert METER TO FEET
    public static double meterToFeet(double meter) {
        try {
            return meter * 3.28084d;
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return 0d;
    }

    // Convert METER TO MILES
    public static int ConvertMetersToMiles(double meters)
    {
        return (int)Math.ceil(Math.abs(meters / 1609.344));
    }



    // Convert CELSIUS TO FAHRENHEIT
    public static double celsiusToFahrenheit(double celsius) {
        try {
            return (celsius * 1.8d) + 32;
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return 0d;
    }

    // Convert  FAHRENHEIT TO CELSIUS
    public static double fahrenheitToCelsius(double fahrenheit) {
        try {
            return (fahrenheit - 32) * .55d;
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return 0d;
    }

    //Format  float or double value up to 2 digit
    public static String formatUptoTwoDigit(double value) {
        try {
            return String.valueOf(Double.parseDouble(new DecimalFormat("###.##").format(value)));
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return "0";
    }

    public static double getExpoToDouble(double value) {
        try {
            long longValue = new BigDecimal(value).longValue();
            return (longValue);
        } catch (NumberFormatException ex) {
            LibApp.showException(TAG, ex);
        }
        return value;
    }

    public static float round(float input, float step) {
        try {
            return ((Math.round(input / step)) * step);
        } catch (Exception ex) {
            LibApp.showException(TAG, ex);
        }
        return input;
    }
}
//Double.parseDouble(new DecimalFormat("###.##").format(
