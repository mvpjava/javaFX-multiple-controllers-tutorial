package com.mvp.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class LoggerTabController {

    @FXML private VBox loggerTab;
    @FXML private TextArea loggerTxtArea;
    
    public TextArea getLoggerTxtArea() {
        return loggerTxtArea;
    }
    
}
