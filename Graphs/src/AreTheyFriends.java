import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
	String name;
	int value = 0;
	ArrayList<Vertex> adjacent;

	public Vertex(String name, int value) {
		this.name = name;
		this.value = value;
		adjacent = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ArrayList<Vertex> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(ArrayList<Vertex> adjacent) {
		this.adjacent = adjacent;
	}
}

class BFSGraph {
	Vertex current;

	public void BFSFind(Vertex root) {
		//Initial cases
		Queue<Vertex> q_Vertex = new LinkedList<>();
		current = root;

		//mark root as visited
		current.value = 1;
		q_Vertex.add(current);

		while (!q_Vertex.isEmpty()) {
			current = q_Vertex.poll();
			for (Vertex i : current.adjacent) {
				System.out.println("I'm looking at: " + current.name);
				if (i.value != 1) {
					i.value = 1;
					q_Vertex.add(i);
					for (Vertex j : i.adjacent) {
						if (j.name == current.name) {
							System.out.println("Undirected edges between: " + current.name + " and " + i.name);
							System.out.println("Therefore they are friends :)");
							break;
						}
						else {
							System.out.println("Directed edges for now: " + current.name + ", neighbor: " + i.name + ", neighbor's j " + j.name);
							//how to break loop here?
						}
					}
				}
			}
		}
	}
}
public class AreTheyFriends {
	public static void main(String[] args) {
		Vertex zero = new Vertex("0", 0);
		Vertex one = new Vertex("1", 0);
		Vertex two = new Vertex("2", 0);
		Vertex three = new Vertex("3", 0);
		Vertex four = new Vertex("4", 0);
		Vertex five = new Vertex("5", 0);

		//Adjacent
		zero.getAdjacent().add(one);
		zero.getAdjacent().add(four);
		zero.getAdjacent().add(five);

		one.getAdjacent().add(three);
		one.getAdjacent().add(four);

		two.getAdjacent().add(one);

		three.getAdjacent().add(two);
		three.getAdjacent().add(four);

		four.getAdjacent().add(zero);
		five.getAdjacent().add(zero);

		BFSGraph graph1 = new BFSGraph();
		graph1.BFSFind(zero);
	}
}
