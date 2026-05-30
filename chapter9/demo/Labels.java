package chapter9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Labels extends Application {
	private TextArea protocolTextArea = new TextArea();

	private FlowPane initLabels() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: yellow");

		Label label1 = new Label("Simple hover over me with your mouse!");
		// Event type: Mouse entered
		label1.setOnMouseEntered(e -> protocolTextArea.setText(
				"Mouse event for " + label1.getText() + "\n"
						+ protocolTextArea.getText()));

		Label label2 = new Label("Label 2 (style: bold)");
		label2.setFont(Font.font("Arial", FontWeight.BOLD, 12));

		// Klick-Handler
		label2.setOnMouseClicked(e -> {
			if (label2.getText().equals("clicked!")) {
				label2.setText("Label 2 (style: bold)");
			} else {
				label2.setText("clicked!");
			}
			protocolTextArea.setText("Mouse click for " + label2.getText() +
					"\n" + protocolTextArea.getText());
		});

		pane.getChildren().addAll(new Label("Labels: "), label1, label2);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(10);
		verticalBox.getChildren().add(initLabels());
		verticalBox.getChildren().add(protocolTextArea);
		protocolTextArea.setText("hover over label 1 or click on label 2!");
		primaryStage.setTitle("Label-Demo");
		primaryStage.setScene(new Scene(verticalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
