package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class CartScene {
	private SceneManager sceneManager;
	
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	
	Label lbHeader,lbpName,lbBrand,lbPrice,lbTotalPrice;
//	TableView<S>;
	
	Button btnCheckout,btnDelete;
	
	Menu menu;
	MenuBar menuBar;
	MenuItem menuItemHome, menuItemCart,menuItemHistory,menuItemLogout;
	
	TableView<ProductList> userTable;
	TableColumn<ProductList, String> pName, pBrand,pPrice,pQuan,pTotal;

	public CartScene(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public Scene getScene() {
		
		bp = new BorderPane();
		gp = new GridPane();
    	fp = new FlowPane();
		lbHeader = new Label("Your cart List");
		//table view disini
    	lbpName = new Label("Name	: ");
    	lbBrand = new Label("Brand	: ");
    	lbPrice = new Label("Price	: ");
    	lbTotalPrice = new Label("Total Price	: ");
    	
    	userTable = new TableView<>();
    	pName = new TableColumn<>("Name");
    	pBrand = new TableColumn<>("Brand");
    	pPrice = new TableColumn<>("Price");
    	pQuan = new TableColumn<>("Quality");
    	pTotal = new TableColumn<>("Total");
    	userTable.getColumns().addAll(pName, pBrand,pPrice,pQuan,pTotal);
    	
    	btnCheckout = new Button("Checkout");
    	btnDelete = new Button("Delete Product");


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
    	gp.add(lbTotalPrice, 1, 4);
    	
    	//Set Style
    	bp.setTop(menuBar);
    	bp.setCenter(gp);
    	bp.setBottom(fp);
    	gp.setHgap(10);
    	gp.setVgap(10);
    	fp.setHgap(10);
    	fp.setVgap(10);
    	gp.setPadding(new Insets(100));
    	
    	//Set Action
//    	btnDelete.setOnAction(event -> {
//            if (inputValidation()) {
//                //mendelete item yang dpilih
//            }
//        });
//    	
//    	btnCheckout.setOnAction(event -> {
//    		if (inputValidation()) {
//    			sceneManager.showCheckoutScene();
//    		}
//    	});
    	
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
	
//	private boolean inputValidation() {
//    	Alert alert = new Alert(AlertType.ERROR);
//	    alert.setHeaderText("Warning");
//
//	    //•	If the user did not select any of the products from the product list 
////	    and click delete product button display Warning Message.
//	    if (tfEmail.getText().isEmpty() || tfPass.getText().isEmpty()) {
//	        alert.setContentText("Email or Password Must be filled");
//	        alert.show();
//	        return false;
//	    }
//	    alert.setAlertType(AlertType.INFORMATION);
//	    alert.setHeaderText("Login Success");
//	    alert.setContentText("Successfully Logged In");
//	    alert.show();
//	    
//	    return true;
//    }

}
