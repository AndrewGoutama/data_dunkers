package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Tester extends Application{
	Scene loginScene, regisScene;
	
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	StackPane sp;
	//Label Login
	Label lbEmail, lbPass;
	//Label Register
	Label lbConPass,lbAge,lbGender,lbNation;
	
	TextField tfEmail;
	TextArea addressField;
	PasswordField tfPass,tfConPass;
	Button btnLogin, btnRegis;
	Menu menu;
	MenuBar menuBar;
	MenuItem menuItem;
	
	RadioButton maleRadio, femaleRadio;
	ToggleGroup genderGroup;
	ComboBox<String> countryBox;
	CheckBox checkBox;
	Spinner<Integer> ageSpinner;
	
	
	public class DatabaseConnection {

	    public Connection connectToDatabase() throws SQLException {
	        String url = "jdbc:sqlserver://server_name:port_number;databaseName=6\r\n";
	        return DriverManager.getConnection(url);
	    }
	}
	
	public static void main(String[] args) {
		//Launch biar keliatan
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        sp = new StackPane();
        //Login Scene
        Login();
        loginScene = new Scene(sp, 500, 500);
        // Create the Home Scene
//        Register();
        StackPane RegisLayout = new StackPane();
        regisScene = new Scene(RegisLayout, 400, 300);
		
		stage.setScene(loginScene);
//		stage.setScene(regisScene);
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.show();

	}
	
	private void Login() {
		//Initialize
		bp = new BorderPane();
		gp = new GridPane();
		fp = new FlowPane();
		lbEmail = new Label("Email");
		lbPass = new Label("Password");
		tfEmail = new TextField();
		tfPass = new PasswordField();
		btnLogin = new Button("Login");
		fp.getChildren().addAll(btnLogin);
		menuBar = new MenuBar();
		menu = new Menu("Page");
		menuItem = new MenuItem("");
		menuBar.getMenus().add(menu);
		
		//Set Component
		gp.add(lbEmail, 0, 0);
		gp.add(tfEmail, 1, 0);
		gp.add(lbPass, 0, 1);
		gp.add(tfPass, 1, 1);
		gp.add(btnLogin, 0, 3);
		
		//Set Style
		bp.setTop(menuBar);
		bp.setCenter(gp);
		bp.setBottom(fp);
		gp.setHgap(20);
		gp.setVgap(20);
		fp.setHgap(20);
		fp.setVgap(20);
		gp.setPadding(new Insets(100));
		
		//Set Action
		btnLogin.setOnAction(event -> {
		    if (inputValidation()) {
		        Register();
		        Stage stage = (Stage) btnLogin.getScene().getWindow();
		        stage.setScene(regisScene);
		    }
		});

	
		sp.getChildren().add(bp);
		

	}
	
	private boolean inputValidation() {
		Alert alert = new Alert(AlertType.ERROR);
	    alert.setHeaderText("Warning");

	    if (tfEmail.getText().isEmpty() || tfPass.getText().isEmpty()) {
	        alert.setContentText("Email or Password Must be filled");
	        alert.show();
	        return false;
	    }
	    alert.setAlertType(AlertType.INFORMATION);
	    alert.setHeaderText("Login Success");
	    alert.setContentText("Successfully Logged In");
	    alert.show();
	    
	    return true;
	}
	
	private void Register() {
		//Initialize
		bp = new BorderPane();
		gp = new GridPane();
		fp = new FlowPane();
		lbEmail = new Label("Email");
		lbPass = new Label("Password");
		lbConPass = new Label("Confirm Password");
		lbAge = new Label("Age");
		lbGender = new Label("Gender");
		lbNation = new Label("Nationality");
		tfEmail = new TextField();
		tfPass = new PasswordField();
		tfConPass = new PasswordField();
		
		ageSpinner = new Spinner<>();
		SpinnerValueFactory<Integer> ageSpinnerVal = 
		new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
		ageSpinner.setValueFactory(ageSpinnerVal);
		
		maleRadio = new RadioButton();
		femaleRadio = new RadioButton();
		genderGroup = new ToggleGroup();
		
		maleRadio.setToggleGroup(genderGroup);
		femaleRadio.setToggleGroup(genderGroup);
		fp.getChildren().addAll(maleRadio, femaleRadio);

		countryBox = new ComboBox<>();
		countryBox.getItems().add("Indonesia");
		countryBox.getItems().add("Singapore");
		countryBox.getItems().add("America");
		countryBox.getSelectionModel().selectFirst();
		
		btnRegis = new Button("Register");
		
		menuBar = new MenuBar();
		menu = new Menu("Form");
		menuItem = new MenuItem("");

		//Set Component
		gp.add(lbEmail, 0, 0);
	    gp.add(tfEmail,0, 1);
	    
	    gp.add(lbPass, 0, 2);
	    gp.add(tfPass, 0, 3);
	    
	    gp.add(lbConPass, 0, 4);
	    gp.add(tfConPass, 0, 5);
	    
	    gp.add(lbAge, 0, 5);
	    gp.add(ageSpinner, 0, 6);
	    
	    gp.add(lbGender, 1, 0);
	    gp.add(fp, 1, 1);
	    
	    gp.add(lbNation, 1, 2);
	    gp.add(countryBox, 1, 4);
	    
	    gp.add(btnRegis, 1, 5);
	    
	    //Set Style
	    bp.setTop(menuBar);
  		bp.setCenter(gp);
  		bp.setBottom(fp);
  		gp.setHgap(20);
  		gp.setVgap(20);
  		fp.setHgap(20);
  		fp.setVgap(20);
  		gp.setPadding(new Insets(100));
	  		
  		Scene registerScene = new Scene(bp, 500, 500);
  	    Stage stage = (Stage) btnLogin.getScene().getWindow();
  	    stage.setScene(registerScene);
 
  	
	}
		
	private void Home() {
		
	}
	
}

	
	


