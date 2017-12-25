package util.modifyDialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class PointModifyDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8163095740698922075L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	private Point pt;
	private JLabel lblX;
	private JFormattedTextField frmtdtxtfldX;

	/**
	 * Create the dialog.
	 */
	public PointModifyDialog(Point pt) {
		// Create clone of point
		this.pt = new Point(pt.getX(), pt.getY(), pt.getColor());

		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 386);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblX = new JLabel("X coordinate:");
			lblX.setFont(new Font("Dialog", Font.BOLD, 11));
			contentPanel.add(lblX);
		}
		{
			frmtdtxtfldX = new JFormattedTextField(new Integer(pt.getX()));
			frmtdtxtfldX.setToolTipText("Value");
			contentPanel.add(frmtdtxtfldX);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
		pack();
	}

	public Point getPt() {
		return pt;
	}

}
