


public class Main {
	public static void main(String args[]) {
		int A[][] = { {3,2,5,4,8},
					  {5,7,5,6,1},
					  {4,4,6,2,3},
					  {2,8,9,5,8} };
		RockClimbing RC = new RockClimbing(A);
		System.out.println(RC.climb());
	}
}