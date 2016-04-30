package stateDiagramSim;

import java.util.ArrayList;

public class StateDiagram {
	public ArrayList<String> states;
	public ArrayList<Transition> transitions;

	public StateDiagram() {
		states = new ArrayList<String>();
		transitions = new ArrayList<Transition>();
	}
}
