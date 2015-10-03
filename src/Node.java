import java.util.ArrayList;


public class Node {
	
	public String name;
	public int discovery,finishing,dist,parent,low;
	public int number;
	public boolean visited;
	public ArrayList<Edge> list = new ArrayList<Edge>();
	
	public void connect(int to, int cost) {
		Edge temp = new Edge(to, cost);
		list.add(temp);
	}
	
	public void connect(int to) {
		Edge temp = new Edge(to);
		list.add(temp);
	}
}
