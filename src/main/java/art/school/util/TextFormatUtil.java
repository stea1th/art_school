package art.school.util;

import java.util.Arrays;
import java.util.List;

public class TextFormatUtil {

    public static List<String> splitMessageByLineSeparator(String message){
        return Arrays.asList(message.split("[\\r\\n]+"));
    }
}
