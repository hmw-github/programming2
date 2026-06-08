package practicalCourse.task10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class TitledPaneDemo extends Application {

	public void start(Stage stage) {
		TitledPane tp = new TitledPane();
		//applying methods
		tp.setText("My Titled Pane");
		tp.setContent(new Button("Button"));
		
		Scene scene = new Scene(tp);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
