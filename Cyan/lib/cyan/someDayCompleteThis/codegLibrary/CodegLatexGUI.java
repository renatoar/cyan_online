
package meta.codegLibrary;

import java.awt.Component;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegLatexGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegLatexGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
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
		else {
			String[] dados = new String(userInput).split("\n");

			int i = 0;
			for (String line : dados) {
				switch (i) {
				case 0:
					txtMimetexFile.setText(line);
					break;
				case 1:
					txtFile.setText(line);
					break;
				default:
					txtLatexCode.setText(txtLatexCode.getText() + line + "\n");
				}
				i++;
			}

		}
		txtLabel.setText(label);
		setLaTeXImage();
	}

	private void initComponents() {

		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		lblFile = new javax.swing.JLabel();
		txtFile = new javax.swing.JTextField();
		btSearchFile = new javax.swing.JButton();
		lblMimetex = new javax.swing.JLabel();
		txtMimetexFile = new javax.swing.JTextField();
		btSearchMimetex = new javax.swing.JButton();
		lblLatexCode = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtLatexCode = new javax.swing.JTextArea();
		lblLatexExpr = new javax.swing.JLabel();
		lblLatexResult = new javax.swing.JLabel();
		txGenerate = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Codeg Latex");
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

		lblFile.setText("Latex File:");

		txtFile.setEditable(false);

		btSearchFile.setText("Search");
		btSearchFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchFileActionPerformed(evt);
			}
		});

		lblMimetex.setText("Mimetex:");

		txtMimetexFile.setEditable(false);

		btSearchMimetex.setText("Search");
		btSearchMimetex.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchMimetexActionPerformed(evt);
			}
		});

		lblLatexCode.setText("Latex Code:");

		txtLatexCode.setColumns(20);
		txtLatexCode.setRows(5);
		jScrollPane1.setViewportView(txtLatexCode);

		lblLatexExpr.setText("Latex Expression:");

		txGenerate.setText("Generate Latex");
		txGenerate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txGenerateActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLatexResult, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(txtMimetexFile)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btSearchMimetex))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(txGenerate)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btOk)
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
												.addComponent(lblMimetex).addComponent(lblFile)
												.addComponent(lblLatexCode).addComponent(lblLatexExpr))
										.addGap(0, 180, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblMimetex)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtMimetexFile, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btSearchMimetex))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblFile)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btSearchFile))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblLatexCode)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblLatexExpr)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblLatexResult, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btCancel).addComponent(btOk).addComponent(txGenerate))
						.addContainerGap()));

		btOk.getAccessibleContext().setAccessibleDescription("");

		pack();
	}

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
		String newUserInput = txtMimetexFile.getText() + "\n" + txtFile.getText() + "\n" + txtLatexCode.getText();
		this.userInput = newUserInput.getBytes();
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

	private void txGenerateActionPerformed(java.awt.event.ActionEvent evt) {
		setLaTeXImage();
	}

	private void btSearchMimetexActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Mimetex Program");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtMimetexFile.setText(chooser.getSelectedFile().toString());
		}
	}

	private void btSearchFileActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Latex File");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtFile.setText(chooser.getSelectedFile().toString());

			try {
				FileReader arq = new FileReader(chooser.getSelectedFile());
				BufferedReader lerArq = new BufferedReader(arq);

				String linha = "";
				txtLatexCode.setText("");
				while ((linha = lerArq.readLine()) != null) {
					txtLatexCode.setText(txtLatexCode.getText() + linha + "\n");
				}

				arq.close();
			} catch (IOException e) {

			}
		}
	}

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JButton btSearchFile;
	private javax.swing.JButton btSearchMimetex;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblFile;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JLabel lblLatexCode;
	private javax.swing.JLabel lblLatexExpr;
	private javax.swing.JLabel lblLatexResult;
	private javax.swing.JLabel lblMimetex;
	private javax.swing.JButton txGenerate;
	private javax.swing.JTextField txtFile;
	private javax.swing.JTextField txtLabel;
	private javax.swing.JTextArea txtLatexCode;
	private javax.swing.JTextField txtMimetexFile;

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}

	public void setLaTeXImage() {

		String MIMETEX_EXE = txtMimetexFile.getText();
		String LATEX_EXPRESSION = txtLatexCode.getText();
		int BUFFER_SIZE = 1024;

		byte[] imageData = null;

		try {
			Process proc = Runtime.getRuntime().exec(MIMETEX_EXE + " -d \"" + LATEX_EXPRESSION + "\"");
			// get the output stream of the process:
			BufferedInputStream bis = (BufferedInputStream) proc.getInputStream();
			// read output process by bytes blocks (size: BUFFER_SIZE)
			// and stores the result in a byte[] Arraylist:
			@SuppressWarnings("unused")
			int bytesRead;
			byte[] buffer = new byte[BUFFER_SIZE];
			ArrayList<byte[]> al = new ArrayList<byte[]>();
			while ((bytesRead = bis.read(buffer)) != -1) {
				al.add(buffer.clone());
			}
			// convert the Arraylist in an unique array:
			int nbOfArrays = al.size();
			if (nbOfArrays == 1) {
				imageData = buffer;
			} else {
				imageData = new byte[BUFFER_SIZE * nbOfArrays];
				byte[] temp;
				for (int k = 0; k < nbOfArrays; k++) {
					temp = al.get(k);
					for (int i = 0; i < BUFFER_SIZE; i++) {
						imageData[BUFFER_SIZE * k + i] = temp[i];
					}
				}
			}
			bis.close();
			proc.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}

		lblLatexResult.setIcon(null);
		lblLatexResult.setIcon(new ImageIcon(imageData));
		lblLatexResult.revalidate();

	}

}
