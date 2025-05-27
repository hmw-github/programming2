package programming2.chapter9;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginDialog extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		Map<String, String> users = new HashMap<>();
		
		users.put("Rajesh", "123");
		users.put("Anna", "456");
		
		window.setTitle("Login");
		
		// create panes & controls
		VBox vbox = new VBox();
		GridPane grid = new GridPane();
		TextField usernameTextField = new TextField();
		PasswordField passwordField = new PasswordField();
		Label messageLabel = new Label("Enter your credentials!");
		Button loginButton = new Button("login");
		
		// populate panes with controls
		vbox.getChildren().addAll(grid, loginButton);
		grid.add(new Label("Username"), 0, 0);
		grid.add(usernameTextField, 1, 0);
		grid.add(new Label("Password"), 0, 1);
		grid.add(passwordField, 1, 1);
		grid.add(messageLabel, 1, 2);
		
		// add event handlers
		loginButton.setOnAction(event -> {
			String username = usernameTextField.getText();
			String password = passwordField.getText();
			
			String pwd = users.get(username);
			
			if (pwd != null && pwd.equals(password)) {
				messageLabel.setText("Hooray!");
				messageLabel.setStyle("-fx-text-fill: green");
			} else {
				messageLabel.setText("Wrong credentials, try again!");				
				messageLabel.setStyle("-fx-text-fill: red");
			}
		});
		
		// styling
		loginButton.setPrefWidth(280);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(5);
		grid.setVgap(10);
		vbox.setSpacing(10);
		
		Scene scene = new Scene(vbox, 300, 135);
		window.setScene(scene);
		window.show();
	}
	
	

}
