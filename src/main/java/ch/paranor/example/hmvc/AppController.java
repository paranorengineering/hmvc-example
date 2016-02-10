package ch.paranor.example.hmvc;

import com.google.common.eventbus.EventBus;

import ch.paranor.example.hmvc.buttons.AdvancedButtonsController;
import ch.paranor.example.hmvc.buttons.BasicButtonsController;
import ch.paranor.example.hmvc.display.DisplayController;
import javafx.stage.Stage;

public class AppController {
	private final AppModel model = new AppModel();
	private final AppView view = new AppView();

	public AppController() {
		init();
	}

	private void init() {
		EventBus eventBus = new EventBus();
		DisplayController display = new DisplayController(eventBus);
		BasicButtonsController basicButtons = new BasicButtonsController(eventBus);
		AdvancedButtonsController advancedButtons = new AdvancedButtonsController(eventBus);
		view.setDisplay(display.getView());
		view.getItems().get().addAll("Basic", "Advanced");
		view.getValue().bindBidirectional(model.getType());
		model.getType().addListener((v, o, n) -> {
			if (n.equals("Basic")) {
				view.setButtons(basicButtons.getView());
				basicButtons.reset();
			} else {
				view.setButtons(advancedButtons.getView());
				advancedButtons.reset();
			}
		});
		model.getType().set("Basic");
	}

	public void start(Stage primaryStage) {
		primaryStage.setScene(view.createScene());
		primaryStage.show();
	}

}
