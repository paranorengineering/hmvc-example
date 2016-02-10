package ch.paranor.example.hmvc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class AppModel {
	private final StringProperty type = new SimpleStringProperty();

	public StringProperty getType() {
		return type;
	}
}
