package chapter9.demo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class MyHandler implements EventHandler<ActionEvent> {
	private TextField nameTextField;

	public MyHandler(TextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public void handle(ActionEvent event) {
		System.out.println("Button clicked, Name = " + nameTextField.getText());
	}
}

public class EventHandling extends Application implements EventHandler<ActionEvent> {
	static private int counter = 0;

	private Button okButton;

	public static void main(String[] args) {
		launch();
	}

	public void handle(ActionEvent event) {
		if (event.getSource() == okButton) {
			System.out.println("Button clicked, Name = ?");
			System.out.println("it's your " + ++counter + ". click!");
		}
	}

	public void start(Stage stage) {
		stage.setTitle("Enter Name");
		FlowPane p = new FlowPane();
		Label nameLabel = new Label("Name");
		TextField nameTextField = new TextField();
		okButton = new Button("OK");
		p.getChildren().add(nameLabel);
		p.getChildren().add(nameTextField);
		p.getChildren().add(okButton);

		// Event handling for OK button
		//okButton.setOnAction(new OKButtonEventHandler(nameTextField));

		// or by using an anonymous class implementing the EventHandler interface:
		//okButton.setOnAction(this);
		
		okButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Button clicked, Name = " + nameTextField.getText());
				System.out.println("it's your " + ++counter + ". click!");
			}
		});
		
		// even shorter: Lambda Expression
		okButton.setOnAction(event -> {
			System.out.println("Button clicked, Name = " 
					+ nameTextField.getText());
		});

		Scene scene = new Scene(p, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

}
