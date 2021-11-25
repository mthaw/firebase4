package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtuser;

    @FXML
    private PasswordField txtpasse;

    
    public void Register() {
    	new Main().openRegisterWindow();
    	Main.loginStage.close();
    }
    
    public void MainFenetre() {
    	new Main().openMainWindow();
    	Main.loginStage.close();
    }
}
