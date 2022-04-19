package todo;

import java.io.*;

public class BOJ5639 {

	static StringBuilder sb;

	static Node root;

	static class Node {
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	static void insertNode(int element, Node parent) {

		if (element < parent.value) {
			if (parent.leftChild == null) {
				Node n = new Node(element, null, null);
				parent.leftChild = n;
			} else {
				insertNode(element, parent.leftChild);

			}

		} else if (element > parent.value) {
			if (parent.rightChild == null) {
				Node n = new Node(element, null, null);
				parent.rightChild = n;
			} else {
				insertNode(element, parent.rightChild);
			}
		}
	}

	public static void postorderTree(Node root) {
		if (root != null) {
			postorderTree(root.leftChild);
			postorderTree(root.rightChild);
			sb.append(root.value).append("\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String rootVal = br.readLine();
		int rootValue = Integer.parseInt(rootVal);

		root = new Node(rootValue, null, null);

		String val = br.readLine();

		while (val != null) {
			int value = Integer.parseInt(val);
			insertNode(value, root);
			val = br.readLine();
		}

		postorderTree(root);
		System.out.println(sb);
	}

}
