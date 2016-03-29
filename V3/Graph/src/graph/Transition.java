package graph;

public class Transition extends Edge {
	private String trigger;
	private Guard guard;
	private String action;
	
	public Transition(INode stateFrom, INode stateTo) throws Exception {
		super(stateFrom, stateTo);
	}
	/*public Transition(INode stateFrom, INode stateTo, String trig) throws Exception {
		super(stateFrom, stateTo);
		this.trigger=trig;
	}*/
	
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	public Guard getGuard() {
		return guard;
	}
	public void setGuard(Guard guard) {
		this.guard = guard;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	//parent properties accessors
	public IGraph getStateChart() {
		return this.mGraph;
	}
	public void setStateChart(IGraph graph) {
		this.mGraph = graph;
	}
	public INode getStateFrom() {
		return this.mTail;
	}	
	public void setStateFrom(INode state) {
		mTail = state;
	}
	public INode getStateTo() {
		return this.mHead;
	}
	public void setStateTo(INode state) {
		mHead = state;
	}
	public int getTransitionId() {
		return edgeId;
	}
	public void setTransitionId(int edgeId) {
		this.edgeId = edgeId;
	}
}