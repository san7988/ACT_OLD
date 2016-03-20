package graph;


public class myGraph{
	
	public static void main(String[] args)
	{
		//NEXT- get nodes and edges from the text file into graph
<<<<<<< HEAD
		StateChart stateChart = null;
		State rootState = new State(stateChart);
		rootState.setName("0");
		stateChart = (StateChart)rootState.getStateChart();	//((State)rootState).
		//stateChart = new Graph(root);
		//Make a graph
		for(int i=0;i<10;i++)
			new State(stateChart);	//addNode(graph);	//TODO
		
		addTransition(stateChart,0,2);
		addTransition(stateChart,0,3);
		addTransition(stateChart,1,4);		//disconnected
		addTransition(stateChart,3,5);
		addTransition(stateChart,5,2);
=======
		IGraph graph = null;
		INode root = new Node(graph);
		graph = root.getGraph();
		//graph = new Graph(root);
		//Make a graph
		for(int i=0;i<10;i++)
			new Node(graph);	//addNode(graph);	//TODO	
		
		addEdge(graph,0,2);
		addEdge(graph,0,3);
		addEdge(graph,1,4);		//disconnected
		addEdge(graph,3,5);
		addEdge(graph,5,2);
>>>>>>> 9f240fb4e33939fb8a58bcf5298284eed55239e0
		/*
		System.out.println("Nodes in the graph : " + graph.getNodeSet().toString());
		System.out.println("Edges in the graph are as follows: ");
		for(int i=0;i<graph.getNumberOfEdges();i++)
			System.out.println("Edge Id "+ graph.getEdgeSet().get(i).getEdgeId()+" : "+ graph.getEdgeSet().get(i).getTail().getId()+ " "+graph.getEdgeSet().get(i).getHead().getId());
		*/
		DFSRecursionTesting test = new DFSRecursionTesting();
<<<<<<< HEAD
		test.dfs(stateChart, rootState);
	}
	
	private static void addTransition(IGraph graph, int src, int dest)
=======
		test.dfs(graph, root);		
	}
	
	private static void addEdge(IGraph graph, int src, int dest)
>>>>>>> 9f240fb4e33939fb8a58bcf5298284eed55239e0
	{
		INode tail=graph.getNodeById(src);
		INode head=graph.getNodeById(dest);
		try {
			new Edge(graph,tail,head);
		} catch (Exception e) {
			System.out.println("Something went wrong while adding edge to the graph");
		}
	}

/*public class GraphtoStringVisitor {
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
	*/
}
