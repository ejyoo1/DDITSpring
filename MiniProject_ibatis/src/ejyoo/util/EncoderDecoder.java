package ejyoo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class EncoderDecoder {
	private static final Logger EXCEPTION_LOGGER = Logger.getLogger(EncoderDecoder.class);
	
	public static String textEncoder(String str) {
		String encodeTxt = "";
		try {
			encodeTxt = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		return encodeTxt;
	}
	
	public static String textDecoder(String str) {
		String decodeTxt = "";
		try {
			decodeTxt = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			EXCEPTION_LOGGER.error(e.getMessage());
		}
		return decodeTxt;
	}
}
