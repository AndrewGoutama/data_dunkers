package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class HistoryScene {
	private SceneManager sceneManager;
	
	BorderPane bp;
	GridPane gp;
	FlowPane fp;
	
	Label lbMyTR,lbTRDetail,lbTotal;
	
	Menu menu;
	MenuBar menuBar;
	MenuItem menuItemHome, menuItemCart,menuItemHistory,menuItemLogout;
	
	TableView<ProductList> myTable;
	TableColumn<ProductList, String> pName; 
	pBrand,pPrice,pQuan,pTotal;
	
	TableView<ProductList> detailTable;
	TableColumn<ProductList, String> pName, pBrand,pPrice,pQuan,pTotal;

	public HistoryScene(SceneManager sceneManager) {
		// TODO Auto-generated constructor stub
		this.sceneManager = sceneManager;
	}

	public Scene getScene() {

		bp = new BorderPane();
		gp = new GridPane();
    	fp = new FlowPane();
		lbMyTR = new Label("My Trasaction");
		lbTRDetail = new Label("Transaction Detail");
		lbTotal = new Label("Total Price : ");

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
    	gp.add(lbMyTR, 0, 0);
//    	gp.add(a, 0, 1); nanti tabel
    	gp.add(lbTRDetail, 1, 0);
//    	gp.add(a, 0, 1); nanti tabel
    	gp.add(lbTotal, 1, 1);
    	
    	menuBar = new MenuBar();
		menu = new Menu("Page");
		menuItemHome = new MenuItem("Home");
		menuItemCart = new MenuItem("Cart");
		menuItemHistory = new MenuItem("History");
		menuItemLogout = new MenuItem("Logout");
		menu.getItems().addAll(menuItemHome, menuItemCart,
				menuItemHistory,menuItemLogout);
		menuBar.getMenus().add(menu);
    	
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

}
