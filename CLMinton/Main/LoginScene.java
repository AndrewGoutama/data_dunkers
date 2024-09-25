package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LoginScene {

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
	MenuItem menuItemLogin,menuItemRegister;
	
	RadioButton maleRadio, femaleRadio;
	ToggleGroup genderGroup;
	ComboBox<String> countryBox;
	CheckBox checkBox;
	Spinner<Integer> ageSpinner;

    public LoginScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public Scene getScene() {
    	//Initialize
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        FlowPane fp = new FlowPane();
        lbEmail = new Label("Email");
		lbPass = new Label("Password");
		tfEmail = new TextField();
		tfPass = new PasswordField();
		btnLogin = new Button("Login");
		fp.getChildren().addAll(btnLogin);
		
		menuBar = new MenuBar();
		menu = new Menu("Page");
		menuItemLogin = new MenuItem("Login");
		menuItemRegister = new MenuItem("Register");
		menu.getItems().addAll(menuItemLogin, menuItemRegister);
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
                sceneManager.showRegisterScene();
            }
        });
        
        menuItemLogin.setOnAction(event -> {

            sceneManager.showLoginScene();
        });

        menuItemRegister.setOnAction(event -> {
        	
            sceneManager.showRegisterScene();
        });

        bp.setCenter(gp);
        bp.setBottom(fp);

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
