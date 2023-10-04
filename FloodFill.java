public class FloodFill {
	static class Solution {
		public static int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
			if (newColor == img[sr][sc]) return img;

			recursiveFill(img, sr, sc, newColor, img[sr][sc]);
			return img;
		}

		public static void recursiveFill(int[][] img, int row, int col, int newColor, int oldColor) {
			if (row < 0 || col < 0 || row >= img.length || col >= img[0].length || img[row][col] != oldColor) return;

			img[row][col] = newColor;

			recursiveFill(img, row - 1, col, newColor, oldColor);
			recursiveFill(img, row + 1, col, newColor, oldColor);
			recursiveFill(img, row, col - 1, newColor, oldColor);
			recursiveFill(img, row, col + 1, newColor, oldColor);
		}
	}

	public static void main(String[] args) {
		int[][] img = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		Solution.floodFill(img, 1, 0, 2);
	}
}
