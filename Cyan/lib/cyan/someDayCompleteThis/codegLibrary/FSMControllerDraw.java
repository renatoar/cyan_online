package meta.codegLibrary;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import meta.codegLibrary.CodegFSMGUI.DrawPanelGUI;

public class FSMControllerDraw {
    private FSMModel fsm;
    private CodegFSMGUI drawGraphGUI;

    private boolean readFirstState;
    private boolean readSecondState;

    private boolean readNewState;
    private boolean removeState;
    private boolean initialState;
    private boolean finalState;

    private boolean removeTransition;

    private FSMData data;
	private String firstParameter;

    public FSMControllerDraw(FSMData data, String firstParameter) {
    	this.data = data;
    	this.firstParameter = firstParameter;
        init();
	}

	private void init() {
        readFirstState = false;
        readSecondState = false;
        readNewState = false;
        removeState = false;

        //drawGraphGUI = new DrawGraphGUI(fsm);
    	drawGraphGUI = new CodegFSMGUI(new Frame(), data, firstParameter);
        fsm = drawGraphGUI.getFSM();

        drawGraphGUI.addMouseMotionListenerToDrawPanel(new StateGUIMovment());
        drawGraphGUI.addMouseListenerForDrawPanel(new MouseListenerForDrawPanel());
        drawGraphGUI.addActionForDrawPanel(new ActionForDrawPanel());
        drawGraphGUI.addKeyListener(new KeyListenerForEvents());

        drawGraphGUI.setVisible(true);

        data = drawGraphGUI.getFSM().getFSMData();

    }

	public class StateGUIMovment implements MouseMotionListener {
        FSMModelState state;
        DrawPanelGUI panel;

        @Override
        public void mouseDragged(MouseEvent e) {
        	try {

	            panel = ((CodegFSMGUI.DrawPanelGUI) e.getComponent());
	            //state = vertices.get(0);

	            state = fsm.getStateByXY(e.getX(), e.getY());

	            if (state != null) {
	                state.setX(e.getX());
	                state.setY(e.getY());
	                panel.repaint();
	            }

        	} catch (Exception ex) {
        		// Caso não tenha sido carregado o grafo
        	}

        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    private FSMModelState firstState;
    private FSMModelState secondState;

    public class MouseListenerForDrawPanel implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
//            if (e.getButton() == MouseEvent.BUTTON3) {
//                State state = fsm.getStateByXY(e.getX(), e.getY());
//                if (state == null) {
//                    drawGraphGUI.showPopup(e.getX(), e.getY());
//                } else {
//                    drawGraphGUI.showPopup(e.getX(), e.getY(), state);
//                    tempState = state;
//                }
//            }

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (readFirstState) {

                    FSMModelState state = fsm.getStateByXY(e.getX(), e.getY());
                    readFirstState = false;
                    if (state != null) {
                    	if (initialState || finalState) {

                    		if (initialState) {
                    			for (FSMModelState states : fsm.getStates()) {
                    				states.setInitialState(false);
                    			}
                    			state.setInitialState(!state.isInitialState());
                    		}

                    		if (finalState)
                    			state.setFinalState(!state.isFinalState());

                    		drawGraphGUI.setStatus("Ready");
                            drawGraphGUI.repaint();
                            drawGraphGUI.revalidate();
                    	} else {
	                        firstState = state;
	                        readSecondState = true;
	                        drawGraphGUI.setStatus("Click in the second state | ESC to cancel");
                    	}
                    }
                } else if (readSecondState) {

                    FSMModelState state = fsm.getStateByXY(e.getX(), e.getY());
                    if (state != null) {
                        secondState = state;
                        readSecondState = false;

                        if (removeTransition) {
                        	removeTransition = false;
                        	if (!fsm.hasTransition(firstState, secondState)) {
                                drawGraphGUI.setStatus("Error");
                                JOptionPane.showMessageDialog(drawGraphGUI, "You cannot an Transition in this position", "Error", JOptionPane.ERROR_MESSAGE);
                        	} else {
                            	fsm.removeTransition(firstState, secondState);
                            	JOptionPane.showMessageDialog(drawGraphGUI, "Transition removed", "Information", JOptionPane.INFORMATION_MESSAGE);
                                drawGraphGUI.repaint();
                        	}
                            drawGraphGUI.setStatus("Ready");
                        } else if (!fsm.hasTransition(firstState, secondState)) {
                            drawGraphGUI.setStatus("Enter Action | ESC to cancel");


                            String actionString;

                            if (data.getMethodList().size() > 0) {
                            	String[] methods = data.getMethodList().toArray(new String[data.getMethodList().size()]);
	                            CodegFSMMethodsList dialog = new CodegFSMMethodsList(new javax.swing.JFrame(), true, methods);
	                            dialog.setVisible(true);
	                            actionString = dialog.getMethod();
                            } else {
	                            actionString = JOptionPane.showInputDialog("Enter Action");
                            }

                            String action;

                            if (actionString != null) {

                                try {
                                    action = actionString.trim();

                                    int result = fsm.addTransition(firstState, secondState, action);

                                    if (result == 0) {
                                        drawGraphGUI.setStatus("Ready");
                                        drawGraphGUI.repaint();
                                    } else if (result == 1) {
                                        drawGraphGUI.setStatus("Error");
                                        JOptionPane.showMessageDialog(drawGraphGUI, "Cust must be a positive value", "Error", JOptionPane.ERROR_MESSAGE);
                                        drawGraphGUI.setStatus("Ready");
                                    } else {

                                    }
                                } catch (NumberFormatException ex) {
                                    drawGraphGUI.setStatus("Error");
                                    JOptionPane.showMessageDialog(drawGraphGUI, "You entered a invalid value", "Error", JOptionPane.ERROR_MESSAGE);
                                    drawGraphGUI.setStatus("Ready");
                                }

                            }
                        } else {
                            drawGraphGUI.setStatus("Error");
                            JOptionPane.showMessageDialog(drawGraphGUI, "You cannot add an Transition in this position", "Error", JOptionPane.ERROR_MESSAGE);
                            drawGraphGUI.setStatus("Ready");
                        }

                    }
                } else if (removeState) {
                	removeState = false;
                    FSMModelState tempState = fsm.getStateByXY(e.getX(), e.getY());
                    if (tempState != null) {
                    	fsm.removeState(tempState.getLabel());
                        drawGraphGUI.repaint();
                    } else {
                    	JOptionPane.showMessageDialog(drawGraphGUI, "You cannot selected an State", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    drawGraphGUI.setStatus("Ready");

                } else if (readNewState) {
                    readNewState = false;

                    String labelString = JOptionPane.showInputDialog("Enter New State Label");

                    drawGraphGUI.setStatus("Ready");
                    if (labelString != "") {
                        try {
                            String label = labelString;

                            if (label != "") {
                                int result = fsm.addState(e.getX(), e.getY(), label, initialState, finalState);

                                if (result == 0) {
                                    fsm.getState(label).setXY(e.getX(), e.getY());

                                    drawGraphGUI.setStatus("Ready");
                                    drawGraphGUI.repaint();
                                    drawGraphGUI.revalidate();

                                } else {
                                    drawGraphGUI.setStatus("Error");
                                    JOptionPane.showMessageDialog(drawGraphGUI, "You cannot add an State with this label", "Error", JOptionPane.ERROR_MESSAGE);
                                    drawGraphGUI.setStatus("Ready");
                                }
                            } else {
                                drawGraphGUI.setStatus("Error");
                                JOptionPane.showMessageDialog(drawGraphGUI, "Label must be a positive value", "Error", JOptionPane.ERROR_MESSAGE);
                                drawGraphGUI.setStatus("Ready");
                            }
                        } catch (NumberFormatException ex) {
                            drawGraphGUI.setStatus("Error");
                            JOptionPane.showMessageDialog(drawGraphGUI, "You entered a invalid value", "Error", JOptionPane.ERROR_MESSAGE);
                            drawGraphGUI.setStatus("Ready");
                        }
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

    }

    public class ActionForDrawPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Add State")) {
                resetAddNewTransition();
                readNewState = true;
                initialState = false;
                finalState = false;
                drawGraphGUI.setStatus("Click where you want create the New State | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click where you want create the New State");
            } else if (command.equals("Mark / Unmark Initial")) {
                resetAddNewState();
                resetAddNewTransition();
                readFirstState = true;
                initialState = true;
                finalState = false;
                drawGraphGUI.setStatus("Click in the State for mark / unmark as Initial State | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click where you want create the New State");
            } else if (command.equals("Mark / Unmark Final")) {
                resetAddNewState();
                resetAddNewTransition();
                readFirstState = true;
                initialState = false;
                finalState = true;
                drawGraphGUI.setStatus("Click in the State for mark / unmark as Final State | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click where you want create the New State");
            } else if (command.equals("Add Transition")) {
                resetAddNewState();
                readFirstState = true;
                drawGraphGUI.setStatus("Click in the first state | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click in the first state, then in the second to create de Transition");
            } else if (command.equals("Remove Transition")) {
                resetAddNewState();
                removeTransition = true;
                readFirstState = true;
                drawGraphGUI.setStatus("Click in the first state  | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click in the first state, then in the second to create de Transition");
            } else if (command.equals("Remove State")) {
            	resetAddNewTransition();
                readNewState = true;
                removeState = true;
                drawGraphGUI.setStatus("Click in the state to remove | ESC to cancel");
            }
        }

    }

    public class KeyListenerForEvents implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                resetActions();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}

    }

    public void resetActions() {
        resetAddNewTransition();
        resetAddNewState();
        removeTransition = false;
    }
    public void resetAddNewState() {
        readNewState = false;
        drawGraphGUI.setStatus("Ready");
    }
    public void resetAddNewTransition() {
        readFirstState = false;
        readSecondState = false;
        drawGraphGUI.setStatus("Ready");
    }

    public DrawPanelGUI getPanel() {
        return drawGraphGUI.getPanel();
    }

	public FSMData getFSMData() {
		return data;
	}

	public String getLabel() {
		return drawGraphGUI.getLabel();
	}
}


class CodegFSMMethodsList extends javax.swing.JDialog {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private String[] methodList;
    private String method;

	public CodegFSMMethodsList(java.awt.Frame parent, boolean modal, String[] methodList) {
        super(parent, modal);
        this.methodList = methodList;
        this.method = "";
        initComponents();
    }

    private void initComponents() {

        jComboMethods = new javax.swing.JComboBox<>();
        btOk = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();

        setTitle("Method List");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jComboMethods.setEditable(true);
        jComboMethods.setModel(new javax.swing.DefaultComboBoxModel<>(methodList));

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        jLabelTitle.setText("Select an existing method or type new method:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboMethods, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btOk))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jComboMethods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOk)
                .addContainerGap())
        );

        pack();
    }

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
    	this.method = jComboMethods.getSelectedItem().toString();
    	this.dispose();
    }

    public String getMethod() {
    	return this.method;
    }

    private javax.swing.JButton btOk;
    private javax.swing.JComboBox<String> jComboMethods;
    private javax.swing.JLabel jLabelTitle;

}