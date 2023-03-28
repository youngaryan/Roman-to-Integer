import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int romanToInt(String s) {
        int value = 0;
        Pattern pattern = Pattern.compile("(IV|CM|IX|XL|XC|CD)");
        Matcher matcher = pattern.matcher(s);


        while (matcher.find()) {
            String match = matcher.group();
            switch (match) {
                case "IV" -> value += 4;
                case "CM" -> value += 900;
                case "IX" -> value += 9;
                case "XL" -> value += 40;
                case "XC" -> value += 90;
                case "CD" -> value += 400;
            }
        }
        s = s.replaceAll("(IV|CM|IX|XL|XC|CD)", "");


        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I' -> value++;
                case 'V' -> value += 5;
                case 'X' -> value += 10;
                case 'L' -> value += 50;
                case 'C' -> value += 100;
                case 'D' -> value += 500;
                case 'M' -> value += 1000;
            }
        }

        return value;
    }
}