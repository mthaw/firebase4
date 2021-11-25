package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Stage loginStage, mainStage, registerStage;
	
	@Override
	public void start(Stage primaryStage) {
		Main.loginStage = primaryStage;
		openLoginWindow();
	}
	
	public void openLoginWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			loginStage.setScene(scene);
			loginStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openMainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Animaux.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			mainStage = new Stage();
		    mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openRegisterWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			registerStage = new Stage();
		    registerStage.setScene(scene);
			registerStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
