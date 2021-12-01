package application;
import java.net.URL;
import java.util.ResourceBundle;

import com.firebase.client.Firebase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable{

	//Definition de tous les champs pour l'enregistrement
	
    @FXML
    private TextField tphone;

    @FXML
    private TextField tusager;

    @FXML
    private TextField tpasse;

    @FXML
    private Button benregistrer;

    @FXML
    private TextField taddresse;

    @FXML
    private TextField tage;

    @FXML
    private TextField tnom;

    @FXML
    private ComboBox<String> cbocpt;
    
    private ObservableList<String> list = FXCollections.observableArrayList("Gentil", "Gourmand", "Paresseux", "Léthargique", "Aggressif");

    /**
     * Methode qu'on appelle en ouvrant le fenetre d'enregistrement. Il nous prepare le combobox en en attribuant les options (items).
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbocpt.setItems(list);
	}
	
	public void Register() {
		Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
		Animal animal = new Animal();
		animal.setNom(tnom.getText());
		animal.setAddresse(taddresse.getText());
		animal.setPasse(tpasse.getText());
		animal.setPhone(tphone.getText());
		animal.setComportement(cbocpt.getValue());
		animal.setAge(tage.getText());
		animal.setUser(tusager.getText());
		firebase.child("animaux").push().setValue(animal);
		new Main().openLoginWindow();
		Main.registerStage.close();
	}


}
