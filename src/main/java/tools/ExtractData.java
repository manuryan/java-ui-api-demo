package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractData {
    public static String extractWordInBrackets(String input) {
        String regex = "\\((\\w+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}