package chapter9.tablemanager.ui;

import java.util.ArrayList;

import chapter9.tablemanager.model.Article;
import chapter9.tablemanager.model.Reservation;
import chapter9.tablemanager.model.Table;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableManager2 extends Application {
	/**
	 * model data
	 */
	private ArrayList<Table> tables;
	private ArrayList<Article> articles;
	// current is the current table; it may be null (= no table selected)
	private Table currentTable;

	/**
	 * Controls
	 */
	private Label tableLabel;
	private ListView<Reservation> reservationsListView;
	private ListView<String> ordersListView;
	private ChoiceBox<Article> selectArticleChoiceBox;
	private Button addArticleButton;
	private TextField dateTextField;
	private TextField nameTextField;
	private Button addReservationButton;

	/**
	 * Called by JavaFX life cycle before start() Used here to initialize model
	 * data: - define tables - add some reservations - add some articles - add some
	 * articles to bill for table #1
	 */
	public void init() throws Exception {
		tables = new ArrayList<>();
		articles = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			tables.add(new Table(i + 1));
		}

		tables.get(0).addReservation(new Reservation("10:00", "Maier family"));
		tables.get(0).addReservation(new Reservation("20:00", "Paula"));
		tables.get(1).addReservation(new Reservation("20:00", "Rajesh"));

		articles.add(new Article("Pizza Diavolo", 12.99));
		articles.add(new Article("Pizza Margherita", 9.99));
		articles.add(new Article("Spagetthi Carbonara", 8.99));
		articles.add(new Article("Lasagne Bolognese", 9.99));
		articles.add(new Article("Rotwein Chianti 0,75l", 14.99));
		articles.add(new Article("Gemischter Salat", 4.99));

		tables.get(0).addToBill(articles.get(0));
		tables.get(0).addToBill(articles.get(0));
		tables.get(0).addToBill(articles.get(5));
	}

	/**
	 * JavaFX start method: fill primary application window
	 * with panes and controls, set event handlers
	 */
	public void start(Stage primaryStage) throws Exception {
		/**
		 * Cookbook: 1. Create dialog scetch (if not given) 
		 * 2. Define panes and controls derived from scetch 
		 * 		- fill panes with controls 
		 * 3. Define event handlers
		 */

		/**
		 *  Create controls
		 */

		tableLabel = new Label("Table: n/a");
		reservationsListView = new ListView();
		ordersListView = new ListView();
		selectArticleChoiceBox = new ChoiceBox();
		selectArticleChoiceBox.getItems().addAll(articles);
		addArticleButton = new Button("Add Article");
		dateTextField = new TextField();
		dateTextField.setPromptText("enter time...");
		nameTextField = new TextField();
		nameTextField.setPromptText("enter name...");
		addReservationButton = new Button("Add reservation");

		/**
		 *  Configure layout
		 */

		BorderPane main = new BorderPane();
		FlowPane leftPane = new FlowPane();
		VBox rightPane = new VBox();
		HBox addReservationForm = new HBox();
		HBox addArticleForm = new HBox();
		
		main.setLeft(leftPane);
		main.setRight(rightPane);
		
		rightPane.getChildren().addAll(tableLabel, reservationsListView,
				addReservationForm, ordersListView, addArticleForm);
		
		addReservationForm.getChildren().addAll(
				dateTextField, nameTextField, addReservationButton);
		
		addArticleForm.getChildren().addAll(selectArticleChoiceBox, addArticleButton);
		
		/**
		 *  Event handlers for forms: addReservationButton, addArticleButton
		 */
		addReservationButton.setOnAction(event -> handleOnClickAddReservation());
		addArticleButton.setOnAction(event -> handleOnClickAddArticle());
		
		/**
		 *  Create table buttons and set event handlers
		 */
		for (Table t : tables) {
			Button tableButton = new Button("Table #" + t.getNr());
			leftPane.getChildren().add(tableButton);
			tableButton.setOnAction(event -> handleOnClickTable(t));
		}

		// Scene and Stage
		Scene scene = new Scene(main, 850, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

		/**
		 *  refreshUi: 
		 *  General purpose method to refresh controls 
		 *  depending on current table 
		 */
		refreshUi();
	}

	/**
	 * Handler for "add article" button: if currentTable is defined
	 * - get selected article
	 * - add it to the bill for the current table
	 * - refresh UI
	 */
	private void handleOnClickAddArticle() {
		Article selected = selectArticleChoiceBox.getSelectionModel().getSelectedItem();
		currentTable.addToBill(selected);
		refreshUi();
	}

	/**
	 * Handler for "add reservation" button: if current table is defined
	 * - get text input from name and date text fields
	 * - create new reservation and add it to current table
	 * - refresh UI
	 * - reset text fields
	 */
	private void handleOnClickAddReservation() {
		String name = nameTextField.getText();
		String date = dateTextField.getText();
		Reservation newReservation = new Reservation(date, name);
		currentTable.addReservation(newReservation);
		refreshUi();
		nameTextField.setText("");
		dateTextField.setText("");
	}

	/**
	 * Handler for table click:
	 * - if current table is not defined or not equals to t, set it to t
	 * - if current table is defined, clear it
	 * - refresh UI 
	 * 
	 * @param t table corresponding to clicked button
	 */
	private void handleOnClickTable(Table t) {
		if (currentTable == null || currentTable != t) {
			currentTable = t;
		} else {
			currentTable = null;
		}
		refreshUi();
	}

	/**
	 * Setup method for dialog controls depending on current table value.
	 * If current table is not defined
	 * - clear table label, reservation and orders list views
	 * - disable name and date fields, article selection and add buttons
	 * 
	 * If current table is defined
	 * - set table label
	 * - set items for reservations list view
	 * - set items for orders list view
	 * - enable name and date fields, article selection and add buttons
	 */
	private void refreshUi() {
		if (currentTable == null) {
			tableLabel.setText("Table: n/a");
			reservationsListView.getItems().clear();
			ordersListView.getItems().clear();
			nameTextField.setDisable(true);
			dateTextField.setDisable(true);
			selectArticleChoiceBox.setDisable(true);
			addArticleButton.setDisable(true);
			addReservationButton.setDisable(true);
		} else {
			tableLabel.setText("Table: #" + currentTable.getNr());
			reservationsListView.getItems().clear();
			for (Reservation r : currentTable.reservations()) {
				reservationsListView.getItems().add(r);
			}
	
			ordersListView.getItems().clear();
			for (Article a : currentTable.articlesOnBill()) {
				String s = String.format("%s %.2f € %d", 
						a.getName(), a.getPrice(), 
						currentTable.getArticleCount(a));
				ordersListView.getItems().add(s);
			}
			
			nameTextField.setDisable(false);
			dateTextField.setDisable(false);
			selectArticleChoiceBox.setDisable(false);
			addArticleButton.setDisable(false);
			addReservationButton.setDisable(false);			
		}
	}
}