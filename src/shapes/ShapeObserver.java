package shapes;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import app.MainFrame;
import model.ShapeModel;

public class ShapeObserver implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 276904460662545054L;
	private MainFrame frame;
	private ShapeModel model;
	private Shape shape;

	/**
	 * Constructor will accept MainFrame and ShapeModel as parameters so it can
	 * enable/disable buttons on certain events
	 * 
	 * @param frame
	 * @param model
	 */
	public ShapeObserver(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;
	}

	/**
	 * Callback which gets called when some shape changed selected state, it will
	 * check if any shape is selected, if it is, it will enable/disable various
	 * buttons based on number of selected shapes
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == shape) {
			int foundCount = 0;
			for (Shape s : model.getShapesList()) {
				if (s != null && s.isSelected()) {
					foundCount++;
				}
			}
			int shapeCount = model.getShapesList().size();
			frame.getHeaderWrapperView().getToolboxView().getBtnDelete().setEnabled(foundCount > 0);
			frame.getHeaderWrapperView().getToolboxView().getBtnModify().setEnabled(foundCount == 1);
			frame.getAdditionalActionsView().getBtnBringToBack().setEnabled(foundCount == 1 && shapeCount > 1);
			frame.getAdditionalActionsView().getBtnBringToFront().setEnabled(foundCount == 1 && shapeCount > 1);
			frame.getAdditionalActionsView().getBtnToBack().setEnabled(foundCount == 1 && shapeCount > 1);
			frame.getAdditionalActionsView().getBtnToFront().setEnabled(foundCount == 1 && shapeCount > 1);
		}
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
