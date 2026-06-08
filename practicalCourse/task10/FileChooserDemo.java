package practicalCourse.task10;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserDemo extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File selectedFile = fileChooser.showOpenDialog(stage);

		System.out.println("File: " + selectedFile);
		Platform.exit();
	}

}
