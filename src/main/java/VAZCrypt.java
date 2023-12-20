import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class VAZCrypt {
    private static final String ALGORITMO = "AES";
    private static final int TAMANO_CLAVE = 128;

    public static SecretKey generarClave() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITMO);
        keyGen.init(TAMANO_CLAVE);
        return keyGen.generateKey();
    }

    public static String encriptarFR(String textoPlano, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoCifrado = cipher.doFinal(textoPlano.getBytes());
        return java.util.Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String desencriptarFR(String textoCifrado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoPlano = cipher.doFinal(java.util.Base64.getDecoder().decode(textoCifrado));
        return new String(textoPlano);
    }

    public static SecretKey convertirStringAClave(String claveComoString) {
        byte[] claveBytes = Base64.getDecoder().decode(claveComoString);
        return new SecretKeySpec(claveBytes, 0, claveBytes.length, "AES");
    }

    public static String convertirClaveAString(SecretKey clave) {
        byte[] claveBytes = clave.getEncoded();
        return Base64.getEncoder().encodeToString(claveBytes);
    }
}

/**
	Broker prueba: tarragona
	Clave:		   Tarra1993
 **/