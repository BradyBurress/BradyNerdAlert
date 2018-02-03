/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author extre
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numColumns = 8;
    
    private grid.Checkerboard checkerboard;
   
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        checkerboard = new grid.Checkerboard(numRows, numColumns, stage.getWidth(), stage.getHeight());
        vBox.getChildren().add(checkerboard.getBoard());
        
        
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();

        
    }
    
    @FXML
    private void changeSize16(ActionEvent event){
        checkerboard.setRows(16);
        checkerboard.setColumns(16);
        refresh();
    }
    
    @FXML
    private void changeSize10(ActionEvent event){
        checkerboard.setRows(10);
        checkerboard.setColumns(10);
        refresh();
    }
    
    @FXML
    private void changeSize8(ActionEvent event){
        checkerboard.setRows(8);
        checkerboard.setColumns(8);
        refresh();
    }
    
    @FXML
    private void changeSize3(ActionEvent event){
        checkerboard.setRows(3);
        checkerboard.setColumns(3);
        refresh();
    }
    
    @FXML
    private void defaultColor(ActionEvent event){
        checkerboard.setLightColor(Color.RED);
        checkerboard.setDarkColor(Color.BLACK);
        refresh();
    }
    
    @FXML
    private void blueColor(ActionEvent event){
        checkerboard.setLightColor(Color.SKYBLUE);
        checkerboard.setDarkColor(Color.DARKBLUE);
        refresh();
    }
    
    @FXML
    private void handleRefresh(ActionEvent event) {
        refresh();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("clear");
        clearBoard();
    }
    
    
    private void refresh() {
        checkerboard.build(stage.getWidth(), stage.getHeight());
    }
    
    private void clearBoard() {
        checkerboard.clear();
    }
    

    
}
