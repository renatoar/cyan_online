package meta.codegLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.QuadCurve2D;
import java.io.File;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import meta.codegLibrary.FSMControllerDraw.MouseListenerForDrawPanel;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegFSMGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	FSMData data;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegFSMGUI(java.awt.Frame parent, FSMData data, String previousLabel) {
		super(parent, true);
		this.data = data;
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
		if (data != null)
			txtFile.setText(data.getFile());
		loadFSM();
	}

	private void initComponents() {

		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		lblFile = new javax.swing.JLabel();
		txtFile = new javax.swing.JTextField();
		btSearchFile = new javax.swing.JButton();
		jInternalFrameFSM = new javax.swing.JInternalFrame();
		statusJLabel = new javax.swing.JLabel();
		jMenuBar = new javax.swing.JMenuBar();
		jMenuFSM = new javax.swing.JMenu();
		jMenuFSMReload = new javax.swing.JMenuItem();
		jMenuState = new javax.swing.JMenu();
		jMenuStateAdd = new javax.swing.JMenuItem();
		jMenuStateInitialAdd = new javax.swing.JMenuItem();
		jMenuStateFinalAdd = new javax.swing.JMenuItem();
		jMenuStateRemove = new javax.swing.JMenuItem();
		jMenuTransition = new javax.swing.JMenu();
		jMenuTransitionAdd = new javax.swing.JMenuItem();
		jMenuTransitionRemove = new javax.swing.JMenuItem();

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

		jInternalFrameFSM.setTitle("Finite State Machine");
		jInternalFrameFSM.setVisible(true);

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

		jMenuFSM.setText("FSM");
		jMenuFSM.setToolTipText("");

		jMenuFSMReload.setText("Reload");
		jMenuFSMReload.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuFSMReloadActionPerformed(evt);
			}
		});
		jMenuFSM.add(jMenuFSMReload);

		jMenuBar.add(jMenuFSM);

		jMenuState.setText("State");

		jMenuStateAdd.setText("Add State");
		jMenuState.add(jMenuStateAdd);

		jMenuStateInitialAdd.setText("Mark / Unmark Initial");
		jMenuState.add(jMenuStateInitialAdd);

		jMenuStateFinalAdd.setText("Mark / Unmark Final");
		jMenuState.add(jMenuStateFinalAdd);

		jMenuStateRemove.setText("Remove State");
		jMenuState.add(jMenuStateRemove);

		jMenuBar.add(jMenuState);

		jMenuTransition.setText("Transition");

		jMenuTransitionAdd.setText("Add Transition");
		jMenuTransitionAdd.setToolTipText("");
		jMenuTransition.add(jMenuTransitionAdd);

		jMenuTransitionRemove.setText("Remove Transition");
		jMenuTransition.add(jMenuTransitionRemove);

		jMenuBar.add(jMenuTransition);

		jInternalFrameFSM.setJMenuBar(jMenuBar);

		javax.swing.GroupLayout jInternalFrameFSMLayout = new javax.swing.GroupLayout(
				jInternalFrameFSM.getContentPane());
		jInternalFrameFSM.getContentPane().setLayout(jInternalFrameFSMLayout);
		jInternalFrameFSMLayout.setHorizontalGroup(jInternalFrameFSMLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jInternalFrameFSMLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(statusJLabel))
				.addGroup(jInternalFrameFSMLayout.createSequentialGroup().addContainerGap().addComponent(drawPanelGUI,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jInternalFrameFSMLayout.setVerticalGroup(
				jInternalFrameFSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jInternalFrameFSMLayout.createSequentialGroup().addContainerGap()
								.addComponent(drawPanelGUI, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(statusJLabel)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jInternalFrameFSM)
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
						.addComponent(jInternalFrameFSM)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btCancel).addComponent(btOk))
						.addContainerGap()));

		pack();
	}

	private void jMenuFSMReloadActionPerformed(java.awt.event.ActionEvent evt) {
		String filename = txtFile.getText();
		fsm.reload(filename);

		repaint();
		revalidate();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {

		data.setFile(txtFile.getText());
		fsm.setFile(txtFile.getText());

		fsm.saveToFile();
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

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void btSearchFileActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select FSM File");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setSelectedFile(new File(txtFile.getText()));
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtFile.setText(chooser.getSelectedFile().toString());
		}
	}

	private void loadFSM() {
		// String filename = txtFile.getText();

		fsm = new FSMModel(data);
		drawPanelGUI.addMouseMotionListener(new StateGUIMovment());

		repaint();
		revalidate();

	}

	public void setStatus(final String text) {
		statusJLabel.setText(text);
	}

	public void addMouseMotionListenerToDrawPanel(FSMControllerDraw.StateGUIMovment stateGUIMovment) {
		drawPanelGUI.addMouseMotionListener(stateGUIMovment);
	}

	public void addMouseListenerForDrawPanel(MouseListenerForDrawPanel mouseListenerForDrawPanel) {
		drawPanelGUI.addMouseListener(mouseListenerForDrawPanel);
	}

	public void addActionForDrawPanel(ActionListener actionForDrawPanel) {
		jMenuTransitionAdd.addActionListener(actionForDrawPanel);
		jMenuTransitionRemove.addActionListener(actionForDrawPanel);
		jMenuStateInitialAdd.addActionListener(actionForDrawPanel);
		jMenuStateFinalAdd.addActionListener(actionForDrawPanel);
		jMenuStateAdd.addActionListener(actionForDrawPanel);
		jMenuStateRemove.addActionListener(actionForDrawPanel);
		// addNewStateJMenuItem.addActionListener(actionForDrawPanel);
		// addNewTransitionJMenuItem.addActionListener(actionForDrawPanel);
		// removeStateJMenuItem.addActionListener(actionForDrawPanel);
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
			// Graphics2D g2d = (Graphics2D) g;

			if (fsm != null) {
				Iterator<FSMModelTransition> itE = fsm.getTransitions().iterator();

				// ArrayList<Transition> control = new ArrayList<Transition>();

				FSMModelTransition e = null;
				while (itE.hasNext()) {
					e = itE.next();

					// if (!fsm.isDirected()) {
					// control.add(e);
					// }

					int xOrigin = e.getOrigin().getX();
					int yOrigin = e.getOrigin().getY();
					int xDestiny = e.getDestiny().getX();
					int yDestiny = e.getDestiny().getY();

					FSMModelState originState = e.getOrigin();
					FSMModelState destinyState = e.getDestiny();

					if (originState.equals(destinyState)) {
						g.drawArc(originState.getX(), originState.getY(), 40, 40, 0, 360);

						g.setColor(Color.red);
						g.drawString(e.getAction(), (destinyState.getX() + 40), (destinyState.getY() + 40));
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

						g.fillPolygon(new int[] { p1.x, p2.x, p3.x }, new int[] { p1.y, p2.y, p3.y }, 3);

					} else {

						double sina = (originState.getY() - destinyState.getY()) / originState.distance(destinyState);
						double cosa = (destinyState.getX() - originState.getX()) / originState.distance(destinyState);

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

						int xDif = xDestiny - xOrigin;
						int yDif = yDestiny - yOrigin;

						int xInterm = xOrigin + (xDif / 2) + 2 * factorx;
						int yInterm = yOrigin + (yDif / 2) + 2 * factory;

						QuadCurve2D q = new QuadCurve2D.Float();
						q.setCurve(xOrigin, yOrigin, xInterm, yInterm, xDestiny, yDestiny);
						// g2d.draw(q);

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

						g.fillPolygon(new int[] { p1.x, p2.x, p3.x }, new int[] { p1.y, p2.y, p3.y }, 3);

						g.setColor(Color.red);
						g.drawString(e.getAction(), xOrigin + xDif / 2, yOrigin + yDif / 2);

						g.setColor(Color.black);

					}

				}

				Iterator<FSMModelState> itV = fsm.getStates().iterator();

				FSMModelState v = null;
				while (itV.hasNext()) {
					v = itV.next();

					g.setColor(Color.white);
					g.fillOval(v.getX() - 25, v.getY() - 25, 50, 50);

					g.setColor(Color.black);
					g.drawOval(v.getX() - 25, v.getY() - 25, 50, 50);

					// circulo concêntrico
					if (v.isFinalState()) {
						g.drawOval(v.getX() - 35, v.getY() - 35, 70, 70);
					}

					// seta
					if (v.isInitialState()) {
						double ang;
						ang = 0;

						Point p1 = new Point();
						Point p2 = new Point();
						Point p3 = new Point();

						if (v.isFinalState()) {
							p1.x = v.getX() - 35;
						} else {
							p1.x = v.getX() - 25;
						}
						p1.y = v.getY();

						p2.x = p1.x + (int) (10 * Math.cos(ang + (150) * Math.PI / 180));
						p2.y = p1.y - (int) (10 * Math.sin(ang + (150) * Math.PI / 180));

						p3.x = p2.x + (int) (10 * Math.cos(ang + (270) * Math.PI / 180));
						p3.y = p2.y - (int) (10 * Math.sin(ang + (270) * Math.PI / 180));

						g.drawLine(p1.x, p1.y, p1.x - 25, p1.y);
						// g.drawLine(p2.x, p2.y, p3.x, p3.y);

						g.fillPolygon(new int[] { p1.x, p2.x, p3.x }, new int[] { p1.y, p2.y, p3.y }, 3);

					}

					g.setColor(Color.red);
					try {
						g.drawString(v.getLabel(), v.getX() - 3, v.getY() + 3);
					} catch (Exception ex) {

					}
					g.setColor(Color.black);
				}
			}
		}

	}

	public class StateGUIMovment implements MouseMotionListener {
		FSMModelState state;
		DrawPanelGUI panel;

		@Override
		public void mouseDragged(MouseEvent e) {
			try {

				panel = ((CodegFSMGUI.DrawPanelGUI) e.getComponent());
				// state = vertices.get(0);

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
		public void mouseMoved(MouseEvent e) {
		}
	}

	public FSMModel getFSM() {
		return this.fsm;
	}

	public String getLabel() {
		return label;
	}

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JButton btSearchFile;
	private DrawPanelGUI drawPanelGUI;
	private javax.swing.JInternalFrame jInternalFrameFSM;
	private javax.swing.JMenuBar jMenuBar;
	private javax.swing.JMenu jMenuFSM;
	private javax.swing.JMenuItem jMenuFSMReload;
	private javax.swing.JMenu jMenuState;
	private javax.swing.JMenuItem jMenuStateAdd;
	private javax.swing.JMenuItem jMenuStateInitialAdd;
	private javax.swing.JMenuItem jMenuStateFinalAdd;
	private javax.swing.JMenuItem jMenuStateRemove;
	private javax.swing.JMenu jMenuTransition;
	private javax.swing.JMenuItem jMenuTransitionAdd;
	private javax.swing.JMenuItem jMenuTransitionRemove;
	private javax.swing.JLabel lblFile;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JLabel statusJLabel;
	private javax.swing.JTextField txtFile;
	private javax.swing.JTextField txtLabel;
	private FSMModel fsm;
	// End of variables declaration
}
