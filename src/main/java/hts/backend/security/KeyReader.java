package hts.backend.security;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.google.common.io.Resources;
import hts.backend.controller.CatalogosController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URL;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyReader {
    public KeyReader() {
    }
    private static final Log logger = LogFactory.getLog(CatalogosController.class);


    public RSAPrivateKey getPrivate(String filename) {
        logger.info("############# reader #####################");

        try {
            URL fileURL = this.getClass().getResource(filename);
            if (fileURL == null) {
                throw new RuntimeException();
            } else {
                byte[] keyBytes = Resources.toByteArray(fileURL);
                EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
                KeyFactory kf = KeyFactory.getInstance("RSA");
                return (RSAPrivateKey)kf.generatePrivate(spec);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            throw new RuntimeException(":::::: NO SE PUDO OBTENER LA LLAVE PRIVADA");
        }
    }

    public RSAPublicKey getPublic(String filename) {
        logger.info("############# reader public #####################");
        logger.info(filename);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            URL fileURL = this.getClass().getResource(filename);
            logger.info(fileURL);
            if (fileURL == null) {
                throw new RuntimeException();
            } else {
                byte[] keyBytes = Resources.toByteArray(fileURL);
                X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
                KeyFactory kf = KeyFactory.getInstance("RSA");
                return (RSAPublicKey)kf.generatePublic(spec);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            throw new RuntimeException(":::::: NO SE PUDO OBTENER LA LLAVE PÚBLICA");
        }
    }
}
