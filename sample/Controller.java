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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
// all about sample page which is main scene

	//define the buttons and lable based on their id

@FXML

	public Button withdrawingButton;

@FXML
	public Button depositButton;
@FXML
    public Button checkBalenceButton;
@FXML
    public Button exitButton;
@FXML
    public Button AboutDeveloperButton;


//method for open withdraw page
public void withdraAdd() throws IOException{
	Stage stage = (Stage)withdrawingButton.getScene().getWindow();
	stage.close();
	Stage primaryStage = new Stage();

	Parent root = FXMLLoader.load(getClass().getResource("withdrawing.fxml"));
	primaryStage.setTitle("Withdrawing");
	primaryStage.setScene(new Scene(root));
	primaryStage.show();

}
//method for open deposit page
	public void depositeAdd() throws IOException{
		Stage stage = (Stage)depositButton.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("deposite.fxml"));
		primaryStage.setTitle("deposit");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}
	//method for  open check balance page
	public void checkBalenceAdd() throws IOException{
		Stage stage = (Stage)checkBalenceButton.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("checkBalence.fxml"));
		primaryStage.setTitle("Check Balance ");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

      // add event on withdraw button for open withdraw scene

	withdrawingButton.setOnAction(event -> {
		try {
			withdraAdd();
		} catch (IOException e) {
			e.printStackTrace();
		}
	});

	// add event on deposit button for open deposit scene
	depositButton.setOnAction(event -> {
		try {
			depositeAdd();
		} catch (IOException e) {
			e.printStackTrace();
		}
	});

        // add event on checkBalance button for open check Balance page
	checkBalenceButton.setOnAction(event -> {
		try {
			checkBalenceAdd();
		} catch (IOException e) {
			e.printStackTrace();
		}
	});

     // add event on exite button for exit
	exitButton.setOnAction(event -> System.exit(0));


	AboutDeveloperButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("ATM Machine");
			alert.setHeaderText("Tanaya Prakash Deshmukh");
			alert.setContentText("   Hello There \n I understand that technology should be user-friendly " +
					"Coding is not just a hobby for me; it's a way of expressing my " +
					"creativity, solving complex puzzles, and bringing innovative ideas to life.");
			alert.show();
		}
	});

	}







}
