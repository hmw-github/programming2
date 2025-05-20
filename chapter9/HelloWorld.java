package programming2.chapter9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public void init( ) {
		System.out.println("init called...");
	}
	
	public void start(Stage window) {
		window.setTitle("Say hello!");
		
		// create pane
		FlowPane pane = new FlowPane();
		// create controls
		TextField nameTextField = new TextField();
		Button sayHelloButton = new Button("greet");
		
		// layout it
		pane.getChildren().addAll(new Label("Name: "), nameTextField, sayHelloButton);
		
		// handle button click event
		sayHelloButton.setOnAction(event -> {
			String name = nameTextField.getText();
			System.out.println("Hello " + name + "!");
		});
		
		// show dialog in a scene
		Scene scene = new Scene(pane, 300, 50);
		window.setScene(scene);
		window.show();
	}
	
	public void stop() {
		System.out.println("Goodbye!");
	}
	
	public static void main(String[] args) {
		launch(); // pass control to framework!
	}

}
