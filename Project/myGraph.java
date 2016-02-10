package mygraph;

import java.util.HashSet;
import java.util.Set;

import graph.IEdge;
import graph.IGraph;
import graph.INode;
import graph.IPath;

public class myGraph{
	private IGraph graph;
	private IGraph graphTransform;
	public static void main(String[] args)
	{
		INode root = new Node();
		graph = new Graph(root);
		//Make a graph
		INode root2 = new NodeTransform();
		graphTransform = new GraphTransfrom(root2);
		graphTransform = graphTransform.transform(graph);
	}

}
public class GraphtoStringVisitor {
	private IGraph mGraph;
	private String mOutputString;
	private Set<INode> mVisited = new HashSet<INode>();
	public GraphtoStringVisitor(IGraph graph) {
		this.mGraph = graph;
	}

	public void visit() {
		this.mOutputString = "Graph = " + this.mGraph.getId();
		this.mOutputString = this.mOutputString + "\n";
		this.visit(this.mGraph.getRoot());
	}

	private void visit(INode node) {
		if(this.mVisited.contains(node)) {
			return;
		}
		this.mVisited.add(node);
		this.mOutputString = this.mOutputString + "\nnode = " + node.getId() + "\n";
		for(IEdge e : node.getOutgoingEdgeList()) {
				this.visit(e);
		}
		for(IEdge e : node.getOutgoingEdgeList()) {
			this.visit(e.getHead());
		}
	}

	private void visit(IEdge e) {
		this.mOutputString = this.mOutputString + "\n";
		this.mOutputString = this.mOutputString + "edge " + e.getId() + " = (";
		this.mOutputString = this.mOutputString + e.getTail().getId() + ", ";
		this.mOutputString = this.mOutputString + e.getHead().getId() + ")";
	}

	public String getOutputString() {
		return this.mOutputString;
	}
}
