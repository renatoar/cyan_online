package meta.codegLibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import meta.Tuple3;

public class FSMModel {
	public static final char INF = '\u221e'; //'∞'; // Char to indicate that a value is infinity

	private File file;
	private BufferedReader in;
	private BufferedWriter out;

	private FSMData data;

	private ArrayList<FSMModelState> states; // states List
	private ArrayList<FSMModelTransition> transitions; // transitions List

	public FSMModel() {
		states = new ArrayList<FSMModelState>();
		transitions = new ArrayList<FSMModelTransition>();
	}

	public FSMModel(FSMData data) {
		this();
		this.data = data;

		initFromFSMData();
	}

	public FSMModel(String filename) {
		this();

		file = new File(filename);
		if (filename != "")
			initFromFile();
	}

	private void initFromFSMData() {

		for (Tuple3<String, Integer, Integer> state : data.getStateList())
			states.add(new FSMModelState(state.f2, state.f3, state.f1, false, false));

		for (String finalState : data.getFinalStateList())
			for (FSMModelState state : this.getStates())
				if (state.getLabel().equals(finalState))
					state.setFinalState(true);

		String initialState = data.getInitialState();
		for (FSMModelState state : this.getStates())
			if (state.getLabel().equals(initialState))
				state.setInitialState(true);


		for (Tuple3<String, String, String> transition : data.getTransitionList())
			transitions.add(new FSMModelTransition(getState(transition.f1), getState(transition.f2), transition.f3));

	}

	private void initFromFile() {
		try {

			data.clearFSM();

			this.in = new BufferedReader(new FileReader(file));

			String line;

			StringTokenizer tokenizer = null;
			while (in.ready()) {
				line = in.readLine();

				if (line.startsWith("states")) {
					line = line.replace("states = ", "");
					tokenizer = new StringTokenizer(line, ", ");

					StringTokenizer item;
					String v;
					int x, y;

					int tam = tokenizer.countTokens();
					for (int i=0; i<tam; i++) {
						item = new StringTokenizer(tokenizer.nextToken(), "|");

						if (item.countTokens() == 3) {
							v = item.nextToken();
							x = Integer.parseInt(item.nextToken());
							y = Integer.parseInt(item.nextToken());

							states.add(new FSMModelState(x, y, v, false, false));
							data.addState(v, x, y);
						}
					}

				} else if (line.startsWith("initialState")) {
					line = line.replace("initialState = ", "");
					for (FSMModelState state : getStates()) {
						if (state.getLabel().equals(line))
							state.setInitialState(true);
					}
					data.setInitialState(line);
 				} else if (line.startsWith("finalStates")) {
					line = line.replace("finalStates = ", "");
					tokenizer = new StringTokenizer(line, ", ");

					String v;

					int tam = tokenizer.countTokens();
					for (int i=0; i<tam; i++) {
						v = tokenizer.nextToken();
						for (FSMModelState state : getStates()) {
							if (state.getLabel().equals(v))
								state.setFinalState(true);
						}
						data.addFinalState(v);
					}

				} else if (line.startsWith("transitions")) {
					line = line.replace("transitions = ", "");
					tokenizer = new StringTokenizer(line, ", ");

					StringTokenizer item;
					String origin, destiny,label;

					int tam = tokenizer.countTokens();
					for (int i=0; i<tam; i++) {
						item = new StringTokenizer(tokenizer.nextToken(), "|");

						if (item.countTokens() == 3) {
							origin = item.nextToken();
							destiny = item.nextToken();
							label = item.nextToken();

							FSMModelTransition transition = new FSMModelTransition(getState(origin), getState(destiny), label);
							transitions.add(transition);

							getState(origin).addOrigin(transition);
							getState(destiny).addDestiny(transition);

							data.addTransition(origin, destiny, label);
						}
					}

				}
			}

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void setFile(String filename) {
		file = new File(filename);
	}

	public void saveToFile() {

		try {
			this.out = new BufferedWriter(new PrintWriter(new FileWriter(file)));

			String line = "";
			line = "states = ";
			for (Tuple3<String, Integer, Integer> state : data.getStateList()) {
				line += state.f1 + "|" + state.f2 + "|" + state.f3 + ", ";
			}
			line = line.substring(0, line.length()-2);
			out.write(line);
			out.newLine();

			line = "initialState = " + data.getInitialState();
			out.write(line);
			out.newLine();

			line = "finalStates = ";
			for (String state : data.getFinalStateList()) {
				line += state + ", ";
			}
			line = line.substring(0, line.length()-2);
			out.write(line);
			out.newLine();


			line = "transitions = ";
			for (Tuple3<String, String, String> transition : data.getTransitionList()) {
				String origin = transition.f1;
				String destiny = transition.f2;
				String action = transition.f3;

				line += origin + "|" + destiny + "|" + action + ", ";
			}
			line = line.substring(0, line.length()-2);
			out.write(line);
			out.newLine();

			out.flush();
			out.close();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	public FSMData getFSMData() {

		data.clearFSM();
		for (FSMModelState state : this.getStates()) {
			String v = state.getLabel();
			int x = state.getX();
			int y = state.getY();
			if (state.isInitialState()) {
				data.setInitialState(v);
			}
			if (state.isFinalState()) {
				data.addFinalState(v);
			}
			data.addState(v, x, y);
		}

		for (FSMModelState state : this.getStates()) {
			for (FSMModelTransition transition : state.getTransitions()) {
				String origin = transition.getOrigin().getLabel();
				String destiny = transition.getDestiny().getLabel();
				String action = transition.getAction();

				data.addTransition(origin, destiny, action);
			}
		}
		return data;
	}

	public ArrayList<FSMModelState> getStates() {
		return states;
	}

	public ArrayList<FSMModelTransition> getTransitions() {
		return transitions;
	}

	public int getNumTransitions() {
		return transitions.size();
	}

	public int getNumStates() {
		return states.size();
	}

	public int addState(int x, int y, String label, Boolean initialState, Boolean finalState) {
		if (label != "") {
			if (!this.hasState(label)) {
				states.add(new FSMModelState(x, y, label, initialState, finalState));
				return 0;
			}else {
				return 1;
			}
		} else
			return 2;
	}

	public int removeState(String label) {
		if (label != "") {
			if (this.hasState(label)) {

				FSMModelState state = getState(label);

				if (state != null) {

					FSMModelTransition transition = null;
					for (int i = 0; i < transitions.size(); ++i) {
						transition = transitions.get(i);

						if (transition.getOrigin().equals(state)) {
							removeTransition(state, transition.getDestiny());
							--i;
						} else if (transition.getDestiny().equals(state)) {
							removeTransition(transition.getOrigin(), state);
							--i;
						}
					}
					states.remove(state);
					return 0;
				}
			}
			return 1;
		} else
			return 2;
	}

	public boolean hasState(String label) {
		Iterator<FSMModelState> it = states.iterator();
		FSMModelState state = null;

		while (it.hasNext()) {
			state = it.next();

			if (state.getLabel().equals(label))
				return true;
		}
		return false;
	}


	public boolean hasState(FSMModelState origin, FSMModelState destiny) {
		Iterator<FSMModelTransition> it = transitions.iterator();

		while (it.hasNext()) {
			FSMModelTransition transition = it.next();

			if (transition.getOrigin().equals(origin) &&
					transition.getDestiny().equals(destiny)) {
				return true;
			}
		}
		return false;
	}

	public int addTransition(FSMModelState origin, FSMModelState destiny, String action) {
		if (!this.hasTransition(origin, destiny)) {
			FSMModelTransition transition = new FSMModelTransition(origin, destiny, action);
			transitions.add(transition);

			origin.addOrigin(transition);
			destiny.addDestiny(transition);

			return 0;
		} else {
			return 2;
		}
	}

	public boolean removeTransition(FSMModelState origin, FSMModelState destiny) {
		if (this.hasTransition(origin, destiny)) {

			int indexOfTransition = getIndexOfTransition(origin, destiny);
			FSMModelTransition transition = transitions.get(indexOfTransition);

			origin.removeOrigin(transition);
			destiny.removeDestiny(transition);

			transitions.remove(indexOfTransition);

			return true;
		} else {
			return false;
		}
	}

	private int getIndexOfTransition(FSMModelState origin, FSMModelState destiny) {
		int i = 0;
		Iterator<FSMModelTransition> it = transitions.iterator();

		while (it.hasNext()) {
			FSMModelTransition transition = it.next();

			if (transition.getOrigin().getLabel() == origin.getLabel() && transition.getDestiny().getLabel() == destiny.getLabel())
				return i;
			++i;
		}
		return -1;
	}

	public FSMModelState getState(String label) {
		Iterator<FSMModelState> it = states.iterator();

		while (it.hasNext()) {
			FSMModelState v = it.next();
			if (v.getLabel().equals(label))
				return v;
		}
		return null;
	}

	public boolean hasTransition(FSMModelState origin, FSMModelState destiny) {
		Iterator<FSMModelTransition> it = transitions.iterator();

		while (it.hasNext()) {
			FSMModelTransition transition = it.next();

			if (transition.getOrigin().equals(origin) &&
					transition.getDestiny().equals(destiny) &&
					transition.getAction() != "") {
				return true;
			}
		}
		return false;
	}

	public FSMModelTransition getTransition(FSMModelState origin, FSMModelState destiny) {
		Iterator<FSMModelTransition> it = transitions.iterator();

		while (it.hasNext()) {
			FSMModelTransition transition = it.next();

			if (transition.getOrigin().equals(origin) &&
					transition.getDestiny().equals(destiny) &&
					transition.getAction() != "") {
				return transition;
			}
		}
		return null;
	}

	public String getTransitionAction(FSMModelState origin, FSMModelState destiny) {
		if (this.hasTransition(origin, destiny)) {
			return transitions.get(getIndexOfTransition(origin, destiny)).getAction();
		} else {
			return "";
		}
	}

	public FSMModelState getStateByXY(int x, int y) {
		Iterator<FSMModelState> it = states.iterator();
		FSMModelState state = null;
		while (it.hasNext()) {
			state = it.next();

			if (state.isOnState(x, y))
				return state;
		}
		return null;
	}

	public void reload(String filename) {
		file = new File(filename);
		clearFSM();
		initFromFile();

	}

	private void clearFSM() {
		states.clear();
		transitions.clear();
	}

}