package chapter9.demo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Person {
	protected String name;
	private int nr;

	public Person(String name, int nr) {
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
		return "Person [name=" + name + ", nr=" + nr + "]";
	}
}

public class Lists extends Application {
	private TextArea protokollTextArea = new TextArea();

	@SuppressWarnings("rawtypes")
	private Node initListPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20);
		pane.setStyle("-fx-background-color: lightgrey");

		List<Person> liste = new ArrayList<Person>();
		ObservableList<Person> observableList = FXCollections.observableList(liste);

		observableList.addListener(new ListChangeListener() {
			public void onChanged(Change c) {
				System.out.println(c);
			}
		});

		for (int i = 0; i < 1000; ++i)
			observableList.add(new Person("Person " + i, i));

		ListView<Person> listView = new ListView<Person>();
		listView.setItems(observableList);

		// setzte Mehrfachauswahl
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		listView.setOnMouseClicked(e -> protokollTextArea.setText("Selection: "
				+ listView.getSelectionModel().getSelectedItems()
				+ "\n" + protokollTextArea.getText()));

		pane.getChildren().addAll(new Label("ListView: "), listView);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		primaryStage.setTitle("ListView-Demo");
		vertikalBox.getChildren().addAll(initListPane(), protokollTextArea);
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
