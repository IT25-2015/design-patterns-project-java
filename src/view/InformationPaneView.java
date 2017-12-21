package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class InformationPaneView extends JPanel {

	private JLabel lblName;
	private JLabel lblCo;

	/**
	 * Create the panel.
	 */
	public InformationPaneView() {
		setLayout(new BorderLayout(0, 0));

		lblName = new JLabel("Aleksandar Babic IT53/2015");
		lblName.setFont(new Font("Arial", Font.PLAIN, 16));
		add(lblName, BorderLayout.WEST);

		lblCo = new JLabel("Cursor not moved yet");
		lblCo.setFont(new Font("Arial", Font.PLAIN, 16));
		add(lblCo, BorderLayout.EAST);

	}

	public JLabel getLblCo() {
		return lblCo;
	}

	public void setLblCo(JLabel lblCo) {
		this.lblCo = lblCo;
	}

	public JLabel getLblName() {
		return lblName;
	}
}
