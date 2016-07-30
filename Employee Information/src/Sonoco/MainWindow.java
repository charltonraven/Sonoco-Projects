package Sonoco;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class MainWindow extends Application {

	Stage window;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {

		window = PrimaryStage;
		// Buttons
		Button btnSubmit = new Button("Submit");
		Button btnCancel = new Button("Cancel");

		// Labels
		Label lblFirstName = new Label("First Name");
		Label lblLastName = new Label("Last Name");
		Label lblSerialNumbers = new Label("Serial Number(s)");
		Label lblPhoneNumber = new Label("Phone Number(s)");
		Label lblOldPCName = new Label("Old PC Name");
		Label lblNewPCName = new Label("New PC Name");
		Label lblNotes = new Label("Notes (if Any)");

		// Textbox
		TextField txtFirstName = new TextField();
		TextField txtLastName = new TextField();
		TextField txtSerialNumbers = new TextField();txtSerialNumbers.setPrefHeight(75);
		TextField txtPhoneNumber = new TextField(); txtPhoneNumber.setPrefHeight(75);
		TextField txtOldPCName = new TextField();
		TextField txtNewPCName = new TextField();
		TextField txtNotes = new TextField(); txtNotes.setPrefHeight(100);
		
		

		// Checkbox
		CheckBox information = new CheckBox("Enter Information");
		CheckBox search = new CheckBox("Search Criteria");

		// HBox For Buttons
		HBox hbSubmitCancel = new HBox(10);
		hbSubmitCancel.getChildren().addAll(btnSubmit, btnCancel);

		// VBox for Check Boxes
		VBox vbCheckBox = new VBox(10);
		vbCheckBox.getChildren().addAll(information, search);

		// GridPane for Labels and Text Boxes
		GridPane mainGrid = new GridPane();
		mainGrid.setVgap(15);
		//add Labels
		mainGrid.add(lblFirstName,0,0);
		mainGrid.add(lblLastName,0,1);
		mainGrid.add(lblPhoneNumber,0,2);
		mainGrid.add(lblSerialNumbers,0,3);
		mainGrid.add(lblOldPCName,0,4);
		mainGrid.add(lblNewPCName,0,5);
		mainGrid.add(lblNotes,0,6);
		//Add TextBoxes
		mainGrid.add(txtFirstName,1,0);
		mainGrid.add(txtLastName,1,1);
		mainGrid.add(txtPhoneNumber,1,3);
		mainGrid.add(txtSerialNumbers,1,2);
		mainGrid.add(txtOldPCName,1,4);
		mainGrid.add(txtNewPCName,1,5);
		mainGrid.add(txtNotes,1,6);

		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20, 20, 20, 20));
		border.setLeft(vbCheckBox);
		border.setBottom(hbSubmitCancel);
		border.setCenter(mainGrid);
		

		Scene MainScene = new Scene(border,500,400);

		window.setScene(MainScene);
		window.show();

	}

}
