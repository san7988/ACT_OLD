package graph;

import graph.INode;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;


public class Graph implements IGraph {

	private INode mRoot;
	private List<INode> mNodes = new ArrayList<INode>();
	private List<IEdge> mEdges = new ArrayList<IEdge>();

	public Graph(INode root) {
		this.mNodes.add(root);
		this.mRoot = root;
		root.setGraph(this);
	}

	@Override
	public INode getRoot() {
		return this.mRoot;
	}

	@Override
	public INode addNode(INode node) {
		if(this.mNodes.contains(node)) {
			return null;
		}
		this.mNodes.add(node);
		node.setGraph(this);
		return node;
	}

	@Override
	public boolean hasNode(INode node) {
		return this.mNodes.contains(node);
	}

	@Override
	public INode deleteNode(INode node) {
		if(!(this.mNodes.contains(node))) {
			return null;
		}
		this.mNodes.remove(node);
		return node;
	}

	@Override
	public int getNumberOfNodes() {
		return this.mNodes.size();
	}

	@Override
	public IEdge addEdge(IEdge edge) {
		if(this.hasEdge(edge)) {
			return null;
		}

		Node h = (Node)edge.getHead();					///Check Validity of the operation
		Node t = (Node)edge.getTail();
		if(!this.hasNode(h)) {
			return null;
		}
		if(!this.hasNode(t)) {
			return null;
		}
		
		this.mEdges.add(edge);
		edge.setGraph(this);
		h.addIncomingEdge(edge);
		t.addOutgoingEdge(edge);
		return edge;
	}

	@Override
	public IEdge deleteEdge(IEdge edge) {
		if(this.hasEdge(edge)) {
			this.mEdges.remove(edge);
			edge.setGraph(null);
			Node h = (Node)edge.getHead();
			Node t = (Node)edge.getTail();
			h.deleteIncomingEdge(edge);
			t.deleteOutgoingEdge(edge);
			return edge;
		}
		return null;
	}

	@Override
	public boolean hasEdge(IEdge edge) {
		if(this.mEdges.contains(edge)) {
			return true;
		}
		return false;
	}

	@Override
	public int getNumberOfEdges() {
		return this.mEdges.size();
	}

	public INode getNodeById(int id)
	{
		int i;
		for(i=0;i<mNodes.size();i++)
			if(this.mNodes.get(i).getId()==id)
				break;
		return this.mNodes.get(i);
	}
	@Override
	public List<INode> getNodeSet() {
		return this.mNodes;
	}

	@Override
	public List<IEdge> getEdgeSet() {
		return this.mEdges;
	}
}