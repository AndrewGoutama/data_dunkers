package main;

import javafx.stage.Stage;

public class SceneManager {
    private Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showLoginScene() {
        LoginScene loginScene = new LoginScene(this);
        primaryStage.setScene(loginScene.getScene());
    }

    public void showRegisterScene() {
        RegisterScene registerScene = new RegisterScene(this);
        primaryStage.setScene(registerScene.getScene());
        primaryStage.setTitle("Register");
    }
    
    public void showHomeScene() {
    	HomeScene homescene = new HomeScene(this);
    	primaryStage.setScene(homescene.getScene());
    	primaryStage.setTitle("Home");
    }
    
    public void showCartScene() {
    	CartScene cartscene = new CartScene(this);
    	primaryStage.setScene(cartscene.getScene());
    }
    
    public void showHistoryScene() {
    	HistoryScene historyscene = new HistoryScene(this);
    	primaryStage.setScene(historyscene.getScene());
    }
    
    public void showLogoutScene() {
    	LogoutScene logoutscene = new LogoutScene(this);
    	primaryStage.setScene(logoutscene.getScene());
    }
    
    public void showManageScene() {
    	ManageScene managescene = new ManageScene(this);
    	primaryStage.setScene(managescene.getScene());
    }
    
    public void showViewScene() {
    	ViewScene viewscene = new ViewScene(this);
    	primaryStage.setScene(viewscene.getScene());
    }
    
    public void showCheckoutScene() {
    	CheckoutScene checkoutscene = new CheckoutScene(this);
    	primaryStage.setScene(checkoutscene.getScene());
    }
  
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
