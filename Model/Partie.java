package Model;

import java.util.ArrayList;

import com.sun.prism.Mesh;

import application.*;

import javafx.scene.control.Button;

public class Partie {

	public ArrayList<Button> buttons;
	boolean choix_place = false;
	Button destination;
	Button source;
	public int source_id;
	public int destination_id;
	public Player player1;
	public Player player2;
	public static Partie instance;
	public OrganiserPlateau org;
	public String type;

	private Partie() {

	}

	public static Partie GetPatie() {
		if (instance == null)
			instance = new Partie();
		return instance;
	}

	public void setCases(ArrayList<Button> buttons) {
		this.buttons = buttons;
		
	}
	public void setOrganiserPlateau(OrganiserPlateau org) {
		this.org=org;
	}

	public void startNewGame() {

		player1 = new Player("X", true);
		player2 = new Player("O", false);
	}
	
	public void restart() {
		buttons.forEach(button -> {
			button.setDisable(false);
			button.setText("?");
		});
		player1.tour=true;
		player2.tour=false;

		
	}

	public boolean ifValideCase(Button button) {

		if (button.getText().equals("X") || button.getText().equals("O")) {
			return false;
		}

		if (button.getId().equals("button1") || button.getId().equals("button2") || button.getId().equals("button3")
				|| button.getId().equals("button4") || button.getId().equals("button5"))
			return true;
		else if (button.getId().equals("button6") || button.getId().equals("button10")) {
			return true;
		} else if (button.getId().equals("button11") || button.getId().equals("button15")) {
			return true;
		} else if (button.getId().equals("button16") || button.getId().equals("button20")) {
			return true;
		} else if (button.getId().equals("button21") || button.getId().equals("button22")
				|| button.getId().equals("button23") || button.getId().equals("button24")
				|| button.getId().equals("button25")) {
			return true;
		}

		return false;

	}

	public String testPlateau(Button button) {
		String messag = "";
		/*
		 * String test = button.getId(); String ret = test.replace("button", ""); int nb
		 * = Integer.valueOf(ret); if (!choix_place) { if (ifValideCase(button)) {;
		 * messag="Choisisser l'emplacement de pion"; source = button; source_id = nb;
		 * if (player1.tour) { button.setText(player1.symbole); player1.tour = false;
		 * player2.tour = true; } else { button.setText(player2.symbole); player1.tour =
		 * true; player2.tour = false; } choix_place = true; source = button;
		 * 
		 * } } else { destination = button; destination_id = nb; if
		 * (ifValideDestination(source, destination)) { choix_place = false;
		 * placer_piond(button, destination_id, source_id); messag=ifWin();
		 * if(messag.equals("")) messag="Jouer le coup";
		 * 
		 * }
		 * 
		 * }
		 */
		org.setButtons(buttons);
		messag = org.testPlateau(button, player1, player2);
		return messag;

	}

	public String ifWin() {

		String cas1 = buttons.get(0).getText() + buttons.get(1).getText() + buttons.get(2).getText()
				+ buttons.get(3).getText() + buttons.get(4).getText();
		String cas2 = buttons.get(20).getText() + buttons.get(21).getText() + buttons.get(22).getText()
				+ buttons.get(23).getText() + buttons.get(24).getText();
		String cas3 = buttons.get(0).getText() + buttons.get(5).getText() + buttons.get(10).getText()
				+ buttons.get(15).getText() + buttons.get(20).getText();
		String cas4 = buttons.get(4).getText() + buttons.get(9).getText() + buttons.get(14).getText()
				+ buttons.get(19).getText() + buttons.get(24).getText();
		String cas5 = buttons.get(1).getText() + buttons.get(6).getText() + buttons.get(11).getText()
				+ buttons.get(16).getText() + buttons.get(21).getText();
		String cas6 = buttons.get(2).getText() + buttons.get(7).getText() + buttons.get(12).getText()
				+ buttons.get(17).getText() + buttons.get(22).getText();
		String cas7 = buttons.get(3).getText() + buttons.get(8).getText() + buttons.get(13).getText()
				+ buttons.get(18).getText() + buttons.get(23).getText();
		String cas8 = buttons.get(5).getText() + buttons.get(6).getText() + buttons.get(7).getText()
				+ buttons.get(8).getText() + buttons.get(9).getText();
		String cas9 = buttons.get(10).getText() + buttons.get(11).getText() + buttons.get(12).getText()
				+ buttons.get(13).getText() + buttons.get(14).getText();
		String cas10 = buttons.get(15).getText() + buttons.get(16).getText() + buttons.get(17).getText()
				+ buttons.get(18).getText() + buttons.get(19).getText();
		String cas11 = buttons.get(0).getText() + buttons.get(6).getText() + buttons.get(12).getText()
				+ buttons.get(18).getText() + buttons.get(24).getText();
		String cas12 = buttons.get(4).getText() + buttons.get(8).getText() + buttons.get(12).getText()
				+ buttons.get(16).getText() + buttons.get(20).getText();
		if (cas1.equals("XXXXX") || cas2.equals("XXXXX") || cas3.equals("XXXXX") || cas4.equals("XXXXX")
				|| cas5.equals("XXXXX") || cas6.equals("XXXXX") || cas7.equals("XXXXX") || cas8.equals("XXXXX")
				|| cas9.equals("XXXXX") || cas10.equals("XXXXX") || cas11.equals("XXXXX") || cas12.equals("XXXXX")) {
			System.out.println("Wiiin X");
			player1.score += 1;
			finirPartie();
			return "Wiiin X";

		}
		if (cas1.equals("OOOOO") || cas2.equals("OOOOO") || cas3.equals("OOOOO") || cas4.equals("OOOOO")
				|| cas5.equals("OOOOO") || cas6.equals("OOOOO") || cas7.equals("OOOOO") || cas8.equals("OOOOO")
				|| cas9.equals("OOOOO") || cas10.equals("OOOOO") || cas11.equals("OOOOO") || cas12.equals("OOOOO")) {
			System.out.println("Wiiin O");
			player2.score += 1;
			finirPartie();
			return "Wiiin O";
		}

		return "";
	}
	
	public void  finirPartie() {
		buttons.forEach(button -> {
			button.setDisable(true);
		});
	}

	public boolean ifValideDestination(Button src, Button des) {
		//System.out.println("je suis dans ce cas de valide setina");
		//System.out.println("source" + src.getId());

		if (src.getId().equals("button1") || src.getId().equals("button6") || src.getId().equals("button11")
				|| src.getId().equals("button16") || src.getId().equals("button21")) {
			if (src.getId().equals("button1") && des.getId().equals("button1")) {
				// info.setText("Vous nous pouve pas le deplacer ici !");
				return false;
			}
			if (src.getId().equals("button11") && des.getId().equals("button11")) {
				// info.setText("Vous nous pouve pas le deplacer ici !");
				return false;
			}
			if (des.getId().equals("button21") || des.getId().equals("button1")) {
				//System.out.println("je suis dans cea sheinn *******!");
				return true;
			}
			if (src.getId().equals("button1") && des.getId().equals("button5")
					|| src.getId().equals("button6") && des.getId().equals("button10")
					|| src.getId().equals("button11") && des.getId().equals("button15")
					|| src.getId().equals("button16") && des.getId().equals("button20")
					|| src.getId().equals("button21") && des.getId().equals("button25")) {
				return true;
			}
		}

		if (src.getId().equals("button5") || src.getId().equals("button10") || src.getId().equals("button15")
				|| src.getId().equals("button20") || src.getId().equals("button25")) {
			if (src.getId().equals("button5") && des.getId().equals("button5")) {
				// info.setText("Vous nous pouve pas le deplacer ici !");
				return false;
			}
			if (src.getId().equals("button25") && des.getId().equals("button25")) {
				// info.setText("Vous nous pouve pas le deplacer ici !");
				return false;
			}
			if (des.getId().equals("button25") || des.getId().equals("button5")) {
				System.out.println("je suis dans cea sheinn *******!");
				return true;
			}
			if (src.getId().equals("button5") && des.getId().equals("button1")
					|| src.getId().equals("button10") && des.getId().equals("button6")
					|| src.getId().equals("button15") && des.getId().equals("button11")
					|| src.getId().equals("button20") && des.getId().equals("button16")
					|| src.getId().equals("button25") && des.getId().equals("button21")) {
				return true;
			}

		}
		if (src.getId().equals("button2") || src.getId().equals("button3") || src.getId().equals("button4")) {

			if (src.getId().equals("button2") && des.getId().equals("button22")
					|| src.getId().equals("button3") && des.getId().equals("button23")
					|| src.getId().equals("button4") && des.getId().equals("button24")) {
				return true;
			}
			if (des.getId().equals("button1") || des.getId().equals("button5")) {
				//System.out.println("je suis dans cea sheinn *******!");
				return true;
			}

		}
		if (src.getId().equals("button2") || src.getId().equals("button3") || src.getId().equals("button4")) {

			if (src.getId().equals("button2") && des.getId().equals("button22")
					|| src.getId().equals("button3") && des.getId().equals("button23")
					|| src.getId().equals("button4") && des.getId().equals("button24")) {
				return true;
			}
			if (des.getId().equals("button1") || des.getId().equals("button5")) {
				//System.out.println("je suis dans cea sheinn *******!");
				return true;
			}

		}
		if (src.getId().equals("button22") || src.getId().equals("button23") || src.getId().equals("button24")) {

			if (src.getId().equals("button22") && des.getId().equals("button2")
					|| src.getId().equals("button23") && des.getId().equals("button3")
					|| src.getId().equals("button24") && des.getId().equals("button4")) {
				return true;
			}
			if (des.getId().equals("button25") || des.getId().equals("button21")) {
				System.out.println("je suis dans cea sheinn *******!");
				return true;
			}

		}

		System.out.println("je suis dans cea sheinnsksdkj *******!");
		// info.setText("Vous nous pouve pas le deplacer ici !");
		return false;
	}

	String Score;

	boolean placer_piond(Button button, int id_des, int id_src) {
		if (id_src < id_des && (destination.getId().equals("button5"))
				&& (source.getId().equals("button1") || (source.getId().equals("button2")
						|| source.getId().equals("button3") || source.getId().equals("button4")

				))) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = buttons.size() - 1; i >= 0; i--) {
				System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {

					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					if (i != 0) {
						search = buttons.get(i - 1);
						temp_text_affecte = temp_text_amemorriser;

					}

				}

			}

		} else if (id_src < id_des && (destination.getId().equals("button10") && source.getId().equals("button6"))
				|| (destination.getId().equals("button10") && source.getId().equals("button6"))
				|| (destination.getId().equals("button15") && source.getId().equals("button11"))
				|| (destination.getId().equals("button20") && source.getId().equals("button16"))) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = buttons.size() - 1; i >= 0; i--) {
				System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {

					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					if (i != 0) {
						search = buttons.get(i - 1);
						temp_text_affecte = temp_text_amemorriser;

					}

				}
			}

		} else if (id_src < id_des && (destination.getId().equals("button25"))
				&& (source.getId().equals("button21") || (source.getId().equals("button22")
						|| source.getId().equals("button23") || source.getId().equals("button24")

				))) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = buttons.size() - 1; i >= 0; i--) {
				System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					// System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {

					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					if (i != 0) {
						search = buttons.get(i - 1);
						temp_text_affecte = temp_text_amemorriser;

					}

				}

			}

		} else if (id_src > id_des && (destination.getId().equals("button1"))
				&& (source.getId().equals("button2") || (source.getId().equals("button3")
						|| source.getId().equals("button4") || source.getId().equals("button5")

				))) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = 0; i < buttons.size(); i++) {
				// System.out.println("search " + search);
				// System.out.println("HIHIIII!!!!");
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();

					buttons.get(i).setText(temp_text_affecte);
					System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {
					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					search = buttons.get(i + 1);
					temp_text_affecte = temp_text_amemorriser;

				}

			}

		} else if (id_src > id_des && (destination.getId().equals("button6") && source.getId().equals("button10"))
				|| (destination.getId().equals("button6") && source.getId().equals("button10"))
				|| (destination.getId().equals("button11") && source.getId().equals("button15"))
				|| (destination.getId().equals("button16") && source.getId().equals("button20"))) {
			System.out.println("hererrerer smlsldms *******");
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = 0; i < buttons.size(); i++) {
				// System.out.println("search " + search);
				System.out.println("HIHIIII!!!!");
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();

					buttons.get(i).setText(temp_text_affecte);
					// System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {
					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					search = buttons.get(i + 1);
					temp_text_affecte = temp_text_amemorriser;

				}

			}
		} else if (id_src > id_des && (destination.getId().equals("button21"))
				&& (source.getId().equals("button22") || (source.getId().equals("button23")
						|| source.getId().equals("button24") || source.getId().equals("button25")

				))) {
			// System.out.println("*****************Stassnshghsdg *******");
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = 0; i < buttons.size(); i++) {
				// System.out.println("search " + search);
				System.out.println("HIHIIIIsdshg!!!!");
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					//System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {
					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					search = buttons.get(i + 1);
					temp_text_affecte = temp_text_amemorriser;

				}

			}

		} else if (id_src > id_des) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = 0; i < buttons.size(); i++) {
				System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					//System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {

					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					if (i != 20) {
						search = buttons.get(i + 5);
						temp_text_affecte = temp_text_amemorriser;

					}

				}

			}

		} else if (id_src < id_des) {
			System.out.println("*****deuxieme cas est lààà******************");
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = buttons.size() - 1; i >= 0; i--) {
				// System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					// System.out.println("Celui la" + buttons.get(i));
					break;
				}
				if (buttons.get(i).getId().equals(search.getId())) {

					temp_text_amemorriser = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					if (i != 1) {
						// System.out.println("i est maintenant******** " + i);
						search = buttons.get(i - 5);
						temp_text_affecte = temp_text_amemorriser;

					}

				}

			}

		}

		return false;
	}

}
