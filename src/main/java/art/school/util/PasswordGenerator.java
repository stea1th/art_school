package art.school.util;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {

    public static String generate(){
        return generate(8);
    }

    public static String generate(int length){
        return RandomStringUtils.random(length, true, true);
    }
}
