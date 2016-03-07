package graph;

import graph.IEdge;
import graph.IGraph;
import graph.INode;
//import utilities.IdGenerator;

/**
 * @author ZZ4JWJ
 *
 */
public class Edge implements IEdge {

	private IGraph mGraph;		
	private INode mTail; 		//source
	private INode mHead; 		//target
	private int edgeId;
	/*private String trigger;
	private ArrayList<String> guard;
	private String action;*/
	private static int EDGEID = 0;
		
	//private String mId;
	
	public Edge(IGraph graph, INode tail, INode head) throws Exception {
		this.mTail = tail;
		this.mHead = head;
		setEdgeId(EDGEID++);
		if(graph != null) {
			graph.addEdge(this);
		}
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
	public INode getHead() {
		return this.mHead;
	}

	@Override
	public INode getTail() {
		return this.mTail;
	}

	public int getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(int edgeId) {
		this.edgeId = edgeId;
	}

	public String toString(){
		return Integer.toString(edgeId);
	}
}