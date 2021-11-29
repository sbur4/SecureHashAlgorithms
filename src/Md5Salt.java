
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Md5Salt {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "sburch";
        byte[] saltArr = receiveSalt();
        String securePsd = getSecurePswd(str, saltArr);
        System.out.println("Md5Salt " + str + " is: " + securePsd);
        String regeneratedPswdToVerify = getSecurePswd(str, saltArr);
        System.out.println("TMd5Salt " + str + " is: " + securePsd);
    }

    public static byte[] receiveSalt() throws NoSuchAlgorithmException {
        SecureRandom secRand = SecureRandom.getInstance("SHA1PRNG");
        byte[] s = new byte[15];
        secRand.nextBytes(s);
        return s;
    }

    private static String getSecurePswd(String psdToHash, byte[] saltArr) {
        String generatedPswd = null;
        try {
            MessageDigest msgDigest = MessageDigest.getInstance("MD5");
            msgDigest.update(saltArr);
            byte[] b = msgDigest.digest(psdToHash.getBytes());
            StringBuilder sbObj = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                sbObj.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPswd = sbObj.toString();
        } catch (NoSuchAlgorithmException obj) {
            obj.printStackTrace();
        }
        return generatedPswd;
    }
}