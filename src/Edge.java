
public class Edge {
	int to,from,cost;
	public boolean bridge;
	public Edge(int to) { this.to = to; }
	public Edge(int to, int cost) { this.to = to; this.cost = cost; }
	public Edge(int from, int to, int cost) { this.from = from; this.to = to; this.cost = cost; }
}
