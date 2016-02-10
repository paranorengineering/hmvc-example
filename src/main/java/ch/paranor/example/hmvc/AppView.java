package ch.paranor.example.hmvc;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

class AppView {
	private final VBox layout = new VBox();
	private final BorderPane displayContainer = new BorderPane();
	private final BorderPane buttonsContainer = new BorderPane();
	private final ComboBox<String> combobox;

	public AppView() {
		combobox = new ComboBox<>();
		layout.setStyle("-fx-spacing: 20; -fx-padding: 20; -fx-font-size: 20; -fx-alignment: center;");
		layout.getChildren().add(combobox);
		layout.getChildren().add(displayContainer);
		layout.getChildren().add(buttonsContainer);
	}

	public void setDisplay(Region node) {
		displayContainer.setCenter(node);
	}

	public void setButtons(Region node) {
		buttonsContainer.setCenter(node);
	}

	public ObjectProperty<ObservableList<String>> getItems() {
		return combobox.itemsProperty();
	}

	public ObjectProperty<String> getValue() {
		return combobox.valueProperty();
	}

	public Scene createScene() {
		return new Scene(layout);
	}
}
