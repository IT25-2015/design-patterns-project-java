package shapes;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import app.App;
import app.MainFrame;
import model.ShapeModel;

public class ShapeObserver implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 276904460662545054L;
	private ShapeModel model = App.getModel();
	private MainFrame frame = App.getFrame();
	private Shape shape;

	/**
	 * Callback which gets called when some shape changed selected state Will check
	 * if any shape is selected, if it is, it will enable delete button
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == shape) {
			int foundCount = 0;
			for (Shape s : model.getShapesList()) {
				if (s.isSelected()) {
					foundCount++;
				}
			}
			frame.getHeaderWrapperView().getToolboxView().getBtnDelete().setEnabled(foundCount > 0);
			frame.getHeaderWrapperView().getToolboxView().getBtnModify().setEnabled(foundCount == 1);
		}
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}