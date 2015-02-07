package info.idease;

public class RemoveSpace {
	private static String convertStringToUnicode(String original) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < original.length(); i++) {
	        sb.append(String.format("¥¥u%04X", Character.codePointAt(original, i)));
	    }
	    String unicode = sb.toString();
	    return unicode;
	}
	
	private static String convertUnicodeToString(String unicode) {
	    String[] unicodes = unicode.split("¥¥u");
	    int[] codePoints = new int[unicodes.length - 1];
	    for (int i = 0; i < codePoints.length; i++) {
	        codePoints[i] = Integer.parseInt(unicodes[i + 1], 16);
	    }
	    String text = new String(codePoints, 0, codePoints.length);
	    return text;
	}
	
	public static String removeSpace(String str) {
		str = str.replaceAll("\\s", "");
		str = str.replaceAll("　", "");
		String unicode = convertStringToUnicode(str);
		unicode = unicode.replaceAll("¥¥u00A0", "");
		String text = convertUnicodeToString(unicode);
		return text;
	}
	
	public static void main(String[] args) {
		System.out.println(removeSpace("   ho ge　　 "));
	}
}
