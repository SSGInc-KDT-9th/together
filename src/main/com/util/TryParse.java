package main.com.util;

import javax.swing.*;
import java.text.ParseException;

public class TryParse {
    public static Integer tryParseInt(String str, Integer defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static Long tryParseLong(String str, Long defaultValue) {
        if (str == null || str.isEmpty()) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "숫자만 입력하세요", "ERROR", JOptionPane.WARNING_MESSAGE);
            throw new IllegalArgumentException("Parsing 안된느 숫자 입력");
        }
    }
}
