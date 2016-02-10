package ch.paranor.example.hmvc.buttons;

import java.util.Optional;
import java.util.function.DoubleBinaryOperator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

class AdvancedButtonsModel {

	public enum Op {
		PLUS((left, right) -> left + right);
		// TODO add other operations

		private final DoubleBinaryOperator op;

		private Op(DoubleBinaryOperator op) {
			this.op = op;

		}

		public double calculate(double left, double right) {
			return op.applyAsDouble(left, right);
		}
	}

	private Optional<Op> currentOp = Optional.empty();
	private final DoubleProperty stack = new SimpleDoubleProperty();
	private final DoubleProperty value = new SimpleDoubleProperty();

	public void apply(Op op) {
		currentOp = Optional.of(op);
		stack.set(value.get());
		value.set(0);
	}

	public void typeDigit(int digit) {
		value.set(value.get() * 10 + digit);
	}


	public void calculate() {
		if (currentOp.isPresent()) {
			value.set(currentOp.get().calculate(stack.get(), value.get()));
			currentOp = Optional.empty();
			stack.set(0);
		}
	}

	public void clear() {
		currentOp = Optional.empty();
		value.set(0);
		stack.set(0);
	}

	public DoubleProperty getValue() {
		return value;
	}
}
