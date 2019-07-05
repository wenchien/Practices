import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//In graph theory, most two common searches:
//Depth First Search DFS and Breadth First Search BFS
//DFS preferred for searching / visiting every element
//BFS is better for shortest path.
public class Graph {
	public Node[] nodes;
	public Node current;
	public void searchDFS(Node root) {
		if (root == null) {
			return;
		}
		
		//now visit the node
		//and mark visited
		current = root;
		current.value = 1;
		System.out.print("Current Node: " + current.name + ". ");
		
		//Visit the neighbors, go deep first
		for (Node i : current.children) {
			if (i.value != 1) {
				System.out.println("Searching next: " + i.name);
				searchDFS(i);
			}
		}
	}
	
	public void searchBFS(Node root) {
		//Use queue, every node with accecss this queue to visit neighbor
		//Create queue, as the search literally just organize itself into a queue
		Queue<Node> gQueue = new LinkedList<Node>();
		root.value = 1;//mark root as searched / visited
		gQueue.add(root);//this is the mover / pointer
		
		//Traverse through the queue
		while (!gQueue.isEmpty()) {
			current = gQueue.poll();
			current.value = 1;//mark as visited / searched
			//then visits the neighbor node
			for (Node i : current.children) {
				if (i.value != 1) {
					i.value = 1;
					//add the node into the list so its neighbors will be traversed /  visited
					gQueue.add(i);
				}
			}
			
		}
		
	}
}
