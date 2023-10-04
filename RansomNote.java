import java.util.Arrays;

public class RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		char[] ran = ransomNote.toCharArray();
		char[] mag = magazine.toCharArray();
		Arrays.sort(ran);
		Arrays.sort(mag);

		int i = 0, j = 0;

		/*
		Two pointers. i is the pointer for ran, j is the pointer for mag.
		If c1==c2 advance i && j; else, advance j.
		If j is bigger than mag.length then we did not find all necessary letters.
		If i is bigger than ran.length, then we found all necessary letters.
		*/

		while (i < ran.length) {
			char c1 = ran[i], c2 = mag[j];

			System.out.println(c1 + " " + c2);
			if (c1 == c2) {
				i++;
			}
			j++;

			if (j >= mag.length && i < ran.length) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("aab", "baa"));
	}
}
