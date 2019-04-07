package art.school.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileHelper {

    public static byte[] convertFileToByteArray(MultipartFile file) {

        try {
            return file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertByteArrayToString(byte[] arr){
        if(arr == null) return null;
        return new String(Base64.encodeBase64(arr));
    }
}
