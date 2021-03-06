package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private TextField txtuser;

    @FXML
    private PasswordField txtpasse;
    
    List<Animal> animauxList;
    
    public static Animal animal;
    
    public static Animal currentAnimal;
    
    int animalFound = 0;

    
    public void Register() {
    	new Main().openRegisterWindow();
    	Main.loginStage.close();
    }
    
    public void MainFenetre() {
    	new Main().openMainWindow();
    	Main.loginStage.close();
    }
    
    public void Connect(ActionEvent event) throws InterruptedException {
    	Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
    	firebase.child("animaux").addListenerForSingleValueEvent(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for(DataSnapshot data: dataSnapshot.getChildren()) {
					Animal animal = data.getValue(Animal.class);
					String Fanimal = animal.getUser();
					String Fpasse = animal.getPasse();
					String Tuser = txtuser.getText();
					String Tpasse = txtpasse.getText();
					//if(animal.getUser().equals(txtuser.getText()) && animal.getPasse().equals(txtpasse.getText())) {
					if(Fanimal.equals(Tuser) && Fpasse.equals(Tpasse)) {
						animal.setId(data.getKey());
						animalFound=1;
						currentAnimal=animal;
						animauxList.add(animal);
					}
				}
			}
			
			@Override
			public void onCancelled(FirebaseError arg0) {
				
			}
		});
    	Thread.sleep(2000);
    	
    	if(animalFound==1) {
    		MainFenetre();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setHeaderText("Erreur");
    		alert.setTitle("Erreur");
    		alert.setContentText("Usager n'a pas ete trouve");
    		alert.show();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		animauxList = new ArrayList();
	}
	
}
