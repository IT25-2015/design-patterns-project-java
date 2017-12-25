package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

@SuppressWarnings("serial")
public class ToolboxView extends JPanel {
	private GridBagLayout gridBagLayout;
	private JButton btnUndo;
	private GridBagConstraints gbc_btnUndo;
	private JButton btnRedo;
	private GridBagConstraints gbc_btnRedo;
	private JToggleButton tglbtnSelect;
	private GridBagConstraints gbc_btnSelect;
	private JButton btnDelete;
	private GridBagConstraints gbc_btnDelete;
	private JButton btnInnerColor;
	private JButton btnOuterColor;
	private JButton btnModify;

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

		btnInnerColor = new JButton("");
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnInnerColor.gridx = 5;
		gbc_btnInnerColor.gridy = 0;
		add(btnInnerColor, gbc_btnInnerColor);

		btnOuterColor = new JButton("");
		btnOuterColor.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
		gbc_btnOuterColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnOuterColor.gridx = 6;
		gbc_btnOuterColor.gridy = 0;
		add(btnOuterColor, gbc_btnOuterColor);

		tglbtnSelect = new JToggleButton("Select");
		gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 9;
		gbc_btnSelect.gridy = 0;
		add(tglbtnSelect, gbc_btnSelect);

		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 10;
		gbc_btnModify.gridy = 0;
		add(btnModify, gbc_btnModify);

		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
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

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public JButton getBtnOuterColor() {
		return btnOuterColor;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

}
