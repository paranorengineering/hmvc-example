package ch.paranor.example.hmvc.display;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import ch.paranor.example.hmvc.ValueChanged;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.Region;

public class DisplayController {

	private final DisplayView view;
	private final DisplayModel model;

	public DisplayController(EventBus eventBus) {
		view = new DisplayView();
		model = new DisplayModel();
		init(eventBus);
	}

	private void init(EventBus eventBus) {
		view.getValue().bind(Bindings.format("%.0f", model.getValue()));
		eventBus.register(this);
	}

	@Subscribe
	public void handle(ValueChanged event) {
		model.getValue().set(event.getValue());
	}

	public Region getView() {
		return view.getNode();
	}
}
