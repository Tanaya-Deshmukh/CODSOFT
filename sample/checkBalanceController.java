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
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by TANAYA on 12-08-2023.
 */
public class checkBalanceController implements Initializable{


    String worn;
    String values;



	//define all fields
  @FXML
  public Label machineLabel;

  @FXML
	public Label checkBalanceLabel;

  @FXML
	public TextField checkBalenceTextField;

  @FXML
	public Button exitCheckBalenceButton;

  @FXML
	public Button okcheckbalancebutton;

  @FXML
  public Button HomeForCheckButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//set action on exit button
		exitCheckBalenceButton.setOnAction(event -> System.exit(0));

       // set action on check balance  button
		okcheckbalancebutton.setOnAction(event -> {
			try {
				deposit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});


		HomeForCheckButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) HomeForCheckButton.getScene().getWindow();
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

	private void deposit() throws IOException {
		String depositname = checkBalenceTextField.getText();
		System.out.println(depositname);

		Alert alertforok = new Alert(Alert.AlertType.INFORMATION);
		alertforok.setTitle("ATM Machine");

         //all about search name and value
		String fileName = "records.properties";


		Properties properties = new Properties();

		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			properties.load(fileInputStream);

			String value = properties.getProperty(depositname);

			if (value != null) {
				values=(depositname +" Your Balance is"+ " : " + value);
			} else {
				values =(depositname + " not found.");
			}
		} catch (IOException e) {
			 worn = ("Error reading from file: " + e.getMessage());
		}
		System.out.println(worn);

		alertforok.setContentText(values);
		alertforok.show();
	}
}
