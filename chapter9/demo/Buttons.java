package chapter9.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons extends Application {
	private TextArea protocolTextArea = new TextArea();

	private FlowPane initCheckBoxes() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");

		CheckBox cb1 = new CheckBox("Simple checkbox");
		CheckBox cb2 = new CheckBox("Three state checkbox");
		cb2.setAllowIndeterminate(true); // undefined als 3. Zustand einschalten
		cb2.setIndeterminate(false); // undefined := false
		cb2.setSelected(true);// // isSelected := true
		CheckBox cb3 = new CheckBox("Disabled");
		cb3.setSelected(true);
		cb3.setDisable(true);
		pane.getChildren().add(new Label("CheckBox: "));
		pane.getChildren().add(cb1);
		pane.getChildren().add(cb2);
		pane.getChildren().add(cb3);
		// Ereignisbehandlung als Lambda-Expression
		// Alternative mit Block => beliebig viele Anweisungen möglich!
		cb1.setOnAction(e -> {
			String text = protocolTextArea.getText();
			protocolTextArea.setText(cb1.getText() + ": selected=" + cb1.isSelected() +
					"\n" + text);
		});
		// Alternative ohne Block, nur eine Anweisung
		cb2.setOnAction(e -> protocolTextArea.setText(cb2.getText() + ": selected=" + cb2.isSelected() +
				", indeterminate=" + cb2.isIndeterminate() +
				"\n" + protocolTextArea.getText()));
		return pane;
	}

	private FlowPane initRadioButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightyellow");

		// Alle RadioButtons gehören logisch zusammen f�r eine
		// 1 aus N-Auswahl => ToggleGroup nutzen
		ToggleGroup tg = new ToggleGroup();
		RadioButton rb1 = new RadioButton("");
		RadioButton rb2 = new RadioButton("German");
		RadioButton rb3 = new RadioButton("not sure ...");

		rb1.setText("English");

		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb2.setSelected(true);
		rb3.setToggleGroup(tg);
		rb3.setSelected(false);
		rb3.setDisable(true);

		// Ereignisbehandlung
		rb1.setOnAction(event -> protocolTextArea.setText(
				rb1.getText() + ": " + rb1.isSelected() +
						"\n" + protocolTextArea.getText()));
		rb2.setOnAction(e -> protocolTextArea.setText(
				rb2.getText() + ": " + rb2.isSelected() +
						"\n" + protocolTextArea.getText()));

		pane.getChildren().add(new Label("RadioButton: "));
		pane.getChildren().add(rb1);
		pane.getChildren().add(rb2);
		pane.getChildren().add(rb3);

		return pane;
	}

	private FlowPane initButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightblue");

		Button button1 = new Button("OK!");
		button1.setStyle("-fx-color: red");
		Button button2 = new Button("Cancel");
		Button button3 = new Button("Save");
		button3.setDisable(true);

		pane.getChildren().add(new Label("Button: "));
		pane.getChildren().add(button1);
		pane.getChildren().add(button2);
		pane.getChildren().add(button3);

		// Ereignisbehandlung
		button1.setOnAction(e -> protocolTextArea.setText(
				button1.getText() + " clicked!" +
						"\n" + protocolTextArea.getText()));
		button2.setOnAction(e -> protocolTextArea.setText(
				button2.getText() + " clicked!" +
						"\n" + protocolTextArea.getText()));

		return pane;
	}

	private FlowPane initToggleButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // set horizontal distance
		// set background color using CSS style
		pane.setStyle("-fx-background-color: lightgreen");

		ToggleButton tb1 = new ToggleButton("White");
		ToggleButton tb2 = new ToggleButton("Black");
		ToggleButton tb3 = new ToggleButton("Colorful!");
		ToggleGroup tg = new ToggleGroup();
		tb1.setToggleGroup(tg);
		tb2.setToggleGroup(tg);
		tb3.setToggleGroup(tg);
		tb1.setSelected(true);
		tb1.setOnAction(e -> protocolTextArea.setText(tb1.getText() + ": " + tb1.isSelected() +
				"\n" + protocolTextArea.getText()));
		tb2.setOnAction(e -> protocolTextArea.setText(tb2.getText() + ": " + tb2.isSelected() +
				"\n" + protocolTextArea.getText()));
		tb3.setOnAction(e -> protocolTextArea.setText(tb3.getText() + ": " + tb3.isSelected() +
				"\n" + protocolTextArea.getText()));

		pane.getChildren().addAll(new Label("ToggleButton: "), tb1, tb2, tb3);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(10);
		Pane checkBoxPane = initCheckBoxes();
		Pane radioButtonsPane = initRadioButtons();
		Pane buttonsPane = initButtons();
		Pane toggleButtonsPane = initToggleButtons();

		verticalBox.getChildren().add(checkBoxPane);
		verticalBox.getChildren().add(radioButtonsPane);
		verticalBox.getChildren().add(buttonsPane);
		verticalBox.getChildren().add(toggleButtonsPane);

		VBox.setMargin(checkBoxPane, new Insets(10, 20, 10, 20));
		VBox.setMargin(radioButtonsPane, new Insets(10, 20, 10, 20));
		VBox.setMargin(buttonsPane, new Insets(10, 20, 10, 20));
		VBox.setMargin(toggleButtonsPane, new Insets(10, 20, 10, 20));

		verticalBox.getChildren().add(protocolTextArea);
		protocolTextArea.setText("just click on a button!");
		primaryStage.setTitle("Button-Demo");
		primaryStage.setScene(new Scene(verticalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
