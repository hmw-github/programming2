package chapter9.demo.tables;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Tables extends Application {
	private TextArea protocolTextArea = new TextArea();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Node initTabellenPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20);
		pane.setStyle("-fx-background-color: lightgrey");

		/*
		 * Create data and listen to age changes
		 */
		ObservableList<Fruit> fruitList = FXCollections.observableArrayList();
		fruitList.add(new Fruit("Pear", "yellow", 150, 0));
		fruitList.add(new Fruit("Apple", "green", 100, 2));
		fruitList.add(new Fruit("Cherry", "red", 2, 4));

		ChangeListener ageChangeListener = (value, before, after) -> {
			System.out.println("Detected a change! " + value + ", before: " + before + ", after: " + after);
		};

		// Listen to age changes on every object
		for (Fruit f : fruitList) {
			f.ageProperty().addListener(ageChangeListener);
		}

		/*
		 * create TableView and set data items
		 */
		TableView<Fruit> tableView = new TableView<>(fruitList);

		/*
		 * define columns and set in tableView
		 */
		TableColumn nameColumn = new TableColumn("Name");
		// fruit.getName() -> String
		nameColumn.setCellValueFactory(
				new PropertyValueFactory<Fruit, String>("name"));

		TableColumn colourColumn = new TableColumn("Colour");
		// fruit.getColour() -> String
		colourColumn.setCellValueFactory(
				new PropertyValueFactory<Fruit, String>("colour"));

		TableColumn weightColumn = new TableColumn("Weight[gr]");
		// fruit.getWeight() -> Integer
		weightColumn.setCellValueFactory(
				new PropertyValueFactory<Fruit, Integer>("weight"));

		TableColumn ageColumn = new TableColumn("Age[days]");
		// fruit.getAge() -> Integer
		ageColumn.setCellValueFactory(
				new PropertyValueFactory<Fruit, Integer>("age"));
		tableView.getColumns().addAll(nameColumn, colourColumn, weightColumn, ageColumn);

		/*
		 * Make the table editable
		 * 1. set "editable" to true
		 * 2. set CellFactory for every editable column. Each CellFactory performs
		 * the necessary conversion from model attribute value to string and back
		 * For attributes of type String (e.g. nameColumn) we use a predefined
		 * converter,
		 * otherwise we define our own converter.
		 */
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		colourColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		weightColumn.setCellFactory(TextFieldTableCell.forTableColumn(
				new StringConverter<Integer>() {
					public Integer fromString(String s) {
						// convert cell value from String to Integer
						return Integer.parseInt(s);
					}

					public String toString(Integer i) {
						// convert integer value to string value for display in cell
						return "" + i;
					}
				}));
		ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(
				new StringConverter<Integer>() {
					public Integer fromString(String s) {
						return Integer.parseInt(s);
					}

					public String toString(Integer i) {
						return "" + i;
					}
				}));

		tableView.setEditable(true);

		/*
		 * Allow selection of multiple rows an set row selection handler
		 */
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setOnMouseClicked(e -> {
			protocolTextArea.setText(tableView.getSelectionModel().getSelectedItems()
					+ "\n" + protocolTextArea.getText());
		});

		pane.getChildren().addAll(new Label("TableView: "), tableView);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		primaryStage.setTitle("Table Demo");
		vertikalBox.getChildren().addAll(initTabellenPane(), protocolTextArea);
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
