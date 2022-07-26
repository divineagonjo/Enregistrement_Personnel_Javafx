/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.requeteSql;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Fiche;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EnregistrementController implements Initializable {
    @FXML
    private AnchorPane panel1;
    @FXML
    private JFXTextField txtNumCarte;
    @FXML
    private JFXTextField txtNom;
    @FXML
    private JFXTextField txtPostNom;
    @FXML
    private JFXTextField txtPrenom;
    @FXML
    private JFXComboBox<String> cmbSexe;
    @FXML
    private DatePicker txtDateNaissance;
    @FXML
    private JFXTextField txtLieuNaissance;
    @FXML
    private JFXButton btnPrec;
    @FXML
    private JFXButton btnFinish;
    @FXML
    private AnchorPane panel2;
    @FXML
    private JFXTextField txtPaysOrigine;
    @FXML
    private JFXTextField txtAdresse;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtNumPhone;
    @FXML
    private JFXComboBox<String> cmbDiplome;
    @FXML
    private JFXComboBox<String> cmbEtatCivil;
    @FXML
    private JFXButton btnNext;
    @FXML
    private JFXButton btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbDiplome.getItems().addAll("D6","Graduat", "Licence","Doctorat");
        cmbEtatCivil.getItems().addAll("Celibataire","Marié(e)","Divorcé","Veuf(ve)");
        cmbSexe.getItems().addAll("Homme","Femme");
        panel1.setVisible(true);
        panel2.setVisible(false);
    }    

    @FXML
    private void onPrecedant(ActionEvent event) {
        panel1.setVisible(true);
        panel2.setVisible(false);
    }

    @FXML
    private void onFinish(ActionEvent event) {
        Fiche fiche =new Fiche(txtNumCarte.getText(), txtNom.getText(), txtPostNom.getText(), txtPrenom.getText(), cmbSexe.getSelectionModel().getSelectedItem(), txtDateNaissance.getValue().toString(), txtLieuNaissance.getText(), txtPaysOrigine.getText(), txtAdresse.getText(), txtEmail.getText(), txtNumPhone.getText(), cmbDiplome.getSelectionModel().getSelectedItem(), cmbEtatCivil.getSelectionModel().getSelectedItem());
        requeteSql requete=new requeteSql();
        requete.addRecrutement(fiche);
          try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("/vue/Home.fxml"));

            Scene scene = new Scene(loader);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("error scene" + e);
        }
    }

    @FXML
    private void onNext(ActionEvent event) {
        panel1.setVisible(false);
        panel2.setVisible(true);
    }

    @FXML
    private void onClose(ActionEvent event) {
         try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("/vue/Home.fxml"));

            Scene scene = new Scene(loader);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("error scene" + e);
        }
    }
    
}
