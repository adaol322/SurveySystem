package surveys.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static String NAME_PATTERN = "[A-Z][a-z]+";

    public static boolean validateString(String string){
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
