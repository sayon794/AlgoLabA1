import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner S = new Scanner(System.in);
		int v = S.nextInt();
		int e = S.nextInt();
		WeightedGraph G = new WeightedGraph(v);
		int a, b, c;
		for (int i = 0; i < e; i++) {
			a = S.nextInt();
			b = S.nextInt();
			c = S.nextInt();
			G.connect(a, b, c);
		}
		FloydWarshall FW = new FloydWarshall(G);
		FW.APSP();
		a = S.nextInt();
		b = S.nextInt();
		System.out.println("Shortest Distance: "+FW.getDist(a, b));
		System.out.println("Path:");
		FW.printPath(a, b);
	}
}