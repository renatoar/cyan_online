package meta.codegLibrary;

import java.awt.Component;
import java.awt.Toolkit;

/**
 *
 * Codeg Library
 *
 * @author Andr� Cassulino Ara�jo Souza
 *
 */
public class CodegStringTextGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegStringTextGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
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

		if (userInput == null)
			userInput = "".getBytes();

		txtText.setText(new String(userInput));
		txtLabel.setText(label);
	}

	private void initComponents() {

		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		lblText = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtText = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Codeg StringText");
		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);
		setType(java.awt.Window.Type.POPUP);
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

		lblText.setText("Text:");

		txtText.setColumns(20);
		txtText.setRows(5);
		jScrollPane1.setViewportView(txtText);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblLabel)
												.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblText))
										.addGap(0, 180, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btOk)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btCancel)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblText)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		this.userInput = txtText.getText().getBytes();
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
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JLabel lblText;
	private javax.swing.JTextField txtLabel;
	private javax.swing.JTextArea txtText;

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}
}
