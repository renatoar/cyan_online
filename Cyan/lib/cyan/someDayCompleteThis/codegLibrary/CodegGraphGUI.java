package meta.codegLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import meta.codegLibrary.GraphControllerDraw.ActionForDrawPanel;
import meta.codegLibrary.GraphControllerDraw.MouseListenerForDrawPanel;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegGraphGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegGraphGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
		super(parent, true);
		userInput = previousUserInput;
		String[] previous = new String(userInput).split("\n");
		label = previousLabel;
		initComponents();
		setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
				((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));

		for (Component c : this.getComponents()) {
			c.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					formClicked();
				}

				@Override
				public void mouseExited(java.awt.event.MouseEvent evt) {
					formExited(false);
				}

				@Override
				public void mousePressed(java.awt.event.MouseEvent evt) {
					formClicked();
				}
			});
		}
		txtLabel.setText(label);
		txtFile.setText(previous[0]);
		if (previous.length > 1) {
			loadGraph(previous[1]);
		}
	}

	private void initComponents() {

		lblLabel = new JLabel();
		txtLabel = new JTextField();
		btOk = new JButton();
		btCancel = new JButton();
		lblFile = new JLabel();
		txtFile = new JTextField();
		btSearchFile = new JButton();
		jInternalFrameGraph = new JInternalFrame();
		statusJLabel = new JLabel();
		jMenuBar = new JMenuBar();
		jMenuGraph = new JMenu();
		jMenuDirected = new JCheckBoxMenuItem();
		jMenuReload = new JMenuItem();
		jMenuClone = new JMenuItem();
		jMenuVertice = new JMenu();
		jMenuVerticeAdd = new JMenuItem();
		jMenuVerticeRemove = new JMenuItem();
		jMenuEdge = new JMenu();
		jMenuEdgeAdd = new JMenuItem();
		jMenuEdgeRemove = new JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		setResizable(false);
		setAlwaysOnTop(true);
		setModal(true);
		setType(java.awt.Window.Type.POPUP);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				formClicked();
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				formExited(true);
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent evt) {
				formClicked();
			}
		});

		lblLabel.setText("Label:");

		btOk.setText("Ok");
		btOk.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btOkActionPerformed(evt);
			}
		});

		btCancel.setText("Cancel");
		btCancel.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCancelActionPerformed(evt);
			}
		});

		lblFile.setText("File:");

		txtFile.setEditable(false);

		btSearchFile.setText("Search");
		btSearchFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchFileActionPerformed(evt);
			}
		});

		jInternalFrameGraph.setTitle("Graph");
		jInternalFrameGraph.setVisible(true);

		statusJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		statusJLabel.setText("Ready");
		statusJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

		drawPanelGUI = new DrawPanelGUI();
		javax.swing.GroupLayout drawPanelGUILayout = new javax.swing.GroupLayout(drawPanelGUI);
		drawPanelGUI.setLayout(drawPanelGUILayout);
		drawPanelGUILayout.setHorizontalGroup(drawPanelGUILayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		drawPanelGUILayout.setVerticalGroup(drawPanelGUILayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 363, Short.MAX_VALUE));

		jMenuGraph.setText("Graph");

		jMenuDirected.setSelected(true);
		jMenuDirected.setText("Directed");

		jMenuDirected.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuDirectedActionPerformed(evt);
			}
		});
		jMenuGraph.add(jMenuDirected);

		jMenuReload.setText("Reload");
		jMenuReload.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuReloadActionPerformed(evt);
			}
		});
		jMenuGraph.add(jMenuReload);

		jMenuClone.setText("Clone");
		jMenuClone.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuCloneActionPerformed(evt);
			}
		});
		jMenuGraph.add(jMenuClone);

		jMenuBar.add(jMenuGraph);

		jMenuVertice.setText("Vertice");

		jMenuVerticeAdd.setText("Add Vertice");
		jMenuVertice.add(jMenuVerticeAdd);

		jMenuVerticeRemove.setText("Remove Vertice");
		jMenuVertice.add(jMenuVerticeRemove);

		jMenuBar.add(jMenuVertice);

		jMenuEdge.setText("Edge");

		jMenuEdgeAdd.setText("Add Edge");
		jMenuEdge.add(jMenuEdgeAdd);

		jMenuEdgeRemove.setText("Remove Edge");
		jMenuEdge.add(jMenuEdgeRemove);

		jMenuBar.add(jMenuEdge);

		jInternalFrameGraph.setJMenuBar(jMenuBar);

		javax.swing.GroupLayout jInternalFrameGraphLayout = new javax.swing.GroupLayout(
				jInternalFrameGraph.getContentPane());
		jInternalFrameGraph.getContentPane().setLayout(jInternalFrameGraphLayout);
		jInternalFrameGraphLayout.setHorizontalGroup(
				jInternalFrameGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jInternalFrameGraphLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(statusJLabel))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jInternalFrameGraphLayout.createSequentialGroup().addContainerGap()
										.addComponent(drawPanelGUI, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		jInternalFrameGraphLayout.setVerticalGroup(
				jInternalFrameGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jInternalFrameGraphLayout.createSequentialGroup().addContainerGap()
								.addComponent(drawPanelGUI, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(statusJLabel)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jInternalFrameGraph)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btOk)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btCancel))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(txtFile)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btSearchFile))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblLabel)
												.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFile))
										.addGap(0, 518, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblFile)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btSearchFile))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jInternalFrameGraph)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btCancel).addComponent(btOk))
						.addContainerGap()));

		pack();
	}// </editor-fold>

	protected void jMenuReloadActionPerformed(ActionEvent evt) {
		String filename = txtFile.getText();
		graph = new GraphModel(filename);
		graph.setDirected(jMenuDirected.isSelected());
		repaint();
		revalidate();
	}

	protected void jMenuCloneActionPerformed(ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Graph File");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			String filename = chooser.getSelectedFile().toString();
			graph = new GraphModel(filename);
			graph.setDirected(jMenuDirected.isSelected());
			repaint();
			revalidate();
		}
	}

	private void jMenuDirectedActionPerformed(ActionEvent evt) {
		graph.setDirected(jMenuDirected.isSelected());
		repaint();
		revalidate();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
		graph.setFile(txtFile.getText());
		graph.saveToFile();
		this.dispose();
	}

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void formClicked() {
		formClick = true;
	}

	private void formExited(Boolean frm) {
		if (!formClick && mouseCount < -3) {
			this.dispose();
		} else {
			if (frm) {
				mouseCount++;
			} else {
				mouseCount--;
			}
		}
	}

	private void btSearchFileActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Graph File");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setSelectedFile(new File(txtFile.getText()));
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtFile.setText(chooser.getSelectedFile().toString());
		}
	}

	private void loadGraph(String directed) {
		String filename = txtFile.getText();

		graph = new GraphModel(filename);
		Boolean graphDirected = directed.equals("true");
		graph.setDirected(graphDirected);
		drawPanelGUI.addMouseMotionListener(new VerticeGUIMovment());

		repaint();
		revalidate();

	}

	public void setStatus(final String text) {
		statusJLabel.setText(text);
	}

	public void addMouseMotionListenerToDrawPanel(GraphControllerDraw.VerticeGUIMovment verticeGUIMovment) {
		drawPanelGUI.addMouseMotionListener(verticeGUIMovment);
	}

	public void addMouseListenerForDrawPanel(MouseListenerForDrawPanel mouseListenerForDrawPanel) {
		drawPanelGUI.addMouseListener(mouseListenerForDrawPanel);
	}

	public void addActionForDrawPanel(ActionForDrawPanel actionForDrawPanel) {
		jMenuEdgeAdd.addActionListener(actionForDrawPanel);
		jMenuEdgeRemove.addActionListener(actionForDrawPanel);
		jMenuVerticeAdd.addActionListener(actionForDrawPanel);
		jMenuVerticeRemove.addActionListener(actionForDrawPanel);
		// addNewVerticeJMenuItem.addActionListener(actionForDrawPanel);
		// addNewEdgeJMenuItem.addActionListener(actionForDrawPanel);
		// removeVerticeJMenuItem.addActionListener(actionForDrawPanel);
	}

	public DrawPanelGUI getPanel() {
		return this.drawPanelGUI;
	}

	public class DrawPanelGUI extends JPanel {

		private static final long serialVersionUID = 1L;

		public DrawPanelGUI() {
			super(new BorderLayout());
		}

		@Override
		public String toString() {
			return super.toString();
		}

		@Override
		public synchronized void addKeyListener(KeyListener l) {
			super.addKeyListener(l);
			drawPanelGUI.addKeyListener(l);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			if (graph != null) {
				Iterator<GraphModelEdge> itE = graph.getEdges().iterator();

				// ArrayList<Edge> control = new ArrayList<Edge>();

				GraphModelEdge e = null;
				while (itE.hasNext()) {
					e = itE.next();

					// if (!graph.isDirected()) {
					// control.add(e);
					// }

					int xOrigin = e.getOrigin().getX();
					int yOrigin = e.getOrigin().getY();
					int xDestiny = e.getDestiny().getX();
					int yDestiny = e.getDestiny().getY();

					GraphModelVertice originVertice = e.getOrigin();
					GraphModelVertice destinyVertice = e.getDestiny();

					if (originVertice.equals(destinyVertice)) {
						g.drawArc(originVertice.getX(), originVertice.getY(), 40, 40, 0, 360);

						g.setColor(Color.red);
						g.drawString(new Double(e.getCost()).toString(), (destinyVertice.getX() + 40),
								(destinyVertice.getY() + 40));
						g.setColor(Color.black);

						Point p1 = new Point();
						Point p2 = new Point();
						Point p3 = new Point();

						p1.x = xDestiny + 25;
						p1.y = yDestiny - 3;

						double ang;

						ang = 40;

						p2.x = p1.x + (int) (10 * Math.cos(ang + (150) * Math.PI / 180));
						p2.y = p1.y - (int) (10 * Math.sin(ang + (150) * Math.PI / 180));

						p3.x = p2.x + (int) (10 * Math.cos(ang + (270) * Math.PI / 180));
						p3.y = p2.y - (int) (10 * Math.sin(ang + (270) * Math.PI / 180));

						if (graph.isDirected()) {
							g.fillPolygon(new int[] { p1.x, p2.x, p3.x }, new int[] { p1.y, p2.y, p3.y }, 3);
						}

					} else {
						if (true /*
									 * graph.isDirected() || (!graph.isDirected() && !controlHasEdge(control,
									 * e.getDestiny(), e.getOrigin()))
									 */) {
							double sina = (originVertice.getY() - destinyVertice.getY())
									/ originVertice.distance(destinyVertice);
							double cosa = (destinyVertice.getX() - originVertice.getX())
									/ originVertice.distance(destinyVertice);

							double a = Math.asin(sina); // angle
							double b = Math.acos(cosa); // angle

							int factorx = (int) (cosa * 25);
							int factory = (int) (sina * 25);

							xOrigin += factorx;
							xDestiny -= factorx;

							yOrigin -= factory;
							yDestiny += factory;

							g.drawLine(xOrigin, yOrigin, xDestiny, yDestiny);
							// g.fillOval(xDestiny-5, yDestiny-5, 10, 10);

							Point p1 = new Point();
							Point p2 = new Point();
							Point p3 = new Point();

							p1.x = xDestiny;
							p1.y = yDestiny;

							double ang;

							if ((b * 180 / Math.PI) >= 0 && (b * 180 / Math.PI) <= 180 && (a * 180 / Math.PI) >= 0) {
								ang = b;
							} else if ((a * 180 / Math.PI) < 0 && (b * 180 / Math.PI) >= 90) {
								ang = (b * 180 / Math.PI - 2 * a * 180 / Math.PI) * Math.PI / 180;
							} else {
								ang = -b;
							}

							p2.x = p1.x + (int) (10 * Math.cos(ang + (150) * Math.PI / 180));
							p2.y = p1.y - (int) (10 * Math.sin(ang + (150) * Math.PI / 180));

							p3.x = p2.x + (int) (10 * Math.cos(ang + (270) * Math.PI / 180));
							p3.y = p2.y - (int) (10 * Math.sin(ang + (270) * Math.PI / 180));

							if (graph.isDirected()) {
								g.fillPolygon(new int[] { p1.x, p2.x, p3.x }, new int[] { p1.y, p2.y, p3.y }, 3);
							}

							g.setColor(Color.red);
							g.drawString(new Double(e.getCost()).toString(), (int) (p3.x - 20 * Math.cos(ang)),
									(int) (p3.y + 20 * Math.sin(ang)));

							g.setColor(Color.black);
						}
					}

				}

				Iterator<GraphModelVertice> itV = graph.getVertices().iterator();

				GraphModelVertice v = null;
				while (itV.hasNext()) {
					v = itV.next();

					g.setColor(Color.white);
					g.fillOval(v.getX() - 25, v.getY() - 25, 50, 50);

					g.setColor(Color.black);
					g.drawOval(v.getX() - 25, v.getY() - 25, 50, 50);

					g.setColor(Color.red);
					g.drawString(Integer.toString(v.getLabel()), v.getX() - 3, v.getY() + 3);

					g.setColor(Color.black);
				}
			}
		}

	}

	public class VerticeGUIMovment implements MouseMotionListener {
		GraphModelVertice vertice;
		DrawPanelGUI panel;

		@Override
		public void mouseDragged(MouseEvent e) {
			try {

				panel = ((CodegGraphGUI.DrawPanelGUI) e.getComponent());
				// vertice = vertices.get(0);

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
		public void mouseMoved(MouseEvent e) {
		}
	}

	public GraphModel getGraph() {
		return this.graph;
	}

	public byte[] getUserInput() {
		String uInput = txtFile.getText() + "\n" + graph.isDirected();
		userInput = uInput.getBytes();
		return userInput;
	}

	public String getLabel() {
		return label;
	}

	private JButton btCancel;
	private JButton btOk;
	private JButton btSearchFile;
	private DrawPanelGUI drawPanelGUI;
	private JInternalFrame jInternalFrameGraph;
	private JMenuBar jMenuBar;
	private JMenu jMenuEdge;
	private JCheckBoxMenuItem jMenuDirected;
	private JMenuItem jMenuReload;
	private JMenuItem jMenuClone;
	private JMenuItem jMenuEdgeAdd;
	private JMenuItem jMenuEdgeRemove;
	private JMenu jMenuGraph;
	private JMenu jMenuVertice;
	private JMenuItem jMenuVerticeAdd;
	private JMenuItem jMenuVerticeRemove;
	private JLabel lblFile;
	private JLabel lblLabel;
	private JLabel statusJLabel;
	private JTextField txtFile;
	private JTextField txtLabel;
	private GraphModel graph;

}
