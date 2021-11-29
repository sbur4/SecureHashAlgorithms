import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "sburch";
        String hash = getMd5(str);
        System.out.println("SHA-512 " + str + " is: " + hash);
    }

    public static String getMd5(String input) throws NoSuchAlgorithmException {
        MessageDigest msgDst = MessageDigest.getInstance("SHA-512");
        byte[] msgArr = msgDst.digest(input.getBytes());
        BigInteger bi = new BigInteger(1, msgArr);
        String hshtxt = bi.toString(16);
        while (hshtxt.length() < 32) {
            hshtxt = "0" + hshtxt;
        }
        return hshtxt;
    }
}
//512
//e013ebe282092d175a6a28e1df0f8c4019098c38f7a35c51f6c1b92e6ef444025fcaa28efa20fd4fad354caf39b98154e0223dc3cf369765056192c7de917014
//384
//93c35f88cf5e8b3815c5e3390f8899796ee67e5513f390aae29a47bcaa537a1b0fbac9dfef4809149daf49b53c499f21
//256
//f40f7ef4a9dab4ac234a18b6235cafc0b01d4a20130a98ec42a1c2c6a078baf
//1
//f909361efd31c4ab85d1d1f14bb971a3d598aa61
//5
//83831b83da5873d3c71a03d7f8a6c447
//5+salt
//eb3edf8ee228db08425c49f6b30175eb