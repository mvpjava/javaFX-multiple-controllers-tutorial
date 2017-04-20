package com.mvp.java.controllers;

import com.mvp.java.services.MissionsService;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ConsoleTabController {

    @FXML private TextArea missionOverviewText;
    @FXML private ListView<String> missionsList;

    private final MissionsService service = new MissionsService();
    private MainController mainController;
    
    public void injectMainController(MainController mainController){
        this.mainController = mainController;
    }
    
    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Apollo", "Shuttle", "Skylab");
        missionsList.setItems(missions);
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        missionOverviewText.clear();
        final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        missionOverviewText.positionCaret(0);
        missionOverviewText.appendText(getInfo(selectedItem));
    }
 
    public String getInfo(String selectedItem) {
        PrintWriter stackTraceWriter = new PrintWriter(new StringWriter());
        String missionInfo = null ;
                
        try {
            missionInfo = service.getMissionInfo(selectedItem); 
            getLog().appendText("Sucessfully retrieved mission info for " + selectedItem + "\n");
        } catch (IOException exception) {
            exception.printStackTrace (stackTraceWriter);
            getLog().appendText(stackTraceWriter.toString() + "\n");
        }
        
        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return missionOverviewText;
    }

    public ListView<String> getMissionsList() {
        return missionsList;
    }
    
    private TextArea getLog(){
        return mainController.getVisualLog(); 
    }
}
