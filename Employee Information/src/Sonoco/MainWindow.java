package Sonoco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Sonoco.DatabaseConnections.DBConnector;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class MainWindow extends Application {

	Stage window;
	TableView<Employee> EmployeeTable;

	Connection conn;
	public static void main(String[] args) {

		launch(args);
	}

	@SuppressWarnings("unchecked")
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

		TextField txtOldPCName = new TextField();
		TextField txtNewPCName = new TextField();

		// TextAreas
		TextArea txtaPhoneNumber = new TextArea();
		TextArea txtaSerialNumbers = new TextArea();
		TextArea txtaNotes = new TextArea();

		// setting sizes of textAreas
		txtaPhoneNumber.setMaxHeight(50);
		txtaPhoneNumber.setMaxWidth(150);
		txtaPhoneNumber.setMinHeight(50);
		txtaPhoneNumber.setMinWidth(150);
		txtaPhoneNumber.setWrapText(true);

		txtaSerialNumbers.setMaxHeight(50);
		txtaSerialNumbers.setMaxWidth(150);
		txtaSerialNumbers.setMinHeight(50);
		txtaSerialNumbers.setMinWidth(150);
		txtaSerialNumbers.setWrapText(true);

		txtaNotes.setMaxHeight(200);
		txtaNotes.setMaxWidth(200);
		txtaNotes.setMinHeight(200);
		txtaNotes.setMinWidth(200);
		txtaNotes.setWrapText(true);

	

		// HBox For Buttons
		HBox hbSubmitCancel = new HBox(10);
		hbSubmitCancel.getChildren().addAll(btnSubmit, btnCancel);
		
		//For Right Side of Border
		Label lblSearch=new Label("Search");
		TextField txtSearch=new TextField();
		
		//Table start--------------------------------------------------------------------------------------
		//FirstName Column
		TableColumn<Employee,String> colFirst= new TableColumn<Employee,String>("First Name");
		colFirst.setMinWidth(100);
		colFirst.setCellValueFactory(new PropertyValueFactory<Employee,String>("EmployeeFirstName"));
		//LastName Column
		TableColumn<Employee,String> colLast= new TableColumn<Employee,String>("Last Name");
		colLast.setMinWidth(100);
		colLast.setCellValueFactory(new PropertyValueFactory<Employee,String>("EmployeeLastName"));
		
		//Phone Number Column
		TableColumn<Employee,String> colPhone= new TableColumn<Employee,String>("Phone Number");
		colPhone.setMinWidth(100);
		colPhone.setCellValueFactory(new PropertyValueFactory<Employee,String>("Phone"));
		
		//Serial Number Column
		TableColumn<Employee,String> colSerial= new TableColumn<Employee,String>("Serial Number");
		colSerial.setMinWidth(100);
		colSerial.setCellValueFactory(new PropertyValueFactory<Employee,String>("SerialNumbers"));
		
		//Old PC Column
		TableColumn<Employee,String> colOldPC= new TableColumn<Employee,String>("Old PC");
		colOldPC.setMinWidth(100);
		colOldPC.setCellValueFactory(new PropertyValueFactory<Employee,String>("OldPCName"));
		
		//New PC Column
		TableColumn<Employee,String> colNewPC= new TableColumn<Employee,String>("New PC");
		colNewPC.setMinWidth(100);
		colNewPC.setCellValueFactory(new PropertyValueFactory<Employee,String>("NewPCName"));
		
		//Notes Column
		TableColumn<Employee,String> colNotes= new TableColumn<Employee,String>("Notes");
		colNotes.setMinWidth(100);
		colNotes.setCellValueFactory(new PropertyValueFactory<Employee,String>("Notes"));
		
		//Date Column
		TableColumn<Employee,String> colDate= new TableColumn<Employee,String>("Date");
		colDate.setMinWidth(100);
		colDate.setCellValueFactory(new PropertyValueFactory<Employee,String>("Date"));
		
		EmployeeTable=new TableView<>();
		EmployeeTable.setItems(GenerateTable());
		EmployeeTable.getColumns().addAll(colFirst,colLast,colPhone,colSerial,colOldPC,colNewPC,colNotes,colDate);
		EmployeeTable.setMaxSize(200, 500);
		
		
		
		
		
		
		
		//HBox for search column
		HBox hbSearch=new HBox(8);
		hbSearch.getChildren().addAll(lblSearch,txtSearch);

		// VBox for Check Boxes
		VBox vbRightSide = new VBox(10);
		vbRightSide.getChildren().addAll(hbSearch,EmployeeTable);
		

		// GridPane for Labels and Text Boxes
		GridPane mainGrid = new GridPane();
		mainGrid.setVgap(15);
		// add Labels
		mainGrid.add(lblFirstName, 0, 0);
		mainGrid.add(lblLastName, 0, 1);
		mainGrid.add(lblPhoneNumber, 0, 2);
		mainGrid.add(lblSerialNumbers, 0, 3);
		mainGrid.add(lblOldPCName, 0, 4);
		mainGrid.add(lblNewPCName, 0, 5);
		mainGrid.add(lblNotes, 0, 6);
		// Add TextBoxes
		mainGrid.add(txtFirstName, 1, 0);
		mainGrid.add(txtLastName, 1, 1);
		mainGrid.add(txtaPhoneNumber, 1, 2);
		mainGrid.add(txtaSerialNumbers, 1, 3);
		mainGrid.add(txtOldPCName, 1, 4);
		mainGrid.add(txtNewPCName, 1, 5);
		mainGrid.add(txtaNotes, 1, 6);
		
		mainGrid.setAlignment(Pos.TOP_CENTER);

		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20, 20, 20, 20));
		/*border.setLeft();*/
		
		border.setCenter(mainGrid);
		border.setLeft(vbRightSide);

		Scene MainScene = new Scene(border,600,600);

		window.setScene(MainScene);
		window.show();

	}
	
	public ObservableList<Employee> GenerateTable() throws SQLException {
		ObservableList<Employee> employee = FXCollections.observableArrayList();
		DBConnector start=new DBConnector();
		conn=DBConnector.setConn(conn);
		
		ResultSet rs=null;
		Statement stmt=null;
		stmt=conn.createStatement();
		rs=stmt.executeQuery("Select * from employeeinformation");
		
		while(rs.next()){
			String First=rs.getString("EmployeeFirstName");
			String Last=rs.getString("EmployeeLastName");
			String Phone=rs.getString("PhoneNumber");
			String Serial=rs.getString("SerialNumbers");
			String OldPC=rs.getString("OldPCName");
			String newPC=rs.getString("NewPCName");
			String Notes=rs.getString("Notes");
			String Date=rs.getString("Date");
			
			employee.add(new Employee(First,Last,Phone,Serial,OldPC,newPC,Notes,Date));
		}
		
		
		return employee;
		
		
		
		
	}

}
