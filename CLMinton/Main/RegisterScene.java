package main;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterScene {

    private SceneManager sceneManager;
    
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
	MenuItem menuItemLogin, menuItemRegister;
	
	RadioButton maleRadio, femaleRadio;
	ToggleGroup genderGroup;
	ComboBox<String> countryBox;
	CheckBox checkBox;
	Spinner<Integer> ageSpinner;

    public RegisterScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public Scene getScene() {
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
    			
    	maleRadio = new RadioButton("Male");
    	femaleRadio = new RadioButton("Female");
    	genderGroup = new ToggleGroup();
    			
    	maleRadio.setToggleGroup(genderGroup);
    	femaleRadio.setToggleGroup(genderGroup);
    	fp.setOrientation(Orientation.VERTICAL);
    	fp.getChildren().addAll(maleRadio, femaleRadio);

    	countryBox = new ComboBox<>();
    	countryBox.getItems().add("Indonesia");
    	countryBox.getItems().add("Singapore");
    	countryBox.getItems().add("America");
    	countryBox.getSelectionModel().selectFirst();
    			
    	btnRegis = new Button("Register");
    			
    	menuBar = new MenuBar();
		menu = new Menu("Page");
		menuItemLogin = new MenuItem("Login");
		menuItemRegister = new MenuItem("Register");
		menu.getItems().addAll(menuItemLogin, menuItemRegister);
		menuBar.getMenus().add(menu);

    	//Set Component
    	gp.add(lbEmail, 0, 0);
    	gp.add(tfEmail,0, 1);
    		    
    	gp.add(lbPass, 0, 2);
    	gp.add(tfPass, 0, 3);
    		    
    	gp.add(lbConPass, 0, 4);
    	gp.add(tfConPass, 0, 5);
    		    
    	gp.add(lbAge, 0, 6);
    	gp.add(ageSpinner, 0, 7);
    		    
    	gp.add(lbGender, 1, 0);
    	gp.add(fp, 1, 1);
    		    
    	gp.add(lbNation, 1, 2);
    	gp.add(countryBox, 1, 3);
    		    
    	gp.add(btnRegis, 1, 4);
    		    
    	//Set Style
    	bp.setTop(menuBar);
    	bp.setCenter(gp);

    	gp.setHgap(10);
    	gp.setVgap(10);
    	fp.setHgap(10);
    	fp.setVgap(10);
    	gp.setPadding(new Insets(100));

    	//Set Action
    	btnRegis.setOnAction(event -> {
            if (inputValidation()) {
                sceneManager.showHomeScene();
            }
        });
        
        menuItemLogin.setOnAction(event -> {

            sceneManager.showLoginScene();
        });

        menuItemRegister.setOnAction(event -> {
        	
            sceneManager.showRegisterScene();
        });

        return new Scene(bp, 550, 550);
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
}
