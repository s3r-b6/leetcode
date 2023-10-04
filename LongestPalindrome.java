import java.util.HashMap;

public class LongestPalindrome {
	public static int longestPalindromeFirstTry(String s) {
		HashMap<Character, Integer> letters = new HashMap<>();

		s.chars().forEach(c -> {
			char ch = (char) c;
			if (!letters.containsKey(ch)) letters.put(ch, 1);
			else letters.put(ch, letters.get(ch) + 1);
		});

		int len = 0;
		for (var entry : letters.entrySet()) {
			int val = entry.getValue();
			if (val % 2 == 0) len += val; // aaaaaa
			else if (len % 2 == 0) len += val; // aaa
			else if (val > 2) len += 2 * (val / 2); // aaaa a
		}

		return len;
	}

	public static int longestPalindrome(String s) {
		//Saw this in another solution and I love it.
		// Way better than the HashMap for this usecase
		int[] count = new int[128];

		s.chars().forEach(c -> count[c]++);
		int len = 0;

		//Basically, we want n pairs and if possible one odd grouping,
		//if impossible, add the even part of the odd grouping.
		for (int v : count) {
			if (v % 2 == 0) len += v; // aaaaaa
			else if (len % 2 == 0) len += v; // aaa
			else if (v > 2) len += v - 1; // aaaa a
		}

		return len;
	}

	public static void main(String[] args) {
		//System.out.println(longestPalindrome("abccccdd"));
		//System.out.println(longestPalindrome("a"));
		//System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
