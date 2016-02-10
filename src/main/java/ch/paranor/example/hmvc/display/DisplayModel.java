package ch.paranor.example.hmvc.display;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

class DisplayModel {
	private final DoubleProperty value = new SimpleDoubleProperty();

	public DoubleProperty getValue() {
		return value;
	}
}
