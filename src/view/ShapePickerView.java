package view;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class ShapePickerView extends JPanel {
	private JRadioButton rdbtnPoint;
	private JRadioButton rdbtnLine;
	private JRadioButton rdbtnCircle;
	private JRadioButton rdbtnSquare;
	private JRadioButton rdbtnRectangle;
	private JRadioButton rdbtnHexagon;
	private ButtonGroup shapesGrp;
	private JLabel lblShapeTxt;

	/**
	 * Create the panel.
	 */
	public ShapePickerView() {

		shapesGrp = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 120, 0 };
		gridBagLayout.rowHeights = new int[] { 42, 42, 42, 42, 42, 42, 42, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblShapeTxt = new JLabel("Selected shape");
		GridBagConstraints gbc_lblShapeTxt = new GridBagConstraints();
		gbc_lblShapeTxt.anchor = GridBagConstraints.WEST;
		gbc_lblShapeTxt.fill = GridBagConstraints.VERTICAL;
		gbc_lblShapeTxt.insets = new Insets(0, 0, 5, 0);
		gbc_lblShapeTxt.gridx = 0;
		gbc_lblShapeTxt.gridy = 0;
		add(lblShapeTxt, gbc_lblShapeTxt);

		rdbtnPoint = new JRadioButton("Point");
		rdbtnPoint.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnPoint = new GridBagConstraints();
		gbc_rdbtnPoint.fill = GridBagConstraints.BOTH;
		gbc_rdbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPoint.gridx = 0;
		gbc_rdbtnPoint.gridy = 1;
		add(rdbtnPoint, gbc_rdbtnPoint);
		shapesGrp.add(rdbtnPoint);
		shapesGrp.setSelected(rdbtnPoint.getModel(), true);

		rdbtnLine = new JRadioButton("Line");
		rdbtnLine.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnLine = new GridBagConstraints();
		gbc_rdbtnLine.fill = GridBagConstraints.BOTH;
		gbc_rdbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnLine.gridx = 0;
		gbc_rdbtnLine.gridy = 2;
		add(rdbtnLine, gbc_rdbtnLine);
		shapesGrp.add(rdbtnLine);

		rdbtnCircle = new JRadioButton("Circle");
		rdbtnCircle.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnCircle = new GridBagConstraints();
		gbc_rdbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_rdbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCircle.gridx = 0;
		gbc_rdbtnCircle.gridy = 3;
		add(rdbtnCircle, gbc_rdbtnCircle);
		shapesGrp.add(rdbtnCircle);

		rdbtnSquare = new JRadioButton("Square");
		rdbtnSquare.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnSquare = new GridBagConstraints();
		gbc_rdbtnSquare.fill = GridBagConstraints.BOTH;
		gbc_rdbtnSquare.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnSquare.gridx = 0;
		gbc_rdbtnSquare.gridy = 4;
		add(rdbtnSquare, gbc_rdbtnSquare);
		shapesGrp.add(rdbtnSquare);

		rdbtnRectangle = new JRadioButton("Rectangle");
		rdbtnRectangle.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnRectangle = new GridBagConstraints();
		gbc_rdbtnRectangle.fill = GridBagConstraints.BOTH;
		gbc_rdbtnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRectangle.gridx = 0;
		gbc_rdbtnRectangle.gridy = 5;
		add(rdbtnRectangle, gbc_rdbtnRectangle);
		shapesGrp.add(rdbtnRectangle);

		rdbtnHexagon = new JRadioButton("Hexagon");
		rdbtnHexagon.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_rdbtnHexagon = new GridBagConstraints();
		gbc_rdbtnHexagon.fill = GridBagConstraints.BOTH;
		gbc_rdbtnHexagon.gridx = 0;
		gbc_rdbtnHexagon.gridy = 6;
		add(rdbtnHexagon, gbc_rdbtnHexagon);
		shapesGrp.add(rdbtnHexagon);

	}

	public JRadioButton getRdbtnPoint() {
		return rdbtnPoint;
	}

	public JRadioButton getRdbtnLine() {
		return rdbtnLine;
	}

	public JRadioButton getRdbtnCircle() {
		return rdbtnCircle;
	}

	public JRadioButton getRdbtnSquare() {
		return rdbtnSquare;
	}

	public JRadioButton getRdbtnRectangle() {
		return rdbtnRectangle;
	}

	public JRadioButton getRdbtnHexagon() {
		return rdbtnHexagon;
	}

	public ButtonGroup getShapesGrp() {
		return shapesGrp;
	}

	public JLabel getLblShapeTxt() {
		return lblShapeTxt;
	}

}
