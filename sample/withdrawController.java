/**
 * Created by TANAYA on 12-08-2023.
 */



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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;


public class withdrawController implements Initializable{
//define all fields on withdrawal scene

	@FXML
	public Label atmLabel;

	@FXML
	public Label withdrawLabel;

	@FXML
	public TextField NameTextField;

	@FXML
	public TextField AmountTextField;

	@FXML
	public Button OKbutton;

	@FXML
	public Button ExitButton;

	@FXML
	public Button HomeButton;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//give the work og exit button
		ExitButton.setOnAction(event -> System.exit(0));

		//take input from user alos add action on deposite button (ok button)
		OKbutton.setOnAction(event -> {
			String depositname = NameTextField.getText();
			System.out.println(depositname);
			String depositeAmmount = AmountTextField.getText();
			float depoammount=Float.parseFloat(depositeAmmount);
			System.out.println(depoammount);


			//all about withdrawal process
			String fileName = "records.properties";

			Properties properties = new Properties();

			try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
				properties.load(fileInputStream);

				String valueStr = properties.getProperty(depositname);
				if (valueStr != null) {
					float oldValue = Float.parseFloat(valueStr);


					float subtractValue = depoammount;

					float newValue = oldValue - subtractValue;
					properties.setProperty(depositname, Float.toString(newValue));

					try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
						properties.store(fileOutputStream, "Updated Key-Value Pairs");
						System.out.println("Updated value for key '" + depositname + "': " + newValue);
					} catch (IOException e) {
						System.err.println("Error writing to file: " + e.getMessage());
					}
				} else {
					System.out.println("Key '" + depositname + "' not found.");
				}
			} catch (IOException e) {
				System.err.println("Error reading Your Records: " + e.getMessage());
			}

           // add alert box on withdraw button
			Alert alertforok = new Alert(Alert.AlertType.INFORMATION);
			alertforok.setTitle("ATM Machine");
			alertforok.setHeaderText("Alert For Withdrawal");


			alertforok.setContentText("Your Amount Is Withdrawing Please Collect Your Cash");
			alertforok.show();


		});
		//set home scene on home button
		HomeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

					Stage stage = (Stage) HomeButton.getScene().getWindow();
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
