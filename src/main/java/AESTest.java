import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESTest {
    public static void main(String[] args) {

        try {
            String keyStr = "INSERT KEY HERE";
            byte[] decodedKey = Base64.getDecoder().decode(keyStr);
            SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            String stringTest = "prueba";
            IvParameterSpec ivParameterSpec = AESTool.generateIv();
            String algorithm = "AES/CBC/PKCS5Padding";
            String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

            System.out.println("Original String: " + stringTest);
            System.out.println("Key: " + key);
            System.out.println("Encoded Key: " + encodedKey);
            System.out.println("IV: " + ivParameterSpec);

            String encryptedString = AESTool.encrypt(algorithm, stringTest, key, ivParameterSpec);
            System.out.println("Encrypted String: " + encryptedString);

            String decryptedString = AESTool.decrypt(algorithm, encryptedString, key, ivParameterSpec);
            System.out.println("Decrypted String: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
