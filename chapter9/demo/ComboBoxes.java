package chapter9.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Student {
	private String name;
	private int nr;

	public Student(String name, int nr) {
		this.name = name;
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public int getNr() {
		return nr;
	}

	@Override
	public String toString() {
		return "Student: Name =" + name + ", nr=" + nr + "]";
	}
}

public class ComboBoxes extends Application {
	private TextArea protocolTextArea = new TextArea();

	private Node initComboBoxPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // set horizontal padding
		// set background color using CSS syntax
		pane.setStyle("-fx-background-color: lightgrey");

		ObservableList<Student> students = FXCollections.observableArrayList();
		for (int i = 1; i <= 1000; ++i)
			students.add(new Student("Student " + i, i));

		ComboBox<Student> cb = new ComboBox<Student>(students);

		cb.setOnAction(e -> protocolTextArea.setText("ComboBox selection: "
				+ cb.getSelectionModel().getSelectedItem()
				+ "\n" + protocolTextArea.getText()));

		cb.getSelectionModel().select(4);

		pane.getChildren().addAll(new Label("ComboBox: "), cb);
		return pane;
	}

	private Node initChoiceBoxPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // set horizontal padding
		// set background color using CSS syntax
		pane.setStyle("-fx-background-color: lightgreen");

		ObservableList<Student> students = FXCollections.observableArrayList();
		students.addAll(
				new Student("Paula", 1), new Student("Ishana", 2),
				new Student("Dilara", 3), new Student("Franz", 4),
				new Student("Aarush", 5), new Student("Bhavin", 6));
		ChoiceBox<Student> cb = new ChoiceBox<Student>(students);
		cb.setOnAction(e -> protocolTextArea.setText("ChoiceBox selection: " +
				cb.getSelectionModel().getSelectedItem() + "\n"
				+ protocolTextArea.getText()));

		pane.getChildren().addAll(new Label("ChoiceBox: "), cb);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(10); // set distance between vbox elements
		primaryStage.setTitle("ComoboBox-Demo");
		verticalBox.getChildren().addAll(initChoiceBoxPane(), initComboBoxPane(),
				protocolTextArea);
		primaryStage.setScene(new Scene(verticalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
