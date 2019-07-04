package art.school.util;

import org.unbescape.html.HtmlEscape;

import java.util.Arrays;
import java.util.List;

public class TextFormatUtil {

    public static List<String> splitMessageByLineSeparator(String message) {
        return Arrays.asList(message.split("[\\r\\n]+"));
    }

    public static String unescapeText(String text) {
        return HtmlEscape.unescapeHtml(text);
    }

    public static String escapeText(String text) {
        return HtmlEscape.escapeHtml5(text);
    }
}
