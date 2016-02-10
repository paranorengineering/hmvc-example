package ch.paranor.example.hmvc.buttons;

import com.google.common.eventbus.EventBus;

import ch.paranor.example.hmvc.ValueChanged;
import javafx.scene.layout.Region;

public class AdvancedButtonsController {
	private final AdvancedButtonsView view;
	private final AdvancedButtonsModel model;
	private final EventBus eventBus;

	public AdvancedButtonsController(EventBus eventBus) {
		this.eventBus = eventBus;
		view = new AdvancedButtonsView();
		model = new AdvancedButtonsModel();
		init();
	}

	private void init() {
		// TODO set button handlers
	}

	public Region getView() {
		return view.getNode();
	}

	public void reset() {
		model.clear();
		eventBus.post(new ValueChanged(model.getValue().doubleValue()));
	}

}
