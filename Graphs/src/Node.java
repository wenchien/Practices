
public class Node {
	String name;
	int value = 0;
	Node[] children;
	
	public Node (String name, int value, Node[] children) {
		this.name = name;
		this.value = value;
		this.children = children;
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

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}
}
