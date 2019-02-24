package art.school.util;

import art.school.entity.NachrichtUpdater;

public class TextFormatUtil {

    public static String formatText(String text){
        System.out.println(text);

        return replaceTag(text, "quote");
    }

    private static String replaceTag(String text, String tag){
        text = text.replace("[" + tag + "]", "<blockquote>  ");
        return text.replace("[/" + tag + "]", "</blockquote>");
    }

    public static String createUpdaterInfo(NachrichtUpdater updater){
        return " " + updater.getAction() + " " +
                updater.getUser().getName() + " " +
                DateUtil.transformDateForForum(updater.getDatum());
    }
}
