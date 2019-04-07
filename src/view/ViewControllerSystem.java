package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ViewControllerSystem
{
    private SystemGUI gui;
    private Scene scene;
    @FXML
    private TextField textFieldStartDateThermal; //check the correct format
    @FXML
    private TextField textFieldEndDateThermal;
    @FXML
    private TextField textFieldStartDatePV;
    @FXML
    private TextField textFieldEndDatePV;

    public ViewControllerSystem(SystemGUI gui)  throws IOException
    {
        this.gui = gui;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SolarPanelSoftware.fxml"));

        loader.setController(this);

        Pane root = loader.load();

        this.scene = new Scene(root, 1000, 1000); //change values + set min size
    }

    public Scene getScene() //needed in SystemGUI
    {
        return scene;
    }

    @FXML
    public void getPVData(ActionEvent event)
    {
       gui.getController().retrievePVDates();
    }

    @FXML
    public void getThermalData(ActionEvent event)
    {
        gui.getController().retrieveThermalDates();
    }

    @FXML
    public void getPrediction(ActionEvent event)
    {
        gui.getController().executeGetPredictionData();
    }

    public String[] retrieveThermalDates()
    {
        return new String[] {textFieldStartDateThermal.getText(), textFieldEndDateThermal.getText()};
    }

    public String[] retrievePVDates()
    {
        return new String[] {textFieldStartDatePV.getText(), textFieldEndDatePV.getText()};
    }
}
