package meta.codegLibrary;

import java.io.Serializable;
import java.util.ArrayList;
import meta.Tuple3;

/**
 * coloque esta classe dentro de CyanMetaobjectCodegFSM
 * @author josed
 *
 */
public class FSMData implements Serializable {

	private static final long serialVersionUID = 1L;

	public String file;

	public String initialState;
	public ArrayList<String> finalStateList;
	public ArrayList<Tuple3<String, Integer, Integer>> stateList;

	public ArrayList<Tuple3<String, String, String>> transList;

	public ArrayList<String> methodList;

	public FSMData() {
		initialState = "";
		finalStateList = new ArrayList<>();
		stateList = new ArrayList<>();
		transList = new ArrayList<>();
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getInitialState() {
		return initialState;
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public ArrayList<String> getFinalStateList() {
		if (finalStateList == null)
			finalStateList = new ArrayList<>();

		return finalStateList;
	}

	public void addFinalState(String state) {
		if (finalStateList == null)
			finalStateList = new ArrayList<>();

		for (int i=0; i<finalStateList.size(); i++) {
			if (finalStateList.get(i).equals(state)) {
				return;
			}
		}
		finalStateList.add(state);
	}

	public boolean removeFinalState(String state) {
		if (finalStateList == null)
			finalStateList = new ArrayList<>();

		for (int i=0; i<finalStateList.size(); i++) {
			if (finalStateList.get(i).equals(state)) {
				finalStateList.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Tuple3<String, Integer, Integer>> getStateList() {
		if (stateList == null)
			stateList = new ArrayList<>();

		return stateList;
	}

	public void addState(String state, Integer x, Integer y) {
		if (stateList == null)
			stateList = new ArrayList<>();

		for (int i=0; i<stateList.size(); i++) {
			if (stateList.get(i).f1.equals(state)) {
				return;
			}
		}
		stateList.add(new Tuple3<String, Integer, Integer>(state, x, y));
	}

	public boolean removeState(String state) {
		if (stateList == null)
			stateList = new ArrayList<>();

		for (int i=0; i<stateList.size(); i++) {
			if (stateList.get(i).f1.equals(state)) {
				stateList.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Tuple3<String, String, String>> getTransitionList() {
		if (transList == null)
			transList = new ArrayList<>();

		return transList;
	}

	public void addTransition(String origin, String destiny, String label) {
		if (transList == null)
			transList = new ArrayList<>();

		Tuple3<String, String, String> item;
		for (int i=0; i<transList.size(); i++) {
			item = transList.get(i);
			if (item.f1.equals(origin) && item.f2.equals(destiny) && item.f3.equals(label)) {
				return;
			}
		}
		transList.add(new Tuple3<String, String, String>(origin, destiny, label));
	}

	public boolean removeTransition(String origin, String destiny, String label) {
		if (transList == null)
			transList = new ArrayList<>();

		Tuple3<String, String, String> item;
		for (int i=0; i<transList.size(); i++) {
			item = transList.get(i);
			if (item.f1.equals(origin) && item.f2.equals(destiny) && item.f3.equals(label)) {
				transList.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getMethodList() {
		if (methodList == null)
			methodList = new ArrayList<>();

		return methodList;
	}

	public void addMethod(String method) {
		if (methodList == null)
			methodList = new ArrayList<>();

		methodList.add(method);
	}

	public boolean removeMethod(String method) {
		if (methodList == null)
			methodList = new ArrayList<>();

		for (int i=0; i<methodList.size(); i++) {
			if (methodList.get(i).equals(method)) {
				methodList.remove(i);
				return true;
			}
		}
		return false;
	}

	public StringBuffer getStrFSMData() {
		String data = "";

		data = "[. initialState = \"" + getInitialState() + "\",\n";

		data += "finalStates = [ ";
		for (String state : this.getFinalStateList()) {
				data += "\"" + state + "\", ";
		}
		data = data.substring(0, data.length()-2);
		data += " ],\n";

		data += "states = [ ";
		for (Tuple3<String, Integer, Integer> state : this.getStateList()) {
			data += "\"" + state.f1 + "\", ";
		}
		data = data.substring(0, data.length()-2);
		data += " ],\n";


		data += "transitions = [ ";
		for (Tuple3<String, String, String> transition : this.getTransitionList()) {
			String origin = transition.f1;
			String destiny = transition.f2;
			String action = transition.f3;

			data += "[. \"" + origin + "\", \"" + destiny + "\", \"" + action + "\" .], ";
		}
		data = data.substring(0, data.length()-2);
		data += " ]\n";

		data += ".]";

		return new StringBuffer(data);
	}

	public void clearMethods() {
		if (methodList != null)
			methodList.clear();
	}

	public void clearFSM() {
		initialState = "";
		if (finalStateList != null)
			finalStateList.clear();
		if (stateList != null)
			stateList.clear();
		if (transList != null)
			transList.clear();
	}

}
