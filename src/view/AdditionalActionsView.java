package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class AdditionalActionsView extends JPanel {
	GridBagLayout gridBagLayout;
	JButton btnBringToFront;
	JButton btnBringToBack;
	JButton btnToFront;
	JButton btnToBack;
	
	public AdditionalActionsView() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnBringToFront = new JButton("Bring To Front");
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnBringToFront.gridx = 0;
		gbc_btnBringToFront.gridy = 0;
		add(btnBringToFront, gbc_btnBringToFront);
		
		btnBringToBack = new JButton("Bring To Back");
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBringToBack.gridx = 0;
		gbc_btnBringToBack.gridy = 1;
		add(btnBringToBack, gbc_btnBringToBack);
		
		btnToFront = new JButton("To Front");
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		gbc_btnToFront.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnToFront.insets = new Insets(0, 0, 5, 0);
		gbc_btnToFront.gridx = 0;
		gbc_btnToFront.gridy = 2;
		add(btnToFront, gbc_btnToFront);
		
		btnToBack = new JButton("To Back");
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnToBack.gridx = 0;
		gbc_btnToBack.gridy = 3;
		add(btnToBack, gbc_btnToBack);
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

}
