package chapter9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Texts extends Application {
	private TextArea protocolTextArea = new TextArea();

	private FlowPane initText() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // set horizontal distance
		// set background color using CSS syntax
		pane.setStyle("-fx-background-color: lightgrey");

		TextField text1 = new TextField("(1) click here (2) press enter");
		text1.setPrefSize(200, 12);
		text1.setStyle("-fx-background-color: yellow , white, red;");

		text1.setOnMouseClicked(e -> protocolTextArea.setText("Mouse alarm for Text1: text = " +
				text1.getText() + "\n" + protocolTextArea.getText()));
		// Enter-Handler
		text1.setOnAction(e -> protocolTextArea.setText("Enter key for Text1: text = " +
				text1.getText() + "\n" + protocolTextArea.getText()));
		TextField text2 = new TextField();
		text2.setPromptText("enter name");

		pane.getChildren().addAll(new Label("Texts: "), text1, text2);
		return pane;
	}

	private FlowPane initTextArea() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20);
		pane.setStyle("-fx-background-color: lightyellow");

		TextArea textArea = new TextArea("Some initial text...\nline 2");
		Button printButton = new Button("copy textarea content to protocol window");
		printButton.setOnAction(e -> protocolTextArea.setText(
				textArea.getText() + "\n" + protocolTextArea.getText()));
		pane.getChildren().addAll(new Label("TextArea: "), textArea, printButton);
		return pane;
	}

	private FlowPane initPasswordField() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20);
		pane.setStyle("-fx-background-color: lightgreen");

		PasswordField passwordField = new PasswordField();
		passwordField.setText("Hugo");
		passwordField.setPromptText("password");
		Button printButton = new Button("copy password to protocol window");
		printButton.setOnAction(e -> protocolTextArea.setText(
				passwordField.getText() + "\n" + protocolTextArea.getText()));
		pane.getChildren().addAll(new Label("Password: "), passwordField, printButton);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(10);
		verticalBox.getChildren().add(initText());
		verticalBox.getChildren().add(initTextArea());
		verticalBox.getChildren().add(initPasswordField());
		verticalBox.getChildren().add(protocolTextArea);
		primaryStage.setTitle("Text Demo");
		primaryStage.setScene(new Scene(verticalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
