package util.modifyDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PlainDocument;

import shapes.point.Point;
import util.DialogsHelper;
import util.PositiveIntFilter;

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
	private JLabel lblY;
	private JButton btnInnerColor;
	private JLabel lblColor;
	private JTextField textFieldX;
	private JTextField textFieldY;

	/**
	 * Create the dialog.
	 */
	public PointModifyDialog(Point pt) {
		this.pt = new Point(pt.getX(), pt.getY(), pt.getColor());

		setModalityType(DEFAULT_MODALITY_TYPE); // Make dialog modal
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 386);
		// Calculate center of screen and set dialog there
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			lblX = new JLabel("X coordinate:");
			lblX.setFont(new Font("Dialog", Font.BOLD, 11));
			contentPanel.add(lblX);
		}
		{
			textFieldX = new JTextField();
			PlainDocument doc = (PlainDocument) textFieldX.getDocument();
			doc.setDocumentFilter(new PositiveIntFilter());
			textFieldX.setText(Integer.toString(pt.getX()));
			contentPanel.add(textFieldX);
			textFieldX.setColumns(10);
		}
		{
			lblY = new JLabel("Y coordinate:");
			lblY.setFont(new Font("Dialog", Font.BOLD, 11));
			contentPanel.add(lblY);
		}
		{
			textFieldY = new JTextField();
			PlainDocument doc = (PlainDocument) textFieldY.getDocument();
			doc.setDocumentFilter(new PositiveIntFilter());
			textFieldY.setText(Integer.toString(pt.getY()));
			contentPanel.add(textFieldY);
			textFieldY.setColumns(10);
		}
		{
			lblColor = new JLabel("Color:");
			contentPanel.add(lblColor);
		}
		{
			btnInnerColor = new JButton();
			btnInnerColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					Color newColor = JColorChooser.showDialog(getBtnInnerColor(), "Choose color",
							getBtnInnerColor().getBackground());
					getBtnInnerColor()
							.setBackground((newColor != null) ? newColor : getBtnInnerColor().getBackground());
				}
			});
			contentPanel.add(btnInnerColor);
			btnInnerColor.setBackground(pt.getColor());
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						ok();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						cancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						ok();
					} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						cancel();
					}
				}
				return false; // Force to try to handle event again
			}
		});

		pack(); // Set size to match inner components
		setVisible(true);
	}

	/**
	 * Gets executed when user confirms changes (Either click or enter key)
	 */
	public void ok() {
		try {

			getPt().setX(Integer.parseInt(textFieldX.getText()));
			getPt().setY(Integer.parseInt(textFieldY.getText()));
			getPt().setColor(btnInnerColor.getBackground());
			setVisible(false);
			dispose();
		} catch (NumberFormatException ex) {
			DialogsHelper.showErrorMessage("Coordinates must be Integer numbers.");
		}
	}

	/**
	 * Gets executed when user cancel changes (Either click or escape key)
	 */
	public void cancel() {
		setVisible(false);
		dispose();
	}

	public Point getPt() {
		return pt;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

}
