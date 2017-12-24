package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class ToolboxView extends JPanel {
	GridBagLayout gridBagLayout;
	JButton btnUndo;
	GridBagConstraints gbc_btnUndo;
	JButton btnRedo;
	GridBagConstraints gbc_btnRedo;
	JToggleButton tglbtnSelect;
	GridBagConstraints gbc_btnSelect;
	JButton btnDelete;
	GridBagConstraints gbc_btnDelete;

	/**
	 * Create the panel.
	 */
	public ToolboxView() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnUndo = new JButton("Undo");
		gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 0, 5);
		gbc_btnUndo.gridx = 0;
		gbc_btnUndo.gridy = 0;
		add(btnUndo, gbc_btnUndo);

		btnRedo = new JButton("Redo");
		gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 0, 5);
		gbc_btnRedo.gridx = 1;
		gbc_btnRedo.gridy = 0;
		add(btnRedo, gbc_btnRedo);

		tglbtnSelect = new JToggleButton("Select");
		gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 10;
		gbc_btnSelect.gridy = 0;
		add(tglbtnSelect, gbc_btnSelect);

		btnDelete = new JButton("Delete");
		gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 11;
		gbc_btnDelete.gridy = 0;
		add(btnDelete, gbc_btnDelete);

	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public GridBagConstraints getGbc_btnUndo() {
		return gbc_btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public GridBagConstraints getGbc_btnRedo() {
		return gbc_btnRedo;
	}

	public JToggleButton getTglBtnSelect() {
		return tglbtnSelect;
	}

	public GridBagConstraints getGbc_btnSelect() {
		return gbc_btnSelect;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public GridBagConstraints getGbc_btnDelete() {
		return gbc_btnDelete;
	}

}
