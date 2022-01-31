package com.dsa_lab_3;
//Java program To Find The Longest Path From The Root To The Leaf In A 'Binary Tree'.
import java.util.ArrayList;
import java.util.List;

public class LongestPath {
	// Binary-Tree Node Creation
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		// Driver Class
		// hard-coded inputs To The Root & Leaf Nodes Of A Binary Tree

		Node root = new Node(100);
		root.left = new Node(20);
		root.right = new Node(130);
		root.left.left = new Node(10);
		root.left.right = new Node(50);
		root.right.left = new Node(110);
		root.right.right = new Node(140);
		root.left.left.left = new Node(5);

		List<Integer> output = findLongestPath(root);
		System.out.print("Longest Path:");
		System.out.print(output.get(output.size() - 1));

		for (int i = output.size() - 2; i >= 0; i--) {

			System.out.print("->" + output.get(i));
		}

	}

	private static List<Integer> findLongestPath(Node root) {
		// Function To Find And Return The Longest Path
		if (root == null) {
			return new ArrayList<Integer>();
		}

		List<Integer> leftPath = findLongestPath(root.left);
		// Recursive Call On root.left

		List<Integer> rightPath = findLongestPath(root.right);
		// Recursive Call On root.right

		if (rightPath.size() < leftPath.size()) {
			// Compare The Size & Insert Current Node Accordingly
			leftPath.add(root.data);
		} else {
			rightPath.add(root.data);
		}
		if (leftPath.size() > rightPath.size()) {
			// Return The Appropriate List
			return leftPath;
		} else {
			return rightPath;
		}
	}
}
