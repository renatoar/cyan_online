package meta.codegLibrary;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import cyan.lang._ExceptionStr;
import cyanruntime.ExceptionContainer__;
import cyanruntime.Ref;
import meta.CyanMetaobject;
import meta.DirectoryKindPPP;
import meta.IAbstractCyanCompiler;
import meta.ICompiler_ded;
import meta.WrCyanMetaobjectWithAtAnnotation;
import saci.CyanCodeSnippet;
import saci.LoadUtil;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegCyanGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;
	private Boolean live = false;

	private ICompiler_ded compiler_ded;
	private WrCyanMetaobjectWithAtAnnotation annot;


	public CodegCyanGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel, ICompiler_ded compiler_ded, WrCyanMetaobjectWithAtAnnotation annot) {
		super(parent, true);

		this.annot = annot;
		this.compiler_ded = compiler_ded;

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
					live = line.equals("true");
					break;
				default:
					txtCommand.setText(txtCommand.getText() + line + "\n");
				}
				i++;
			}

		}

		txtLabel.setText(label);
		jTogLive.setSelected(live);
	}

	private void initComponents() {

		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		lblFile = new javax.swing.JLabel();
		txtFile = new javax.swing.JTextField();
		lblCommand = new javax.swing.JLabel();
		lblOutput = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtCommand = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtOutput = new javax.swing.JTextArea();
		btSearchTryFile = new javax.swing.JButton();
        btReload = new javax.swing.JButton();
		btCopyCyanCode = new javax.swing.JButton();
		btCopyOutput = new javax.swing.JButton();
		btRun = new javax.swing.JButton();
		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		btFontPlus = new javax.swing.JButton();
		btFontMinus = new javax.swing.JButton();
		jTogLive = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Codeg Try Cyan");
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

		lblFile.setText("File:");

		txtFile.setEditable(false);

		lblCommand.setText("Cyan Code:");

		lblOutput.setText("Output:");

		txtCommand.setColumns(20);
		txtCommand.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
		txtCommand.setRows(8);
		txtCommand.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				txtCommandKeyPressed();

			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				txtCommandKeyPressed();

			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}
		});

		//JScrollPane scrollPane = new JScrollPane(txtCommand);
		TextLineNumber tln = new TextLineNumber(txtCommand);
		//scrollPane.setRowHeaderView( tln );

		// txtCommand.addKeyListener(new java.awt.event.KeyAdapter() {
		// public void keyPressed(java.awt.event.KeyEvent evt) {
		// txtCommandKeyPressed();
		// }
		// });

		// txtCommand.setText("var Int s = 0;\r\n" +
		// "for elem in 1..10 {\r\n" +
		// " s = s + elem\r\n" +
		// "}\r\n" +
		// "Out println: \"s = \" ++ s;");
		//
		jScrollPane1.setRowHeaderView(tln);
		jScrollPane1.setViewportView(txtCommand);

		txtOutput.setColumns(20);
		txtOutput.setRows(8);
		txtOutput.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
		txtOutput.setEditable(false);
		jScrollPane2.setViewportView(txtOutput);

		btSearchTryFile.setText("Search");
		btSearchTryFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSearchTryFileActionPerformed(evt);
			}
		});


        btReload.setText("Reload files from disk");
        btReload.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReloadActionPerformed(evt);
            }
        });

		btCopyCyanCode.setText("Copy Cyan Code");
		btCopyCyanCode.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCopyCyanCodeActionPerformed(evt);
			}
		});

		btCopyOutput.setText("Copy Output");
		btCopyOutput.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCopyOutputActionPerformed(evt);
			}
		});

		btRun.setText("Run");
		btRun.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btRunActionPerformed();
			}
		});
		jTogLive.setText("Live");
		jTogLive.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btLiveActionPerformed(evt);
			}
		});

		btFontPlus.setText("A+");
		btFontPlus.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btFontPlusActionPerformed(evt);
			}
		});

		btFontMinus.setText("A-");
		btFontMinus.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btFontMinusActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLabel)
                            .addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFile)
                            .addComponent(lblOutput))
                        .addGap(0, 715, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCopyCyanCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTogLive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearchTryFile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCommand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFontMinus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFontPlus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearchTryFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommand)
                    .addComponent(btFontPlus)
                    .addComponent(btFontMinus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel)
                    .addComponent(btOk)
                    .addComponent(btRun)
                    .addComponent(jTogLive)
                    .addComponent(btCopyCyanCode)
                    .addComponent(btReload))
                .addContainerGap())
        );


		pack();
	}// </editor-fold>

	protected void btReloadActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void btFontMinusActionPerformed(ActionEvent evt) {

		int tam;
		tam = txtCommand.getFont().getSize();
		if (tam >= 8)
			tam = tam - 2;

		txtCommand.setFont(new java.awt.Font("Monospaced", 0, tam));
		txtOutput.setFont(new java.awt.Font("Monospaced", 0, tam));

		formClicked();


	}

	protected void btFontPlusActionPerformed(ActionEvent evt) {

		int tam;
		tam = txtCommand.getFont().getSize();
		if (tam <= 28)
			tam = tam + 2;

		txtCommand.setFont(new java.awt.Font("Monospaced", 0, tam));
		txtOutput.setFont(new java.awt.Font("Monospaced", 0, tam));

		formClicked();


	}

	protected void btCopyCyanCodeActionPerformed(ActionEvent evt) {
		StringSelection stringSelection = new StringSelection(txtCommand.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);


		formClicked();


	}

	protected void btCopyOutputActionPerformed(ActionEvent evt) {
		StringSelection stringSelection = new StringSelection(txtOutput.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);


		formClicked();


	}

	protected void txtCommandKeyPressed() {
		if (live)
			btRunActionPerformed();


		formClicked();


	}

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
		String newUserInput = txtFile.getText() + "\n" + jTogLive.isSelected() + "\n" + txtCommand.getText();
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

	private void btSearchTryFileActionPerformed(java.awt.event.ActionEvent evt) {
		formClick = true;
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select File");
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


		formClicked();

	}


	private void btRunActionPerformed () {

		final Ref<Object> ret = new Ref<>();
		ret.elem = null;

		ArrayList<Object> javaParamList = annot.getJavaParameterList();

		String []varNameList = new String [javaParamList.size()-1];
		Object []objValueList = new Object [javaParamList.size()-1];
		LoadUtil.addSaciOutputDirToClassPath(compiler_ded.getProjectDir(), () -> {

			for(int i = 1; i < javaParamList.size(); ++i) {
				Object obj = javaParamList.get(i);
				String varName = CyanMetaobject.removeQuotes((String ) obj);
				varNameList[i-1] = varName;


				final String filename = getFilenameVar(compiler_ded, varName, annot);
				try (   java.io.FileInputStream file = new java.io.FileInputStream(filename);
						java.io.ObjectInputStream in = new java.io.ObjectInputStream(file) ) {
					//objValueList[i] = in.readObject();
					objValueList[i-1] = LoadUtil.readObject(filename, Thread.currentThread().getContextClassLoader());

				}
				catch (ClassNotFoundException e) {
					objValueList[i-1] = null;
					/* this.addError("Error when retrieving value of variable '" + varName + "' from file '" +
				       filename + "'. Class '" + e.getMessage() + "' was not found."); */
				}
				catch (IOException e) {
					objValueList[i-1] = null;
					//this.addError("Error when retrieving value of variable '" + varName + "' from file '" + filename + "'");
				}

			}

			ret.elem = btRunActionPerformed( varNameList, objValueList );

		} );
	}

	private Object btRunActionPerformed( String [] varNameList, Object [] objValueList ) {

		PrintStream pout = System.out;
		PrintStream perr = System.err;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		System.setErr(ps);

		String cyanCode = txtCommand.getText();
		Object selfObject = new Object();
		String cyanLangDir = null;
		Object ret = null;
		try {
			CyanCodeSnippet cs = new CyanCodeSnippet();
			ret = cs.evalCyanCode(cyanCode, selfObject, cyanLangDir,
                varNameList, objValueList );
		}
		catch ( ExceptionContainer__ e ) {
			System.out.println( ((_ExceptionStr) e.elem)._message().s );
		}
		catch ( Throwable e ) {
			System.out
			.println("Exception " + e.getClass().getCanonicalName() + " was thrown. Its message is '"
			        + e.getMessage() + "1" );
		}

		String output = baos.toString();
		txtOutput.setText(output); // + "\n\n TryCyan is over");

		System.setOut(pout);
		System.setErr(perr);


		formClicked();
		return ret;

	}

	private static String getFilenameVar(IAbstractCyanCompiler compiler, String varName,
			WrCyanMetaobjectWithAtAnnotation annotation) {
		return compiler.getPathFileHiddenDirectory(
				annotation.getPrototypeOfAnnotation(),
				annotation.getPackageOfAnnotation(),
				DirectoryKindPPP.TMP) +  "keepValue_" + varName + ".txt";
	}

	private void btLiveActionPerformed(ActionEvent evt) {
		live = jTogLive.isSelected();
		if (live)
			btRunActionPerformed();


		formClicked();

	}

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}

	public String getOutput() {
		return txtOutput.getText();
	}



	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
    private javax.swing.JButton btReload;
	private javax.swing.JButton btCopyCyanCode;
	private javax.swing.JButton btCopyOutput;
	private javax.swing.JButton btFontMinus;
	private javax.swing.JButton btFontPlus;
	private javax.swing.JButton btRun;
	private javax.swing.JButton btSearchTryFile;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblCommand;
	private javax.swing.JLabel lblFile;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JLabel lblOutput;
	private javax.swing.JTextArea txtCommand;
	private javax.swing.JTextField txtFile;
	private javax.swing.JTextField txtLabel;
	private javax.swing.JTextArea txtOutput;
	private javax.swing.JToggleButton jTogLive;

}
