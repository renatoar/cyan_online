package meta.codegLibrary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegColorGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegColorGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
		super(parent, true);
		userInput = previousUserInput;
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

		setAlwaysOnTop(true);

		if (userInput == null || userInput.length == 0)
			userInput = "0".getBytes();

		int color;
		try {
			color = Integer.parseInt(new String(userInput));
		} catch (Exception e) {
			color = 0;
		}

		jColorChooser.setColor(new Color(color));
		txtLabel.setText(label);
	}

	private void initComponents() {

		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		jColorChooser = new javax.swing.JColorChooser();
		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();

		setTitle("Codeg Color");
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

		lblLabel.setText("Label:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btOk)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btCancel))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblLabel)
										.addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 603,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 316,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btCancel).addComponent(btOk))
						.addContainerGap()));

		btOk.getAccessibleContext().setAccessibleDescription("");

		pack();

	}

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
		int color = (jColorChooser.getColor().getRed() << 16) + (jColorChooser.getColor().getGreen() << 8)
				+ (jColorChooser.getColor().getBlue());
		this.userInput = Integer.toString(color).getBytes();
		this.label = txtLabel.getText();
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

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JColorChooser jColorChooser;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JTextField txtLabel;

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}
}
