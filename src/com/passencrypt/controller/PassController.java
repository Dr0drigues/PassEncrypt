package com.passencrypt.controller;

import com.passencrypt.beans.Encryption;
import com.passencrypt.exception.CeasarEncryptException;
import com.passencrypt.types.CeasarEncrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    }

    public void generate(ActionEvent e) {
        try {
            resultText.setText(new CeasarEncrypt(pswdTxField.getText(), Integer.parseInt(paramTxField.getText())).getRetour());
        } catch (CeasarEncryptException e1) {
            e1.printStackTrace();
        }
    }

}
