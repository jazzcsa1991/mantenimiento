/**
 * PropertiesFile.java
 * Fecha de creación: 27/10/2015, 14:43:02
 * <p>
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 * <p>
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package hts.backend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Carga de archivo de propiedades del sistema
 *
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0
 * @since CREDEXT 1.0
 */
public class PropertiesFile {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesFile.class);
	private final static String ARCHIVO_PROPERTIES = "gus.properties";
	private static Properties propiedades;
	public static final int REGISTROS_PAGINA_DETALLE_EVENTO = 50;

	/**
	 * @return Properties
	 */
	public static Properties getFilepropiedad() {
//		try {
//			String ruta = System.getProperty("gusProps");
//			logger.debug("Properties path: " + ruta + ARCHIVO_PROPERTIES);
//
//			File file = new File(ruta + ARCHIVO_PROPERTIES);
//			FileInputStream fileInput = new FileInputStream(file);
//			propiedades = new Properties();
//			propiedades.load(fileInput);
//			fileInput.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return propiedades;

		String ruta = System.getProperty("gusProps");
		FileInputStream inputStream = null;
		File file = null;
		Scanner sc = null;
		try {
			file = new File(ruta + ARCHIVO_PROPERTIES);
			inputStream = new FileInputStream(file);
			propiedades = new Properties();
			propiedades.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file = null;
				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}


		}

		return propiedades;
	}
}
