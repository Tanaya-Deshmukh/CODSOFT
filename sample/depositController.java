package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.net.URL;

/**
 * Created by TANAYA on 12-08-2023.
 */
public class depositController implements Initializable{
    //define all fields

	float depoammount;
	String depositeAmmount;
	//checkBalanceController checkobg=new checkBalanceController();
	@FXML
	public Label atmMACHINEl;

	@FXML
	public Label depositelabel;

	@FXML
	public TextField nameDepositTextField;

	@FXML
	public TextField amountDepositTextField;

	@FXML
	public Button okDepositeButton;

	@FXML
	public Button exitDepositeButton;

	@FXML
	public Button HomeDepoButton;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//set action on exit button
		exitDepositeButton.setOnAction(event -> System.exit(0));

		//set action on deposite buttton
      okDepositeButton.setOnAction((ActionEvent event) -> {
	      String depositname = nameDepositTextField.getText();
	      System.out.println(depositname);
	       depositeAmmount = amountDepositTextField.getText();
	       depoammount=Float.parseFloat(depositeAmmount);
	      System.out.println(depoammount);
	      ////////////////////////////////////////////////////////////////
	       //file for deposit name

	      String fileName = "records.properties";
	      String updateKey = depositname;

	      Properties properties = new Properties();

	      try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
		      properties.load(fileInputStream);

		      String valueStr = properties.getProperty(updateKey);
		      float oldValue = 0.0f;

		      if (valueStr != null) {
			      oldValue = Float.parseFloat(valueStr);

		      }
		      float updateValue =depoammount;

		      float newValue = oldValue + updateValue;
		      properties.setProperty(updateKey, Float.toString(newValue));

		      try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
			      properties.store(fileOutputStream, "Updated Key-Value Pairs");

		      } catch (IOException e) {
			      System.err.println("Error writing to file: " + e.getMessage());
		      }
	      } catch (IOException e) {
		      System.err.println("Error reading from file: " + e.getMessage());
	      }
	      //create alert box for deposit
          Alert alertforok = new Alert(Alert.AlertType.INFORMATION);
          alertforok.setTitle("ATM Machine");
          alertforok.setHeaderText("Alert For Deposit");
          alertforok.setContentText("Your Amount Is Deposited");
	      alertforok.show();

      });
        //set action on home button
       HomeDepoButton.setOnAction(new EventHandler<ActionEvent>() {
	       @Override
	       public void handle(ActionEvent event) {


		       Stage stage = (Stage) HomeDepoButton.getScene().getWindow();
		       stage.close();
		       Stage primaryStage = new Stage();

		       Parent root = null;
		       try {
			       root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		       } catch (IOException e) {
			       e.printStackTrace();
		       }
		       primaryStage.setTitle("Home");
		       primaryStage.setScene(new Scene(root));
		       primaryStage.show();
	       }
       });
	}
}
