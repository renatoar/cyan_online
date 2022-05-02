package meta.codegLibrary;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class FSMModelState {

    private ArrayList<FSMModelTransition> transitions;  // Transitions where this State is Origin

    private String label;
    private Point point;
    private Boolean initialState;
    private Boolean finalState;

    private FSMModelState() {
        transitions = new ArrayList<FSMModelTransition>();
        point = new Point();
    }

    public FSMModelState(int x, int y, String label, Boolean initialState, Boolean finalState) {
        this();
        this.label = label;
        this.setXY(x, y);
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public String getLabel() {
        return this.label;
    }

    public Point getPoint() {
        return point;
    }

    public int getX() {
        return this.point.x;
    }

    public void setX(int x) {
        this.point.x = x;
    }

    public int getY() {
        return this.point.y;
    }

    public void setY(int y) {
        this.point.y = y;
    }

    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public double distance(FSMModelState state) {
        return this.point.distance(state.getPoint());
    }

    public void addOrigin(FSMModelTransition transition) {
        this.transitions.add(transition);
    }

    public void addDestiny(FSMModelTransition transition) {
        this.transitions.add(transition);
    }

    public void removeOrigin(FSMModelTransition transition) {
        Iterator<FSMModelTransition> it = this.transitions.iterator();

        int i = 0;
        while (it.hasNext()) {
            FSMModelTransition e = it.next();

            if (e.getOrigin().getLabel() == transition.getOrigin().getLabel()) {
                this.transitions.remove(i);
                break;
            }
            ++i;
        }
    }

    public void removeDestiny(FSMModelTransition transition) {
        Iterator<FSMModelTransition> it = this.transitions.iterator();

        int i = 0;
        while (it.hasNext()) {
            FSMModelTransition e = it.next();

            if (e.getDestiny().getLabel() == transition.getDestiny().getLabel()) {
                this.transitions.remove(i);
                break;
            }
            ++i;
        }
    }

    boolean isOnState(int x, int y) {
    	return ((x >= point.getX() -25 && x <= point.getX() + 50) && (y >= point.getY() - 25 && y <= point.getY() + 50));
    }


    public ArrayList<FSMModelTransition> getTransitions() {
        return transitions;
    }

	public Boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(Boolean initialState) {
		this.initialState = initialState;
	}

	public Boolean isFinalState() {
		return finalState;
	}

	public void setFinalState(Boolean finalState) {
		this.finalState = finalState;
	}

}
