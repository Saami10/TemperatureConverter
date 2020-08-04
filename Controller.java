package com.internshala.Javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label codelabel;
	@FXML
	public ChoiceBox<String> codechbox;
	@FXML
	public TextField codetext;
	@FXML
	public Button codebtn;
	private static final String ctof="Celsius to Fahrenheit";
	private static final String ftoc="Fahrenheit to Celsius";
	private boolean isctof=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codechbox.getItems().add(ctof);
		codechbox.getItems().add(ftoc);
		codechbox.setValue(ctof);
		codechbox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			if (newValue.equals(ctof))
				isctof=true;
			else
				isctof=false;
		});
		codebtn.setOnAction(event -> convert());

	}
	float inputtemp;

	private void convert() {
		String input=codetext.getText();
		try {
			inputtemp = Float.parseFloat(input);
		} catch (Exception exception){
			warnUser();
			return;
		}
		float newtemp=0.0f;
		if(isctof)
			newtemp=(inputtemp*9/5)+32;
		else
			newtemp=(inputtemp-32)*5/9;

		display(newtemp);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("INVALID TEMPERATYRE ENTERED");
		alert.setContentText("Enter Numeric Value");
		alert.show();
	}

	private void display(float newtemp) {
		String unit= isctof? "F":"C";
		//System.out.println("The New Temperature is "+newtemp+unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The New Temperature is "+newtemp+unit);
		alert.show();

	}
}
