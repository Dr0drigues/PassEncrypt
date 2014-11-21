package com.passencrypt.controller;

import com.passencrypt.beans.Encryption;
import com.passencrypt.types.CeasarEncrypt;
import com.passencrypt.types.HebraicEncrypt;
import com.passencrypt.types.RandomEncrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import java.net.URL;
import java.util.ResourceBundle;

public class PassController implements Initializable {

    @FXML
    ComboBox<Encryption> encryptList;
    @FXML
    Button generateBtn;
    @FXML
    TextField pswdTxField;
    @FXML
    Label resultText;
    @FXML
    TextField paramTxField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEncryptionList();
    }

    private void setEncryptionList() {
        ObservableList<Encryption> list = FXCollections.observableArrayList(Encryption.values());
        encryptList.getItems().addAll(list);
        encryptList.getSelectionModel().select(0);
        encryptList.setOnAction((event) -> {
            switch (encryptList.getSelectionModel().getSelectedItem()) {
                case HEBRAIC:
                    paramTxField.setDisable(true);
                    paramTxField.setEditable(false);
                    pswdTxField.setDisable(false);
                    pswdTxField.setEditable(true);
                    break;
                case RANDOM:
                    paramTxField.setDisable(false);
                    paramTxField.setEditable(true);
                    pswdTxField.setDisable(true);
                    pswdTxField.setEditable(false);
                    break;
                case X_CEASAR:
                    paramTxField.setDisable(false);
                    paramTxField.setEditable(true);
                    pswdTxField.setDisable(false);
                    pswdTxField.setEditable(true);
                    break;
            }
        });
    }

    public void generate(ActionEvent e) {
        try {
            System.out.println(encryptList.getSelectionModel().getSelectedItem());
            switch (encryptList.getSelectionModel().getSelectedItem()) {
                case X_CEASAR:
                    resultText.setText(new CeasarEncrypt(pswdTxField.getText(), Integer.parseInt(paramTxField.getText())).getRetour());
                    break;
                case HEBRAIC:
                    resultText.setText(new HebraicEncrypt(pswdTxField.getText()).getRetour());
                    break;
                case RANDOM:
                    resultText.setText(new RandomEncrypt(Integer.parseInt(paramTxField.getText())).getRetour());
                    break;
                default:
                    new Popup();
                    break;
            }
        } catch (com.passencrypt.exception.EncryptException e1) {
            e1.printStackTrace();
        }
    }

}
