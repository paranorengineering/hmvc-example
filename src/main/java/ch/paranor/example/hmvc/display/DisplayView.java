package ch.paranor.example.hmvc.display;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

class DisplayView {

	private final TextField value;

	public DisplayView() {
		value = new TextField();
		value.setEditable(false);
	}

	public StringProperty getValue() {
		return value.textProperty();
	}

	public Region getNode() {
		return value;
	}
}
