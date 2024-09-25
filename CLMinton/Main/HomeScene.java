package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScene extends Application {
	private SceneManager sceneManager;
	
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	Label lbHeader,lbpName,lbBrand,lbPrice,lbTotalPrice;
	
	Button btnAdd;
	
	Menu menu;
	MenuBar menuBar;
	MenuItem menuItemHome, menuItemCart,menuItemHistory,menuItemLogout;
	
	Spinner<Integer> amntSpinner;
	TableView<ProductList> userTable;
	TableColumn<ProductList, String> pName, pBrand,pStock,pPrice;

	public HomeScene(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}
	

	public Scene getScene() {
		//Initialize
		bp = new BorderPane();
		gp = new GridPane();
    	fp = new FlowPane();
    	lbHeader = new Label("Product List");
    	lbpName = new Label("Product Name : ");
    	lbBrand = new Label("Product Brand : ");
    	lbPrice = new Label("Price : ");
    	//Kurang Tabel Database
    	userTable = new TableView<>();
    	pName = new TableColumn<>("Name");
    	pBrand = new TableColumn<>("Brand");
    	pStock = new TableColumn<>("Stock");
    	pPrice = new TableColumn<>("Price");
    	userTable.getColumns().addAll(pName, pBrand,pStock,pPrice);
    	
    	amntSpinner = new Spinner<>();
    	SpinnerValueFactory<Integer> amntSpinnerVal = 
    	new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    	amntSpinner.setValueFactory(amntSpinnerVal);
    	
    	lbTotalPrice = new Label("Total Price : ");
    	btnAdd = new Button("Add To Cart");
    	
    	menuBar = new MenuBar();
		menu = new Menu("Page");
		menuItemHome = new MenuItem("Home");
		menuItemCart = new MenuItem("Cart");
		menuItemHistory = new MenuItem("History");
		menuItemLogout = new MenuItem("Logout");
		menu.getItems().addAll(menuItemHome, menuItemCart,
				menuItemHistory,menuItemLogout);
		menuBar.getMenus().add(menu);
    	
    	//Set Component
    	gp.add(lbHeader, 0, 0);
    	gp.add(userTable, 0, 1); 
    	gp.add(lbpName, 1, 0);
    	gp.add(lbBrand, 1, 1);
    	gp.add(lbPrice, 1, 2);
    	gp.add(amntSpinner, 1, 3);
    	gp.add(lbTotalPrice, 1, 4);
    	gp.add(btnAdd, 1, 5);
    	
    	//Set Style
    	bp.setTop(menuBar);
    	bp.setCenter(gp);
    	bp.setBottom(fp);
    	gp.setHgap(5);
    	gp.setVgap(5);
    	fp.setHgap(5);
    	fp.setVgap(5);
    	gp.setPadding(new Insets(30));
    	
//    	VBox vbox = new VBox();
//        vbox.getChildren().addAll(gp, fp);
//        
//        HBox hbox = new HBox(10);
//        hbox.getChildren().addAll(userTable,vbox);
//
//
//        bp.setCenter(hbox);
    	
    	//Set Action
    	btnAdd.setOnAction(event -> {
            if (inputValidation()) {
                sceneManager.showCartScene();
            }
        });
    	
    	menuItemHome.setOnAction(event -> {
    		sceneManager.showHomeScene();
    		
        });
    	
    	menuItemCart.setOnAction(event -> {
    		sceneManager.showCartScene();
    		
    	});
    	
    	menuItemHistory.setOnAction(event -> {
    		sceneManager.showHistoryScene();

    	});
    	
    	menuItemLogout.setOnAction(event -> {
    		sceneManager.showLogoutScene();

    	});
    	
		return new Scene(bp, 700, 600);
		
	}

	
	private boolean inputValidation() {
//    	Alert alert = new Alert(AlertType.ERROR);
//	    alert.setHeaderText("Warning");
//
//	    if (tfEmail.getText().isEmpty() || tfPass.getText().isEmpty()) {
//	        alert.setContentText("Email or Password Must be filled");
//	        alert.show();
//	        return false;
//	    }
//	    alert.setAlertType(AlertType.INFORMATION);
//	    alert.setHeaderText("Login Success");
//	    alert.setContentText("Successfully Logged In");
//	    alert.show();
	    
	    return true;
    }


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
