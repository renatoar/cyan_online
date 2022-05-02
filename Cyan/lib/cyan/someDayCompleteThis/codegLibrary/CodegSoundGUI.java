package meta.codegLibrary;

import java.awt.Component;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * Codeg Library
 *
 * @author André Cassulino Araújo Souza
 *
 */
public class CodegSoundGUI extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	byte[] userInput;
	private String label;
	private boolean formClick = false;
	private int mouseCount = 0;

	final int bufSize = 16384;
	Capture capture = new Capture();
	Playback playback = new Playback();
	AudioInputStream audioInputStream;
	String errStr;
	double duration, seconds;

	public CodegSoundGUI(java.awt.Frame parent, byte[] previousUserInput, String previousLabel) {
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

		if (userInput == null) {
			userInput = "".getBytes();
		}

		txtLabel.setText(label);
		loadAudio();
	}

	private void initComponents() {

		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		lblLabel = new javax.swing.JLabel();
		txtLabel = new javax.swing.JTextField();
		btRecord = new javax.swing.JToggleButton();
		btPlay = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Codeg Sound");
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

		btRecord.setText("Record");
		btRecord.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btRecordActionPerformed(evt);
			}
		});

		btPlay.setText("Play");
		btPlay.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btPlayActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtLabel)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(btOk)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btCancel))
						.addComponent(lblLabel)
						.addGroup(layout.createSequentialGroup()
								.addComponent(btRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btRecord).addComponent(btPlay))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
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

	private void btRecordActionPerformed(java.awt.event.ActionEvent evt) {
		if (btRecord.getText() == "Record") {
			btPlay.setEnabled(false);
			btRecord.setText("Stop Recording");
			capture.start();
		} else {
			btPlay.setEnabled(true);
			btRecord.setText("Record");
			capture.stop();
		}
	}

	private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {
		if (btPlay.isSelected()) {
			btRecord.setEnabled(false);
			btPlay.setText("Stop Playing");
			playback.start();
		} else {
			btPlay.setText("Play");
			btRecord.setEnabled(true);
			playback.stop();
		}
	}

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JToggleButton btPlay;
	private javax.swing.JToggleButton btRecord;
	private javax.swing.JLabel lblLabel;
	private javax.swing.JTextField txtLabel;

	public byte[] getUserInput() {
		return userInput;
	}

	public String getLabel() {
		return label;
	}

	private void loadAudio() {
		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		float rate = 44100.0f;
		int channels = 2;
		int sampleSize = 16;
		boolean bigEndian = true;

		AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8) * channels, rate,
				bigEndian);

		// play back the captured audio data
		int frameSizeInBytes = format.getFrameSize();

		// load bytes into the audio input stream for playback
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput);
		audioInputStream = new AudioInputStream(bais, format, userInput.length / frameSizeInBytes);

	}

	// Código de:
	// http://www.java2s.com/Tutorial/Java/0120__Development/Thisisasimpleprogramtorecordsoundsandplaythemback.htm
	/**
	 * Write data to the OutputChannel.
	 */
	public class Playback implements Runnable {

		SourceDataLine line;

		Thread thread;

		public void start() {
			errStr = null;
			thread = new Thread(this);
			thread.setName("Playback");
			thread.start();
		}

		public void stop() {
			thread = null;
		}

		private void shutDown(String message) {
			if ((errStr = message) != null) {
				System.err.println(errStr);
			}
			if (thread != null) {
				thread = null;
			}
		}

		@Override
		public void run() {

			// make sure we have something to play
			if (audioInputStream == null) {
				shutDown("No loaded audio to play back");
				return;
			}
			// reset to the beginnning of the stream
			try {
				audioInputStream.reset();
			} catch (Exception e) {
				shutDown("Unable to reset the stream\n" + e);
				return;
			}

			// get an AudioInputStream of the desired format for playback
			AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
			float rate = 44100.0f;
			int channels = 2;
			int sampleSize = 16;
			boolean bigEndian = true;

			AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8) * channels,
					rate, bigEndian);

			AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);

			if (playbackInputStream == null) {
				shutDown("Unable to convert stream of format " + audioInputStream + " to format " + format);
				return;
			}

			// define the required attributes for our line,
			// and make sure a compatible line is supported.
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			if (!AudioSystem.isLineSupported(info)) {
				shutDown("Line matching " + info + " not supported.");
				return;
			}

			// get and open the source data line for playback.
			try {
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(format, bufSize);
			} catch (LineUnavailableException ex) {
				shutDown("Unable to open the line: " + ex);
				return;
			}

			// play back the captured audio data
			int frameSizeInBytes = format.getFrameSize();
			int bufferLengthInFrames = line.getBufferSize() / 8;
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			int numBytesRead = 0;

			// start the source data line
			line.start();

			while (thread != null) {
				try {
					if ((numBytesRead = playbackInputStream.read(data)) == -1) {
						break;
					}
					int numBytesRemaining = numBytesRead;
					while (numBytesRemaining > 0) {
						numBytesRemaining -= line.write(data, 0, numBytesRemaining);
					}
				} catch (Exception e) {
					shutDown("Error during playback: " + e);
					break;
				}
			}
			// we reached the end of the stream.
			// let the data play out, then
			// stop and close the line.
			if (thread != null) {
				line.drain();
			}
			line.stop();
			line.close();
			line = null;
			shutDown(null);

			// reconfigurar os botões
			btPlay.setText("Play");
			btPlay.setSelected(false);
			btRecord.setEnabled(true);
		}
	} // End class Playback

	/**
	 * Reads data from the input channel and writes to the output stream
	 */
	class Capture implements Runnable {

		TargetDataLine line;

		Thread thread;

		public void start() {
			errStr = null;
			thread = new Thread(this);
			thread.setName("Capture");
			thread.start();
		}

		public void stop() {
			thread = null;
		}

		private void shutDown(String message) {
			if ((errStr = message) != null && thread != null) {
				thread = null;

				System.err.println(errStr);
			}
		}

		@Override
		public void run() {

			duration = 0;
			audioInputStream = null;

			// define the required attributes for our line,
			// and make sure a compatible line is supported.
			AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
			float rate = 44100.0f;
			int channels = 2;
			int sampleSize = 16;
			boolean bigEndian = true;

			AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8) * channels,
					rate, bigEndian);

			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

			if (!AudioSystem.isLineSupported(info)) {
				shutDown("Line matching " + info + " not supported.");
				return;
			}

			// get and open the target data line for capture.
			try {
				line = (TargetDataLine) AudioSystem.getLine(info);
				line.open(format, line.getBufferSize());
			} catch (LineUnavailableException ex) {
				shutDown("Unable to open the line: " + ex);
				return;
			} catch (SecurityException ex) {
				shutDown(ex.toString());
				// JavaSound.showInfoDialog();
				return;
			} catch (Exception ex) {
				shutDown(ex.toString());
				return;
			}

			// play back the captured audio data
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int frameSizeInBytes = format.getFrameSize();
			int bufferLengthInFrames = line.getBufferSize() / 8;
			int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
			byte[] data = new byte[bufferLengthInBytes];
			int numBytesRead;

			line.start();

			while (thread != null) {
				if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
					break;
				}
				out.write(data, 0, numBytesRead);
			}

			// we reached the end of the stream.
			// stop and close the line.
			line.stop();
			line.close();
			line = null;

			// stop and close the output stream
			try {
				out.flush();
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			// load bytes into the audio input stream for playback
			byte audioBytes[] = out.toByteArray();
			userInput = audioBytes;

			ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
			audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

			long milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / format.getFrameRate());
			duration = milliseconds / 1000.0;

			try {
				audioInputStream.reset();
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}

		}
	} // End class Capture
}
