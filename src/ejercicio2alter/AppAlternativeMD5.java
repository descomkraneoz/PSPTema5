package ejercicio2alter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;

public class AppAlternativeMD5 {
    public static void main(String[] args) throws Exception {

        /*String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());*/
        //e10adc3949ba59abbe56e057f20f883e

        File input = new File("C:\\Users\\desco\\Desktop\\pruebaImagenMD5.jpg");

        BufferedImage buffImg = ImageIO.read(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(buffImg, "jpg", outputStream);
        byte[] data = outputStream.toByteArray();

        System.out.println("Start MD5 Digest");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data);
        byte[] hash = md.digest();
        System.out.println(returnHex(hash));

        //ecfcb4d1735459cfcb5b13d8cef0db9a
    }

    static String returnHex(byte[] inBytes) throws Exception {
        String hexString = "";
        for (int i = 0; i < inBytes.length; i++) {
            hexString += Integer.toString((inBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexString;
    }
}


