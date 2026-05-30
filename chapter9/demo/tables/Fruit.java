package chapter9.demo.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A fruit object has a name, a colour, a weight in grams and an age.
 * Each attribute is implemented as a T-property, T = String | Integer.
 * 
 * A property contains the value and offers getters/setters as well
 * as the option of connecting listener objects.
 * Listeners are objects that are to be informed when the property value
 * changes.
 * 
 * This way it is very easy to keep in touch with changes to a ListView or a
 * TableView.
 */
public class Fruit {
	private StringProperty name;
	private StringProperty colour;
	private IntegerProperty weight;
	private IntegerProperty age;

	public Fruit(String nameInit, String colourInit, int weightInit, int ageInit) {
		name = new SimpleStringProperty(this, "name");
		setName(nameInit);
		colour = new SimpleStringProperty(this, "colour");
		setColour(colourInit);
		weight = new SimpleIntegerProperty(this, "weight");
		setWeight(weightInit);
		age = new SimpleIntegerProperty(this, "age");
		setAge(ageInit);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public StringProperty colourProperty() {
		return colour;
	}

	public IntegerProperty weightProperty() {
		return weight;
	}

	public IntegerProperty ageProperty() {
		return age;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String value) {
		this.name.set(value);
	}

	public String getColour() {
		return colour.get();
	}

	public void setColour(String value) {
		this.colour.set(value);
	}

	public int getWeight() {
		return weight.get();
	}

	public void setWeight(int value) {
		this.weight.set(value);
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int value) {
		this.age.set(value);
	}

	public String toString() {
		return "name=" + name.get() +
				", colour=" + colour.get() +
				", weight=" + weight.get() + " gr." +
				", age= " + age.get();
	}
}