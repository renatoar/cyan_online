package meta.codegLibrary;

public class FSMModelTransition {

    private FSMModelState origin;
    private FSMModelState destiny;
    private String action;

    public FSMModelTransition(FSMModelState origin, FSMModelState destiny, String action) {
        this.origin = origin;
        this.destiny = destiny;
        this.action = action;
    }

    public FSMModelState getOrigin() {
        return origin;
    }

    public FSMModelState getDestiny() {
        return destiny;
    }

    public String getAction() {
        return action;
    }

}
