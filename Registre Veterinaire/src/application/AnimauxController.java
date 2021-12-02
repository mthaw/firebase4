package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.firebase.client.Firebase;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AnimauxController implements Initializable{

    @FXML
    private ComboBox<String> cbocpt;

    @FXML
    private TextField tphone;

    @FXML
    private TextField tusager;

    @FXML
    private TextField tpasse;

    @FXML
    private TextField taddresse;

    @FXML
    private TextField tage;

    @FXML
    private TextField tnom;
    
    
    private ObservableList<String> list = FXCollections.observableArrayList("Gentil", "Gourmand", "Paresseux", "Léthargique", "Aggressif");

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbocpt.setItems(list);
		Animal animal = LoginController.currentAnimal;
		tusager.setText(animal.getUser());
		tphone.setText(animal.getPhone());
		tpasse.setText(animal.getPasse());
		taddresse.setText(animal.getAddresse());
		tnom.setText(animal.getNom());
		tage.setText(animal.getAge());
		cbocpt.setValue(animal.getComportement());
		
		tnom.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("nom").setValue(newValue);
			}
		});
		
		cbocpt.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("comportement").setValue(newValue);
			}
		});
		
		taddresse.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("addresse").setValue(newValue);
			}
		});
		
		tage.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("age").setValue(newValue);
			}
		});
		
		tpasse.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("passe").setValue(newValue);
			}
		});
		
		tphone.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("phone").setValue(newValue);
			}
		});
		
		tusager.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Firebase firebase = new Firebase("https://martinfiletest-default-rtdb.firebaseio.com/");
				firebase.child("animaux").child(animal.getId()).child("usager").setValue(newValue);
			}
		});
	}
	
	@FXML
	private void quitter() {
		System.exit(0);
	}
    

}
