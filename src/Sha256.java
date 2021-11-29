import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "sburch";
        String hash = getMd5(str);
        System.out.println("SHA-256 " + str + " is: " + hash);
    }

    public static String getMd5(String input) throws NoSuchAlgorithmException {
        MessageDigest msgDst = MessageDigest.getInstance("SHA-256");
        byte[] msgArr = msgDst.digest(input.getBytes());
        BigInteger bi = new BigInteger(1, msgArr);
        String hshtxt = bi.toString(16);
        while (hshtxt.length() < 32) {
            hshtxt = "0" + hshtxt;
        }
        return hshtxt;
    }
}