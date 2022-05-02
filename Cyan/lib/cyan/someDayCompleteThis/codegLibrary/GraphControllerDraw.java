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
import meta.codegLibrary.CodegGraphGUI.DrawPanelGUI;

public class GraphControllerDraw {
    private GraphModel graph;
    private CodegGraphGUI drawGraphGUI;

    private boolean readFirstVertice;
    private boolean readSecondVertice;

    private boolean readNewVertice;
    private boolean removeVertice;

    private boolean removeEdge;
	private byte[] previousCodegFileText;
	private String firstParameter;

    public GraphControllerDraw(byte[] previousCodegFileText, String firstParameter) {
    	this.previousCodegFileText = previousCodegFileText;
    	this.firstParameter = firstParameter;
        init();
    }

    private void init() {
        readFirstVertice = false;
        readSecondVertice = false;
        readNewVertice = false;
        removeVertice = false;


        //drawGraphGUI = new DrawGraphGUI(graph);
		drawGraphGUI = new CodegGraphGUI(new Frame(), previousCodegFileText, firstParameter);
        drawGraphGUI.addMouseMotionListenerToDrawPanel(new VerticeGUIMovment());
        drawGraphGUI.addMouseListenerForDrawPanel(new MouseListenerForDrawPanel());
        drawGraphGUI.addActionForDrawPanel(new ActionForDrawPanel());
        drawGraphGUI.addKeyListener(new KeyListenerForEvents());

        setGraph(drawGraphGUI.getGraph());

        drawGraphGUI.setVisible(true);
    }


    private GraphModelVertice firstVertice;
    private GraphModelVertice secondVertice;

    public class MouseListenerForDrawPanel implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
//            if (e.getButton() == MouseEvent.BUTTON3) {
//                Vertice vertice = graph.getVerticeByXY(e.getX(), e.getY());
//                if (vertice == null) {
//                    drawGraphGUI.showPopup(e.getX(), e.getY());
//                } else {
//                    drawGraphGUI.showPopup(e.getX(), e.getY(), vertice);
//                    tempVertice = vertice;
//                }
//            }

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (readFirstVertice) {

                    GraphModelVertice vertice = graph.getVerticeByXY(e.getX(), e.getY());
                    if (vertice != null) {
                        firstVertice = vertice;
                        readFirstVertice = false;
                        readSecondVertice = true;
                        drawGraphGUI.setStatus("Click in the second vertice | ESC to cancel");
                    }
                } else if (readSecondVertice) {

                    GraphModelVertice vertice = graph.getVerticeByXY(e.getX(), e.getY());
                    if (vertice != null) {
                        secondVertice = vertice;
                        readSecondVertice = false;

                        if (removeEdge) {
                        	removeEdge = false;
                        	if (!graph.hasEdge(firstVertice, secondVertice)) {
                                drawGraphGUI.setStatus("Error");
                                JOptionPane.showMessageDialog(drawGraphGUI, "You cannot an Edge in this position", "Error", JOptionPane.ERROR_MESSAGE);
                        	} else {
                            	graph.removeEdge(firstVertice, secondVertice);
                            	JOptionPane.showMessageDialog(drawGraphGUI, "Edge removed", "Information", JOptionPane.INFORMATION_MESSAGE);
                                drawGraphGUI.repaint();
                        	}
                            drawGraphGUI.setStatus("Ready");
                        } else if (!graph.hasEdge(firstVertice, secondVertice)) {
                            drawGraphGUI.setStatus("Enter Cost value | ESC to cancel");

                            String costString = JOptionPane.showInputDialog("Enter Cost value");
                            double cost;

                            if (costString != null) {

                                try {
                                    cost = Double.parseDouble(costString.trim());

                                    int result = graph.addEdge(firstVertice, secondVertice, cost);

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
                            JOptionPane.showMessageDialog(drawGraphGUI, "You cannot add an Edge in this position", "Error", JOptionPane.ERROR_MESSAGE);
                            drawGraphGUI.setStatus("Ready");
                        }

                    }
                } else if (removeVertice) {
                	removeVertice = false;
                    GraphModelVertice tempVertice = graph.getVerticeByXY(e.getX(), e.getY());
                    if (tempVertice != null) {
                    	graph.removeVertice(tempVertice.getLabel());
                        drawGraphGUI.repaint();
                    } else {
                    	JOptionPane.showMessageDialog(drawGraphGUI, "You cannot selected an Vertice", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    drawGraphGUI.setStatus("Ready");

                } else if (readNewVertice) {
                    readNewVertice = false;
                    String labelString = JOptionPane.showInputDialog("Enter New Vertice Label");

                    int label = Integer.parseInt(labelString);
                    for (int i = 0; i < graph.getNumVertices(); i++) {
                    	if (graph.hasVertice(i)) {
                    		return;
                    	}
                    }

                    drawGraphGUI.setStatus("Ready");
                    if (label > -1) {
                        try {

                            if (label >= 0) {
                                int result = graph.addVertice(e.getX(), e.getY(), label);

                                if (result == 0) {
                                    graph.getVertice(label).setXY(e.getX(), e.getY());

                                    drawGraphGUI.setStatus("Ready");
                                    drawGraphGUI.repaint();
                                    drawGraphGUI.revalidate();

                                } else {
                                    drawGraphGUI.setStatus("Error");
                                    JOptionPane.showMessageDialog(drawGraphGUI, "You cannot add an Vertice with this label", "Error", JOptionPane.ERROR_MESSAGE);
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


    public class VerticeGUIMovment implements MouseMotionListener {
        GraphModelVertice vertice;
        DrawPanelGUI panel;

        @Override
        public void mouseDragged(MouseEvent e) {
        	try {

	            panel = ((CodegGraphGUI.DrawPanelGUI) e.getComponent());
	            //vertice = vertices.get(0);

	            vertice = graph.getVerticeByXY(e.getX(), e.getY());

	            if (vertice != null) {
	                vertice.setX(e.getX());
	                vertice.setY(e.getY());
	                panel.repaint();
	            }

        	} catch (Exception ex) {
        		// Caso não tenha sido carregado o grafo
        	}

        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    public class ActionForDrawPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Add Vertice")) {
                resetAddNewEdge();
                readNewVertice = true;
                drawGraphGUI.setStatus("Click where you want create the New Vertice | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click where you want create the New Vertice");
            } else if (command.equals("Add Edge")) {
                resetAddNewVertice();
                readFirstVertice = true;
                drawGraphGUI.setStatus("Click in the first vertice | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click in the first vertice, then in the second to create de Edge");
            } else if (command.equals("Remove Edge")) {
                resetAddNewVertice();
                removeEdge = true;
                readFirstVertice = true;
                drawGraphGUI.setStatus("Click in the first vertice  | ESC to cancel");
                //JOptionPane.showMessageDialog(drawGraphGUI, "Click in the first vertice, then in the second to create de Edge");
            } else if (command.equals("Remove Vertice")) {
            	resetAddNewEdge();
                readNewVertice = true;
                removeVertice = true;
                drawGraphGUI.setStatus("Click in the vertice to remove | ESC to cancel");
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
        resetAddNewEdge();
        resetAddNewVertice();
        removeEdge = false;
    }
    public void resetAddNewVertice() {
        readNewVertice = false;
        drawGraphGUI.setStatus("Ready");
    }
    public void resetAddNewEdge() {
        readFirstVertice = false;
        readSecondVertice = false;
        drawGraphGUI.setStatus("Ready");
    }

    public DrawPanelGUI getPanel() {
        return drawGraphGUI.getPanel();
    }

	public GraphModel getGraph() {
		return graph;
	}

	public void setGraph(GraphModel graph) {
		this.graph = graph;
	}

	public byte[] getUserInput() {
		return drawGraphGUI.getUserInput();
	}

	public String getLabel() {
		return drawGraphGUI.getLabel();
	}
}
