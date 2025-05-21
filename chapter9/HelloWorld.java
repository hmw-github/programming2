package programming2.chapter9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class ButtonHandler implements EventHandler<ActionEvent> {
	private TextField nameTextField;
	
	public ButtonHandler(TextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	
	public void handle(ActionEvent event) {
		String name = nameTextField.getText();
		System.out.println("Var 2: Hello " + name + "!");
	}	
}

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

		Button exitButton = new Button("exit");
		
		// layout it
		pane.getChildren().addAll(new Label("Name: "), nameTextField, sayHelloButton, exitButton);
		
		// styling: make flowpane bavckground yellow
		pane.setStyle("-fx-background-color: yellow");
		
		// handle button click event
		sayHelloButton.setOnAction(event -> {
			String name = nameTextField.getText();
			System.out.println("Var 1: Hello " + name + "!");
		});
		
		// 2. variant using handler class => lots of boiler plate code!
		sayHelloButton.setOnAction(new ButtonHandler(nameTextField));
		
		// 3. variant using anonymous class
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				String name = nameTextField.getText();
				System.out.println("Var 3: Hello " + name + "!");
			}
		};
		sayHelloButton.setOnAction(handler);
		
		// define scene 2
		Button hiButton = new Button("Hi!");
		Scene scene2 = new Scene(hiButton);
		//exitButton.setOnAction(e -> window.setScene(scene2));
		exitButton.setOnAction(e -> window.hide());
		
		// show dialog in a scene
		Scene scene = new Scene(pane, 300, 50);
		window.setScene(scene);
		window.setResizable(true);
		window.show();
	}
	
	public void stop() {
		System.out.println("Goodbye!");
	}
	
	public static void main(String[] args) {
		launch(); // pass control to framework!
	}

}
