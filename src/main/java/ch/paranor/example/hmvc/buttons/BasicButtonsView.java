package ch.paranor.example.hmvc.buttons;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class BasicButtonsView {
	private final List<Button> digits = new ArrayList<>();
	private final Button clear;
	private final Button plus;
	private final Button minus;
	private final Button multiply;
	private final Button divide;
	private final Button equal;

	private final GridPane layout;

	public BasicButtonsView() {
		layout = new GridPane();
		layout.setStyle("-fx-vgap: 5; -fx-hgap: 5;");
		for (int i = 0; i < 10; i++) {
			Button button = new Button(String.valueOf(i));
			button.setStyle("-fx-base: lightgray;");
			digits.add(button);

		}
		clear = new Button("C");
		plus = new Button("+");
		minus = new Button("-");
		multiply = new Button("*");
		divide = new Button("/");
		equal = new Button("=");
		equal.setStyle("-fx-base: lightblue;");
		layout();
	}

	private void layout() {
		add(digits.get(7), 0, 0);
		add(digits.get(8), 1, 0);
		add(digits.get(9), 2, 0);
		add(divide, 3, 0);
		add(digits.get(4), 0, 1);
		add(digits.get(5), 1, 1);
		add(digits.get(6), 2, 1);
		add(multiply, 3, 1);
		add(digits.get(1), 0, 2);
		add(digits.get(2), 1, 2);
		add(digits.get(3), 2, 2);
		add(minus, 3, 2);
		add(digits.get(0), 0, 3);
		add(clear, 1, 3);
		add(equal, 2, 3);
		add(plus, 3, 3);
	}

	private void add(Button button, int col, int row) {
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMaxWidth(Double.MAX_VALUE);
		layout.add(button, col, row);
		GridPane.setHgrow(button, Priority.ALWAYS);
	}

	public Region getNode() {
		return layout;
	}

	public void setDigitHandler(int digit, EventHandler<ActionEvent> handler) {
		digits.get(digit).setOnAction(handler);
	}

	public void setClearHandler(EventHandler<ActionEvent> handler) {
		clear.setOnAction(handler);
	}

	public void setPlusHandler(EventHandler<ActionEvent> handler) {
		plus.setOnAction(handler);
	}

	public void setMinusHandler(EventHandler<ActionEvent> handler) {
		minus.setOnAction(handler);
	}

	public void setMultiplyHandler(EventHandler<ActionEvent> handler) {
		multiply.setOnAction(handler);
	}

	public void setDivideHandler(EventHandler<ActionEvent> handler) {
		divide.setOnAction(handler);
	}

	public void setEqualHandler(EventHandler<ActionEvent> handler) {
		equal.setOnAction(handler);
	}
}
