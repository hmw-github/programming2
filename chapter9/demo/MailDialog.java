package chapter9.demo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * JavaFX Demo Application demonstrating the use of Controls, Layout and Styling
 * 
 * Guide:
 * - main() starts the application calling launch(), which in turn calls start()
 * - start() builds the dialog based on a BorderLayout by calling
 * initTopPane(), initMessagePane(), initBottomPane()
 * - The auxiliary methods initList(), initFromChoiceBox(), initCheckBoxes() and
 * initRadioButtons() encapsulate the creation and assignment of the controls of
 * the same name
 * 
 * @author H.-M. Windisch
 *
 */
public class MailDialog extends Application {
	private boolean showLayout = true; // true: show layout

	/*
	 * Attributes
	 */

	private ChoiceBox<String> fromChoiceBox;
	private TextField toTextField, subjectTextField;
	private ObservableList<String> addressSelection;
	private TextArea messageTextArea;
	private RadioButton htmlRadioButton, textRadioButton;
	private CheckBox encryptedCheckBox, signedCheckBox, withSignatureCheckBox;

	/**
	 * Creates and initialises the ListView for the address selection in the
	 * selection dialog.
	 * 
	 * @return created ListView instance
	 */
	private ListView<String> initList() {
		List<String> list = new ArrayList<>();
		ObservableList<String> observableList = FXCollections.observableList(list);
		for (int i = 0; i < 100; ++i)
			list.add("someone" + i + "@email.de");
		ListView<String> listView = new ListView<>(observableList);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		return listView;
	}

	/**
	 * Creates and initialises the selection dialog
	 * 
	 * @param stage1 main window
	 */
	private void initSelectionDialog(Stage stage1) {
		// is used later, indicates whether anything has been selected at all
		addressSelection = null;

		// create subdialog
		Stage stage2 = new Stage();
		stage2.setTitle("Select email addresses");
		stage2.initOwner(stage1);
		stage2.initModality(Modality.APPLICATION_MODAL);
		ListView<String> list = initList();
		Scene scene = new Scene(list, 300, 200);
		stage2.setScene(scene);

		/**
		 * Set event handling for ListView
		 * Remember all selected entries in address selection when clicking on entry
		 */
		list.setOnMouseClicked(event -> {
			addressSelection = list.getSelectionModel().getSelectedItems();
		});

		// set event handler for dialog close event
		stage2.setOnCloseRequest(event -> {
			String addresses = toTextField.getText();
			if (addressSelection != null) {
				// append selected addresses to toTextField
				for (String s : addressSelection) {
					if (addresses.trim().length() > 0 &&
							!addresses.endsWith(";") && !addresses.endsWith("; "))
						addresses += "; ";
					addresses += s;
				}
				toTextField.setText(addresses);
			}
		});
		stage2.show();
	}

	/**
	 * Create all controls for topPane of BorderPane.
	 * 
	 * @param stage1 main window, needed to attach modal dialog to it
	 * @return gridPane instance ready for use
	 */
	private Pane initTopPane(Stage stage1) {
		GridPane grid = new GridPane();

		// set padding top, right, bottom, left
		grid.setPadding(new Insets(10, 5, 10, 5));
		if (showLayout)
			grid.setStyle("-fx-background-color: #dbda9a");
		grid.setGridLinesVisible(showLayout);

		// create controls
		toTextField = new TextField();
		toTextField.setPrefWidth(400);
		subjectTextField = new TextField();
		Button toSelectionButton = new Button("...");

		// open address selection subdialog when button is clicked
		toSelectionButton.setOnAction(e -> {
			initSelectionDialog(stage1);
		});

		fromChoiceBox = initFromChoiceBox();

		// GridPane belegen
		grid.add(new Label("From"), 0, 0);
		grid.add(new Label("To"), 0, 1);
		grid.add(new Label("Subject"), 0, 2);
		grid.add(fromChoiceBox, 1, 0);
		grid.add(toTextField, 1, 1);
		grid.add(subjectTextField, 1, 2);
		grid.add(toSelectionButton, 2, 1);

		grid.setHgap(5); // control distance of 5px horizontally
		grid.setVgap(5); // control distance of 5px vertically

		return grid;
	}

	/**
	 * Create and initialize ChoiceBox for sender email addresses.
	 * 
	 * @return choicebox
	 */
	private ChoiceBox<String> initFromChoiceBox() {
		ObservableList<String> addresses = FXCollections.observableArrayList();
		addresses.addAll("codie@codiesworld.de", "codie.coder@google.com", "codie.coder@freemail.de");
		ChoiceBox<String> cb = new ChoiceBox<>(addresses);
		cb.getSelectionModel().select(0);
		cb.setPrefWidth(400);
		return cb;
	}

	/**
	 * Create and initialize VBox containing a Label and a Textarea.
	 * 
	 * @return VBox
	 */
	private Pane initMessagePane() {
		Pane pane = new VBox();

		pane.setPadding(new Insets(10, 5, 10, 5));

		messageTextArea = new TextArea("Your text here...");
		messageTextArea.setPrefRowCount(1000); // bigger window causes bigger TextArea
		pane.getChildren().addAll(new Label("Message:"), messageTextArea);
		if (showLayout)
			pane.setStyle("-fx-background-color: #cf9e9b");

		return pane;
	}

	/**
	 * Create and initialize a VBox with RadioButtons.
	 * 
	 * @return VBox
	 */
	private VBox initRadioButtons() {
		VBox pane = new VBox();

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setSpacing(5);
		if (showLayout)
			pane.setStyle("-fx-background-color: #faf9cd");
		pane.setStyle("-fx-border-color: black");
		pane.setPrefWidth(220);

		// attach all radios to one togglegroup to achieve 1 from 2 selection
		ToggleGroup tg = new ToggleGroup();
		textRadioButton = new RadioButton("Text");
		htmlRadioButton = new RadioButton("HTML");
		textRadioButton.setToggleGroup(tg);
		htmlRadioButton.setToggleGroup(tg);
		htmlRadioButton.setSelected(true);
		pane.getChildren().addAll(textRadioButton, htmlRadioButton);

		return pane;
	}

	/**
	 * Create and initialize a VBox with CheckBoxes.
	 * 
	 * @return VBox
	 */
	private VBox initCheckBoxes() {
		VBox pane = new VBox();

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setSpacing(5);
		if (showLayout)
			pane.setStyle("-fx-background-color: #faf9cd");
		pane.setStyle("-fx-border-color: black");
		pane.setPrefWidth(220);

		encryptedCheckBox = new CheckBox("encrypted");
		signedCheckBox = new CheckBox("signed");
		withSignatureCheckBox = new CheckBox("include signature");
		encryptedCheckBox.setSelected(true);
		pane.getChildren().addAll(encryptedCheckBox, signedCheckBox, withSignatureCheckBox);

		return pane;
	}

	/**
	 * Gibt die eingegebenen/ausgewählten Daten auf die Console aus.
	 */
	private void printData() {
		String from = fromChoiceBox.getSelectionModel().getSelectedItem();
		String to = toTextField.getText();
		String subject = subjectTextField.getText();
		System.out.printf("E-Mail from %s to \n\t%s\n", from, to);
		System.out.printf("Subject: %s\n", subject);
		System.out.printf("Message:\n%s\n", messageTextArea.getText());
		System.out.println("Options:");
		System.out.printf("\tFormat is %s\n", textRadioButton.isSelected() ? "Text" : "HTML");
		System.out.printf("\t[%c] encrypted\n", encryptedCheckBox.isSelected() ? 'X' : ' ');
		System.out.printf("\t[%c] signed\n", signedCheckBox.isSelected() ? 'X' : ' ');
		System.out.printf("\t[%c] include signature\n", withSignatureCheckBox.isSelected() ? 'X' : ' ');
	}

	/**
	 * Create and initialize VBox for bottom area
	 * 
	 * @return VBox
	 */
	private Pane initBottomPane() {
		/*
		 * Button Pane
		 */
		FlowPane buttonPane = new FlowPane();
		Button sendButton = new Button("Send");
		sendButton.setPrefWidth(200);
		sendButton.setOnAction(e -> {
			printData();
		});
		Button cancelButton = new Button("Cancel");
		cancelButton.setPrefWidth(200);
		cancelButton.setOnAction(e -> Platform.exit());

		buttonPane.getChildren().addAll(sendButton, cancelButton);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.setHgap(20);
		if (showLayout)
			buttonPane.setStyle("-fx-background-color: red");

		/*
		 * Options Box
		 */
		HBox optionsBox = new HBox();
		VBox radioButtons = initRadioButtons();
		VBox checkBoxes = initCheckBoxes();
		optionsBox.getChildren().addAll(radioButtons, checkBoxes);
		optionsBox.setAlignment(Pos.CENTER);
		optionsBox.setSpacing(10);
		if (showLayout)
			optionsBox.setStyle("-fx-background-color: lightblue");
		optionsBox.setPadding(new Insets(10, 10, 10, 10));

		/*
		 * Bottom Pane
		 */
		VBox pane = new VBox();
		pane.setSpacing(10);
		pane.getChildren().addAll(optionsBox, buttonPane);
		if (showLayout)
			pane.setStyle("-fx-background-color: #dbda9a");
		pane.setPadding(new Insets(10, 10, 10, 10));

		return pane;
	}

	/**
	 * Setup main window
	 * 
	 * @param stage1 main window, created by JavaFX launcher
	 */
	public void start(Stage stage1) throws Exception {
		stage1.setTitle("Send Mail");
		BorderPane mainPane = new BorderPane();

		// Mail header
		Pane headerPane = initTopPane(stage1);
		mainPane.setTop(headerPane);

		// Center: messge text
		Pane messagePane = initMessagePane();
		mainPane.setCenter(messagePane);

		// Bottom: options and buttons
		Pane optionsPane = initBottomPane();
		mainPane.setBottom(optionsPane);

		Scene scene = new Scene(mainPane, 500, 450);
		stage1.setScene(scene);
		stage1.show();
	}

	/**
	 * main method starting the application
	 */
	public static void main(String[] args) {
		launch();
	}

}
