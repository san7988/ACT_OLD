package graph;

import java.util.ArrayList;
import java.util.List;

//import utilities.IdGenerator;

public class Node implements INode {

	/*private String name,desc;
	private String[] input;
	private String[] clickable;*/
	private IGraph mGraph;													//Graph it belongs to
	private List<IEdge> mOutgoingEdgeList = new ArrayList<IEdge>();			//List of out edges
	private List<IEdge> mIncomingEdgeList = new ArrayList<IEdge>();			//List of in edges
	private int id;
	private static int ID=0;

	public Node(IGraph graph) {			//add Node to graph. Make a graph object
		this.setId(ID++);
		if(graph != null) {
			graph.addNode(this);		
			mGraph = graph;
		}
		else {
			graph = new Graph(this);
			//mGraph = graph;		//done by constructor
		}
	}

		@Override
	public List<INode> getChildList() {			//adjacent nodes to
		List<INode> list = new ArrayList<INode>();
		for(int i = 0; i < this.mOutgoingEdgeList.size(); i++) {
			list.add(this.mOutgoingEdgeList.get(i).getHead());
		}
		return list;
	}

	@Override
	public List<INode> getParentList() {		//adjacent nodes from
		List<INode> list = new ArrayList<INode>();
		for(int i = 0; i < this.mIncomingEdgeList.size(); i++) {
			list.add(this.mIncomingEdgeList.get(i).getTail());
		}
		return list;
	}

	@Override
	public IGraph getGraph() {
		return this.mGraph;
	}

	@Override
	public void setGraph(IGraph graph) {
		this.mGraph = graph;
		
	}

	@Override
	public boolean isIncomingEdge(IEdge edge) {	
		return this.mIncomingEdgeList.contains(edge);
	}

	@Override
	public boolean isOutgoingEdge(IEdge edge) {
		return this.mOutgoingEdgeList.contains(edge);
	}

	@Override
	public boolean isParent(INode node) {
		for(IEdge e : this.mIncomingEdgeList) {
			if(e.getTail().equals(node)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isChild(INode node) {
		for(IEdge e : this.mOutgoingEdgeList) {
			if(e.getHead().equals(node)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IEdge> getIncomingEdgeList() {
		return this.mIncomingEdgeList;
	}

	@Override
	public List<IEdge> getOutgoingEdgeList() {
		return this.mOutgoingEdgeList;
	}

	@Override
	public void addIncomingEdge(IEdge edge) {
		this.mIncomingEdgeList.add(edge);
	}

	@Override
	public void addOutgoingEdge(IEdge edge) {
		this.mOutgoingEdgeList.add(edge);
	}

	@Override
	public void deleteIncomingEdge(IEdge edge) {
		this.mIncomingEdgeList.remove(edge);
	}

	@Override
	public void deleteOutgoingEdge(IEdge edge) {
		this.mOutgoingEdgeList.remove(edge);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return Integer.toString(id);
	}
}
