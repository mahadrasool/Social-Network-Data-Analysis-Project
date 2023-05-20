package bst;

import graphs.GraphVertex;
import linkedlist.*;

public class BST {
	
	GraphNode root;
	
	
	public GraphNode getRoot() {
		return this.root;
	}
		
	public void insert(GraphVertex newVertex) {
		//System.out.println("Inserting vertex " + newVertex.getKey());
		GraphNode newNode = new GraphNode();
		newNode.vertex = newVertex;
		
		GraphNode current = this.root;
		GraphNode destination = null;
		
		while (current != null && current.vertex != null) {
			destination = current;
			
			if (newVertex.getKey() < current.vertex.getKey())
				current = current.left;
			else 
				current = current.right;
		}
		
		newNode.parent = destination;
		
		if (destination == null)
			this.root = newNode;
		else if (newNode.vertex.getKey() < destination.vertex.getKey())
			destination.left = newNode;
		else
			destination.right = newNode;
			
	}
	
	
	public GraphNode findMin(GraphNode treeRoot) {
		if (treeRoot == null)
			return treeRoot;
		else if (treeRoot.left == null)
			return treeRoot;
		else 
			return findMin(treeRoot.left);
					
	}
	
	public void deleteNode(GraphNode node) {
		
		/*
		 * Checking whether node is leaf or not
		 */
		if (node.left == null && node.right == null) {
			if (node.parent.left == node) {
				node.parent.left = null;
				node = null;
			}
			else {
				node.parent.right = null;
				node = null;
			}
						
		}
		
		/*
		 * Checking in these else if conditions whetehr node has minimum one child
		 */
		else if (node.left == null && node.right != null) {
			node.vertex = node.right.vertex;
			node.right = null;
		}
		else if (node.right == null && node.left != null) {
			node.vertex = node.left.vertex;
			node.left = null;
		}
		
		/*
		 * Checking if node contains both child 
		 */
		else {
			GraphNode min = findMin(node.right);
			node.vertex = min.vertex;
			if (min.parent.left == min)
				min.parent.left = null;
			else
				min.parent.right = null;
			min = null;
		}
	}
	
	
	public GraphNode searchNode(GraphNode node,int key) {
			
		if (node == null )
			return node;
		
		//System.out.println("Running in condition Why?" + node);
		
		if (node.vertex.getKey() == key)
			return node;
		else if (node.vertex.getKey() < key)
			return searchNode(node.right, key);
		else
			return searchNode(node.left, key);
					
	}
	
	

}
