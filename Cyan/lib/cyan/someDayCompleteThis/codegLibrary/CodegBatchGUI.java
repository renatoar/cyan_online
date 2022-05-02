package meta.codegLibrary;

import java.awt.Component;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegBatchGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	public CodegBatchGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
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
					txtFile.setText(line);
					break;
				case 1:
					txtRun.setText(line);
					break;
				case 2:
					txtFileOutput.setText(line);
					break;
				default:
					txtCommand.setText(txtCommand.getText() + line + "\n");
				}
				i++;
			}

		}

		txtLabel.setText(label);
	}

	private void initComponents() {

		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		lblFile = new javax.swing.JLabel();
		txtFile = new javax.swing.JTextField();
		lblRun = new javax.swing.JLabel();
		txtRun = new javax.swing.JTextField();
		lblFileOutput = new javax.swing.JLabel();
		txtFileOutput = new javax.swing.JTextField();
		lblCommand = new javax.swing.JLabel();
		lblOutput = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtCommand = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtOutput = new javax.swing.JTextArea();
		btSearchBatch = new javax.swing.JButton();
		btSearchDirectory = new javax.swing.JButton();
		btRun = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Codeg Batch");
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

		lblFile.setText("Batch File");

		txtFile.setEditable(false);

		lblRun.setText("Run on:");

		txtRun.setEditable(false);

		lblFileOutput.setText("Output File:");

		lblCommand.setText("Input:");

		lblOutput.setText("Output:");

		txtCommand.setColumns(20);
		txtCommand.setRows(5);
		txtCommand.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
		jScrollPane1.setViewportView(txtCommand);

		txtOutput.setColumns(20);
		txtOutput.setRows(5);
		txtOutput.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
		jScrollPane2.setViewportView(txtOutput);

		btSearchBatch.setText("Search");
		btSearchBatch.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchBatchActionPerformed(evt);
			}
		});

		btSearchDirectory.setText("Search");
		btSearchDirectory.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchDirectoryActionPerformed(evt);
			}
		});

		btRun.setText("Run");
		btRun.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btRunActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblLabel)
										.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFile).addComponent(lblRun).addComponent(lblFileOutput)
										.addComponent(txtFileOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCommand).addComponent(lblOutput))
								.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(jScrollPane2)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(btRun)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btOk)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btCancel))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(txtRun).addComponent(txtFile))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btSearchBatch, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(btSearchDirectory, javax.swing.GroupLayout.Alignment.TRAILING))))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblFile)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btSearchBatch))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblRun)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btSearchDirectory))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblFileOutput)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtFileOutput, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblCommand)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblOutput)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btCancel).addComponent(btOk).addComponent(btRun))));

		btOk.getAccessibleContext().setAccessibleDescription("");

		pack();
	}

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
		String newUserInput = txtFile.getText() + "\n" + txtRun.getText() + "\n" + txtFileOutput.getText() + "\n"
				+ txtCommand.getText();
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

	private void btSearchDirectoryActionPerformed(java.awt.event.ActionEvent evt) {
		formClick = true;
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Folder for Run Batch File");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtRun.setText(chooser.getSelectedFile().toString());
		}
	}

	private void btSearchBatchActionPerformed(java.awt.event.ActionEvent evt) {
		formClick = true;
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Batch File");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.showOpenDialog(null);

		if (chooser.getSelectedFile() != null) {
			txtFile.setText(chooser.getSelectedFile().toString());

			try {
				FileReader fileReader = new FileReader(chooser.getSelectedFile());
				BufferedReader reader = new BufferedReader(fileReader);
				String data = null;
				String output = "";
				while ((data = reader.readLine()) != null) {
					output += data + "\n";
				}
				txtCommand.setText(output);
				fileReader.close();
				reader.close();
				// arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void btRunActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			File temp = File.createTempFile("commands", ".bat");
			// System.out.println("Temp file: " + temp.getAbsolutePath());

			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(temp), StandardCharsets.ISO_8859_1));
			if (txtRun.getText().length() > 0) {
				bw.write("cd /d " + txtRun.getText() + "");
				bw.newLine();
			}
			bw.write(txtCommand.getText());
			bw.close();

			// System.out.println("Temporary File: ");
			FileReader fileReader = new FileReader(temp);
			BufferedReader reader = new BufferedReader(fileReader);
			String data2 = null;
			while ((data2 = reader.readLine()) != null) {
				System.out.println(data2);
			}
			fileReader.close();
			reader.close();

			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec(temp.getAbsolutePath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));

			String data = null;
			String output = "";
			while ((data = input.readLine()) != null) {
				output += data + "\n";
			}
			txtOutput.setText(output);

			temp.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JButton btRun;
	private javax.swing.JButton btSearchBatch;
	private javax.swing.JButton btSearchDirectory;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblCommand;
	private javax.swing.JLabel lblFile;
	private javax.swing.JLabel lblFileOutput;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JLabel lblOutput;
	private javax.swing.JLabel lblRun;
	private javax.swing.JTextArea txtCommand;
	private javax.swing.JTextField txtFile;
	private javax.swing.JTextField txtFileOutput;
	private javax.swing.JTextField txtLabel;
	private javax.swing.JTextArea txtOutput;
	private javax.swing.JTextField txtRun;

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}

	public String getFileOutput() {
		return txtFileOutput.getText();
	}

	public String getOutput() {
		return txtOutput.getText();
	}
}
