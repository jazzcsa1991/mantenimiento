package hts.backend.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;

import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * TODO [Agregar documentacion de la clase]
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0
 * @since CREDEXT 1.0
 */
public class SecurityUtil {

	private static String salt;
    private static int iterations = 65536  ;
    private static int keySize = 256;
    private static byte[] ivBytes;
    private static SecretKey secretKey;

    /**
     * TODO [Agregar documentacion al método]
     * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
     * @param path
     * @param keyPair
     * @param tipo
     * @throws IOException
     */
    public void SaveKeyPair(String path, KeyPair keyPair, String tipo) throws IOException {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Store Public Key.
		FileOutputStream fos = null;
		try{
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
			fos = new FileOutputStream(path + "/" + tipo + "public.key" , false);
			fos.write(x509EncodedKeySpec.getEncoded());
			if(null != fos){
				try {
					fos.close();
				}catch (Exception e){

				}

			}
			// Store Private Key.
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec =
					new PKCS8EncodedKeySpec(privateKey.getEncoded());
			fos = new FileOutputStream(path + "/" + tipo + "private.key", false);
			fos.write(pkcs8EncodedKeySpec.getEncoded());

		}catch (Exception e){

		}finally {
			if(null != fos){
				try {
					fos.close();
				}catch (Exception e){

				}

			}
		}


    }

    public String getRole(String username) {
    	  return "1";
    	}


}
