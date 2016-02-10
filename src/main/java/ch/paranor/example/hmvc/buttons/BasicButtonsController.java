package ch.paranor.example.hmvc.buttons;

import com.google.common.eventbus.EventBus;

import ch.paranor.example.hmvc.ValueChanged;
import ch.paranor.example.hmvc.buttons.BasicButtonsModel.Op;
import javafx.scene.layout.Region;

public class BasicButtonsController {
	private final BasicButtonsView view;
	private final BasicButtonsModel model;
	private final EventBus eventBus;

	public BasicButtonsController(EventBus eventBus) {
		this.eventBus = eventBus;
		view = new BasicButtonsView();
		model = new BasicButtonsModel();
		init();
	}

	private void init() {
		for (int i = 0; i < 10; i++) {
			final int digit = i;
			view.setDigitHandler(i, (e) -> model.typeDigit(digit));
		}
		view.setClearHandler((e) -> model.clear());
		view.setEqualHandler((e) -> model.calculate());
		view.setPlusHandler((e) -> model.apply(Op.PLUS));
		view.setMinusHandler((e) -> model.apply(Op.MINUS));
		view.setMultiplyHandler((e) -> model.apply(Op.MULTIPLY));
		view.setDivideHandler((e) -> model.apply(Op.DIVIDE));
		model.getValue().addListener((observable, oldValue, newValue) -> eventBus.post(new ValueChanged(newValue.doubleValue())));
	}

	public Region getView() {
		return view.getNode();
	}

	public void reset() {
		model.clear();
		eventBus.post(new ValueChanged(model.getValue().doubleValue()));
	}

}
