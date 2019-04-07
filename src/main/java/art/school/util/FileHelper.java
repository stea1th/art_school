package art.school.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileHelper {

    public static byte[] convertFileToByteArray(MultipartFile file) {
//        BASE64Decoder decoder = new BASE64Decoder();

        try {
//            byte[] arr = file.getBytes();
//            byte[] arr = IOUtils.toByteArray(new ByteArrayInputStream(file.getBytes()));
//            System.out.println(Arrays.toString(arr));
            return file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertByteArrayToString(byte[] arr){
        return new String(Base64.encodeBase64(arr));
    }
}
