package bst;

import graphs.GraphVertex;

public class GraphNode {

		public GraphVertex vertex;
		public GraphNode next;
		public GraphNode right;
		public GraphNode left;
		public GraphNode parent;

		public GraphNode() {
			this.vertex = null;
			this.parent = null;
			this.right = null;
			this.left = null;
		}
}
