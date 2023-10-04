import java.util.Arrays;

public class ValidAnagram {
	static class Solution {
		public char[] quickSortString(String s) {
			char[] chars = s.toCharArray();
			quickSortHelper(chars, 0, chars.length - 1);
			return chars;
		}


		public void quickSortHelper(char[] array, int start, int end) {
			if (end <= start) return;

			int pivot = partition(array, start, end);
			quickSortHelper(array, start, pivot - 1);
			quickSortHelper(array, pivot + 1, end);
		}

		private static int partition(char[] array, int start, int end) {
			char pivot = array[end];
			int i = start - 1;

			for (int j = start; j < end; j++) {
				if (array[j] < pivot) swap(array, j, ++i);
			}

			swap(array, end, ++i);

			return i; //The pivot location
		}

		private static void swap(char[] array, int end, int i) {
			char temp = array[i];
			array[i] = array[end];
			array[end] = temp;
		}

		public boolean isAnagram(String s, String t) {
			char[] s1 = quickSortString(s);
			char[] t1 = quickSortString(t);

			return Arrays.equals(s1, t1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isAnagram("anagram", "nagaram"));
		char[] str = "khqthkqwthlkqhwklt".toCharArray();
		Arrays.sort(str);
	}
}
