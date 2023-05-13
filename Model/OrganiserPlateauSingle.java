package Model;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class OrganiserPlateauSingle extends OrganiserPlateau {
 
	public OrganiserPlateauSingle() {
		
	}
	@Override
	public void setButtons(ArrayList<Button> buttons) {
		this.buttons=buttons;
	}
	@Override
	public String testPlateau(Button button, Player player1, Player player2) {
		System.out.println("source"+source);
		
		
		String messag = "";
		String test = button.getId();
		String ret = test.replace("button", "");
		int nb = Integer.valueOf(ret);
		partie=Partie.GetPatie();
		if (!choix_place) {
			if (partie.ifValideCase(button)) {
				;
				messag = "Choisisser l'emplacement de pion";
				source = button;
				source_id = nb;
				if (player1.tour) {
					button.setText(player1.symbole);
					player1.tour = false;
					player2.tour = true;
				} else {
					button.setText(player2.symbole);
					player1.tour = true;
					player2.tour = false;
				}
				choix_place = true;
				source = button;

			}
			else {
				messag="Vous ne pouvez pas jouer ici!!";
			}
		} else {
			destination = button;
			System.out.println("******destination************"+destination);
			destination_id = nb;
			if (partie.ifValideDestination(source, destination)) {
				System.out.println("je suis laaaa");
				choix_place = false;
				placer_piond(button, destination_id, source_id);
				messag = partie.ifWin();
				if (messag.equals(""))
					messag = "Jouer le coup";

			}
			else {
				messag="Vous ne pouvez pas jouer ici!!";
			}

		}
		return messag;

	}
	public boolean placer_piond(Button button, int id_des, int id_src) {
		if (id_src < id_des && (destination.getId().equals("button5"))
				&& (source.getId().equals("button1") || (source.getId().equals("button2")
						|| source.getId().equals("button3") || source.getId().equals("button4")

				))) {
			Button search = destination;
			source.getText();
			String temp_text_amemorriser = destination.getText();
			String temp_text_affecte = source.getText();
			for (int i = buttons.size() - 1; i >= 0; i--) {
				//System.out.println("search " + search);
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
				//System.out.println("search " + search);
				if (buttons.get(i).getId().equals((source.getId()))) {
					// temp_text = buttons.get(i).getText();
					buttons.get(i).setText(temp_text_affecte);
					System.out.println("Celui la" + buttons.get(i));
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
