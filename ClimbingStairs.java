import java.util.HashMap;

public class ClimbingStairs {
	static HashMap<Integer, Integer> memo = new HashMap<>();

	//This looks very similar to fib, so just storing values should do the trick
	public static int climbStairs(int n) {
		if (n == 0) return 1;
		else if (n < 0) return 0;

		if (memo.containsKey(n)) {
			return memo.get(n);
		} else {
			int val = climbStairs(n - 1) + climbStairs(n - 2);
			memo.put(n, val);
			return val;
		}
	}


	public static void main(String[] args) {
		climbStairs(44);
	}
}
