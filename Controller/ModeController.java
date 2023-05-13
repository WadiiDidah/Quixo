package Controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Controller.*;
import Model.GameMode;
import Model.GameModeFactory;
import Model.OrganiserPlateauMulti;
import Model.OrganiserPlateauSingle;
import Model.Partie;
import Model.SingleMode;
public class ModeController {

	public void homme_contre_ia(javafx.scene.input.MouseEvent e) throws IOException {
		/*System.out.println("Heeeey clicked ia");
		 Node source = null;
			try {
				source = (Node) e.getSource();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			    Stage stage  = (Stage) source.getScene().getWindow();
			    stage.close();//
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//Vue//Main.fxml")); 
		        Parent root1 = (Parent) fxmlLoader.load();
		        stage.setScene(new Scene(root1,800,500));  
		        stage.show();*/
		Partie partie= Partie.GetPatie();
		OrganiserPlateauMulti org = new OrganiserPlateauMulti();
		partie.setOrganiserPlateau(org);
		GameModeFactory gm = new GameModeFactory();
		 GameMode sm= gm.getGameMode("s");
		 sm.CreerZone(e);
		
	}
	 public void homme_contre_homme(javafx.scene.input.MouseEvent e) throws IOException {
		 Partie partie= Partie.GetPatie();
		 OrganiserPlateauSingle org = new OrganiserPlateauSingle();
		 partie.setOrganiserPlateau(org);
		 GameModeFactory gm = new GameModeFactory();
		 GameMode sm= gm.getGameMode("m");
		 sm.CreerZone(e);
		 
	 }
}
