/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import database.Setting;
import database.requeteSql;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Fiche;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class HomeController implements Initializable {
    @FXML
    private TableView<Fiche> table;
    @FXML
    private TableColumn<Fiche, String> colNumCarte;
    @FXML
    private TableColumn<Fiche, String> colNom;
    @FXML
    private TableColumn<Fiche, String> colPostNom;
    @FXML
    private TableColumn<Fiche, String> colPrenom;
    @FXML
    private TableColumn<Fiche, String> colSexe;
    @FXML
    private TableColumn<Fiche, String> colDateNaissance;
    @FXML
    private TableColumn<Fiche, String> colIeuNaissance;
    @FXML
    private TableColumn<Fiche, String> colProvinceOrigine;
    @FXML
    private TableColumn<Fiche, String> colAdresse;
    @FXML
    private TableColumn<Fiche, String> colEmail;
    @FXML
    private TableColumn<Fiche, String> colPhone;
    @FXML
    private TableColumn<Fiche, String> colDiplome;
    @FXML
    private TableColumn<Fiche, String> colEtatCivil;
    @FXML
    private JFXButton btnNew;
  ObservableList<Fiche> ob = FXCollections.observableArrayList();
    Setting s;
    requeteSql req = new requeteSql();
    ResultSet rs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    initTable();
    }

    void initCell() {
        colNumCarte.setCellValueFactory(new PropertyValueFactory<>("numCarte"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPostNom.setCellValueFactory(new PropertyValueFactory<>("postnom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        colDateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        colIeuNaissance.setCellValueFactory(new PropertyValueFactory<>("provinceOrigine"));
        colProvinceOrigine.setCellValueFactory(new PropertyValueFactory<>("lieuNaissance"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("numTelephone"));
        colDiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
        colEtatCivil.setCellValueFactory(new PropertyValueFactory<>("etatCivil"));
    }
    
    void initTable(){
        initCell();
        table.getItems().clear();
        rs = req.getListRecrutement();
        try {
            int n = 1;
            while (rs.next()) {
                ob.add(new Fiche(rs.getString("numCarte"), rs.getString("nom"), rs.getString("postnom"),rs.getString("prenom"), rs.getString("sexe"), rs.getString("dateNaissance"), rs.getString("lieuNaissance"), rs.getString("provinceOrigine"), rs.getString("adresse"), rs.getString("email"), rs.getString("numPhone"), rs.getString("diplome"), rs.getString("etatCivil")));

                n++;
            }
        } catch (Exception e) {
            System.err.println("error on init person " + e);
        }

        table.setItems(ob);  
    }
    @FXML
    private void btnNew(ActionEvent event) {
           try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("/vue/Enregistrement.fxml"));

            Scene scene = new Scene(loader);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            Stage stage = (Stage) btnNew.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("error scene" + e);
        }
    }
    
}
