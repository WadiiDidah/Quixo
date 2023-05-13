package Model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MultiMode implements GameMode {

	@Override
	public void CreerZone(MouseEvent e) throws IOException {
		 Node source = null;
			try {
				source = (Node) e.getSource();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			Partie partie= Partie.GetPatie();
			    Stage stage  = (Stage) source.getScene().getWindow();
			    stage.close();//
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//Vue//multi.fxml")); 
		        Parent root1 = (Parent) fxmlLoader.load();
		        stage.setScene(new Scene(root1,800,500));  
		        stage.show();
		
	}

}
