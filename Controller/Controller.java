package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import java.util.Arrays;

import javafx.event.ActionEvent;
import Model.*;

public class Controller implements Initializable {
	@FXML
	Button button1;

	@FXML
	Button button2;
	@FXML
	Button button3;
	@FXML
	Button button4;
	@FXML
	Button button5;
	@FXML
	Button button6;
	@FXML
	Button button7;
	@FXML
	Button button8;
	@FXML
	Button button9;
	@FXML
	Button button10;
	@FXML
	Button button11;
	@FXML
	Button button12;
	@FXML
	Button button13;
	@FXML
	Button button14;
	@FXML
	Button button15;
	@FXML
	Button button16;
	@FXML
	Button button17;
	@FXML
	Button button18;
	@FXML
	Button button19;
	@FXML
	Button button20;
	@FXML
	Button button21;
	@FXML
	Button button22;
	@FXML
	Button button23;
	@FXML
	Button button24;
	@FXML
	Button button25;
	Button destination;
	Button source;
	int source_id;
	int destination_id;
	@FXML
	public Text info;
	
	@FXML
	public Text scorer;
	@FXML
	public Text scoreb;
	@FXML
	public MenuItem nouveau;
	
	boolean choix_place = false;
	Partie partie;
	boolean player_tour1 = true;
	boolean player_tour2 = false;

	ArrayList<Button> buttons_h_g = new ArrayList<>(Arrays.asList(button1, button6, button11, button16, button21));

	ArrayList<Button> buttons;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8,
				button9, button10, button11, button12, button13, button14, button15, button16, button17, button18,
				button19, button20, button21, button22, button23, button24, button25));
		partie = Partie.GetPatie();
		partie.setCases(buttons);
		partie.startNewGame();
		info.setText("Jouer le couup!!");
		buttons.forEach(button -> {
			setupButton(button);
			button.setFocusTraversable(false);
		});
	}

	private void setupButton(Button button) {
		button.setOnMouseClicked(mouseEvent -> {
			info.setText(partie.testPlateau(button));
			scorer.setText(Integer.toString(partie.player1.score));
			scoreb.setText(Integer.toString(partie.player2.score));

		});

	}
	@FXML
	public void  nouvellePartie() {
		
		partie.restart();
	}

}
