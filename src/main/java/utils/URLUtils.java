package utils;

public class URLUtils {
	private static final int MAX_URL_LENGTH = 2048; // Giới hạn độ dài URL tối đa

    public static boolean isURLValid(String url) {
        return url != null && url.length() <= MAX_URL_LENGTH;
    }
}
