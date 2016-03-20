package graph;

import java.util.List;

public class StateChart extends Graph{
	public StateChart(State state) {
		super(state);
	}
	@Override
	public INode getRoot() {
		return this.mRoot;
	}
	
	@Override
	public List<INode> getNodeSet() {
		return this.mNodes;
	}

	@Override
	public List<IEdge> getEdgeSet() {
		return this.mEdges;
	}
	
	public INode addState(INode state) {
		return super.addNode(state);
	}

	public INode deleteState(INode state) {
		return super.deleteNode(state);
	}

	public IEdge addTransition(IEdge transition) {
		return super.addEdge(transition);
	}

	public IEdge deleteTransition(IEdge transition) {
		return super.deleteEdge(transition);
	}
	
	public boolean hasState(INode state) {
		return super.hasNode(state);
	}

	public boolean hasTransition(IEdge transition) {
		return super.hasEdge(transition);
	}

	public int getNumberOfStates() {
		return super.getNumberOfNodes();
	}
	
	public int getNumberOfTransitions() {
		return super.getNumberOfEdges();
	}

	public INode getStateById(int id){
		return super.getNodeById(id);
	}
}
