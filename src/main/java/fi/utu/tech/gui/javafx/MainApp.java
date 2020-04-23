package fi.utu.tech.gui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	/**
	 * JavaFX:n start-metodi saa parametrikseen Stage-luokan olion. Parent-tyypin root-olio muodostetaan
	 * FXMLLoader:lla, joka lataa Laskin.fxml-resurssin. Scene-olio muodostetaan root-olion perusteella
	 * ja scene tyylitetään styles.css-tiedoston perusteella. Ohjelmalle annetaan nimeksi Basic Calculator.
	 * @param Stage stage
	 */
	
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Laskin.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        stage.setTitle("Basic Calculator");
        stage.setScene(scene);
        stage.show();
    }
}