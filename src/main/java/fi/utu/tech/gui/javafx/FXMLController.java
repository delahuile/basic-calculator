package fi.utu.tech.gui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Joonas Humalamäki
 *
 */
/**
 * @author Joonas Humalamäki
 *
 */
public class FXMLController {
	@FXML
	private Button num2;

	@FXML
	private Button num3;

	@FXML
	private Button num4;

	@FXML
	private Button num1;

	@FXML
	private Button num5;

	@FXML
	private Button num6;

	@FXML
	private Button num7;

	@FXML
	private Button num8;

	@FXML
	private Button num9;

	@FXML
	private Button plusminus;

	@FXML
	private Button num0;

	@FXML
	private Button dot;

	@FXML
	private Button times;

	@FXML
	private Button plus;

	@FXML
	private Button equals;

	@FXML
	private Button minus;

	@FXML
	private Button C;

	@FXML
	private Button back;

	@FXML
	private Button percent;

	@FXML
	private Button divided;

	@FXML
	private TextField result;
	
	double numb1;
	double numb2;
	double result2 = 0;
	int index=0;
	boolean point = false;
	
	/**
	 * Metodi saa parametrinaan JavaFX ActionEvent -olion event, joka liittyy johonkin 
	 * JavaFX näkymäverkon nappiin. Riippuen siitä, mitä nappia painetaan, toimitaan koodissa eri tavoilla.
	 * Esimerkiksi kun painetaan numeronappeja, näkymäverkon TextField:iin lisätään vastaava numero.
	 * @param ActionEvent event
	 */
	@FXML
	void CalculationEvent(ActionEvent event) {

		if (event.getSource() == num1) {
			result.appendText("1");
		} else if (event.getSource() == num2) {
			result.appendText("2");
		} else if (event.getSource() == num3) {
			result.appendText("3");
		} else if (event.getSource() == num4) {
			result.appendText("4");
		} else if (event.getSource() == num5) {
			result.appendText("5");
		} else if (event.getSource() == num6) {
			result.appendText("6");
		} else if (event.getSource() == num7) {
			result.appendText("7");
		} else if (event.getSource() == num8) {
			result.appendText("8");
		} else if (event.getSource() == num9) {
			result.appendText("9");
		} else if (event.getSource() == num0) {
			result.appendText("0");
		} else if (event.getSource() == dot && point == false) {
			result.appendText(".");
			point = true;
		} else if (event.getSource() == C) {
			result.setText("");
			numb1 = 0;
			numb2 = 0;
			index=0;
			point=false;
		} else if (event.getSource() == plusminus) {
			String tmp = result.getText();
			if (tmp.substring(0, 1).equals("-")) {
				result.setText(tmp.substring(1, tmp.length()));
			} else {
				result.setText("-" + tmp);
			}
		} else if (event.getSource() == plus) {
			numb1 = Double.parseDouble(result.getText());
			result.setText("");
			index = 1;
			point = true;
		} else if (event.getSource() == minus) {
			numb1 = Double.parseDouble(result.getText());
			result.setText("");
			index = 2;
			point = true;
		} else if (event.getSource() == times) {
			numb1 = Double.parseDouble(result.getText());
			result.setText("");
			index = 3;
			point = true;
		} else if (event.getSource() == divided) {
			numb1 = Double.parseDouble(result.getText());
			result.setText("");
			index = 4;
			point = true;
		} else if (event.getSource() == equals && index > 0) {
			numb2 = Double.parseDouble(result.getText());
			switch (index) {
			case 1: result.setText(String.valueOf(numb1+numb2));
				break;
			case 2: result.setText(String.valueOf(numb1-numb2));
			break;
			case 3: result.setText(String.valueOf(numb1*numb2));
			break;
			case 4: 
				if(numb2 != 0) {
					result.setText(String.valueOf(numb1/numb2));
				} else {
					result.setText("0");
				}
			break;
			default:
				break;
			}
		} else if (event.getSource() == back) {
			String tmp = result.getText();
			if (result.getText().length() != 0) {
				result.setText(tmp.substring(0, tmp.length()-1));	
			}
		

		} else if (event.getSource() == percent) {
			String tmp = result.getText();
			System.out.println(tmp.indexOf("."));
			if (!tmp.substring(0, 1).equals("-")) {
				if(tmp.indexOf(".") == -1) {
					if(tmp.length()==1) {
						result.setText("0.0" + tmp);
					} else if (tmp.length()==2) {
						result.setText("0." + tmp);
					} else if (tmp.length()>2) {
						result.setText(tmp.substring(0, tmp.length()-2) + "." + tmp.substring(tmp.length()-2, tmp.length()));
					}
				} else if (tmp.indexOf(".") == 1){
					if (tmp.length()==2) {
						result.setText("0.0" + tmp.substring(0, 1));
					} else if (tmp.length()>=3) {
						result.setText("0.0" + tmp.substring(0, 1) + tmp.substring(2, tmp.length()));
					}
				} else if (tmp.indexOf(".") == 2) {
					result.setText("0." + tmp.substring(0, 2) + tmp.substring(3, tmp.length()));
				} else if (tmp.indexOf(".") > 2) {
					result.setText(tmp.substring(0, tmp.indexOf(".")-2) + "." + tmp.substring(tmp.indexOf(".")-2, tmp.indexOf(".")) + tmp.substring(tmp.indexOf(".") + 1, tmp.length()));
				} 
				// onko seuraava tarpeellinen ?
				else {
					result.setText("0.00" + tmp.substring(2, tmp.length()));
				}
			}
			
		}

	}
}
