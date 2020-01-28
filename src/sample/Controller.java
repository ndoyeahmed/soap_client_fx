package sample;


import com.exo.soap.service.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final String ERRORECHEC = "Echec de l'opération, une erreur est survenue";
    private static final String ECHEC = "Echec de l'opération";
    private static final String ERROR = "Error";
    private static final String SUCCESS = "Succès";
    private static final String OPERATIONSUCCESS = "Opération effectuée avec succès";

    @FXML
    private TextField tbxNom;

    @FXML
    private TextField tbxPrenom;

    @FXML
    private TextField tbxTelephone;

    @FXML
    private TextArea tbxAdresse;

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnActualiser;

    @FXML
    private TableView<Personne> tvListPersonne;

    @FXML
    private TableColumn<Personne, String> tcNom;

    @FXML
    private TableColumn<Personne, String> tcPrenom;

    @FXML
    private TableColumn<Personne, String> tcTelephone;

    @FXML
    private TableColumn<Personne, String> tcAdresse;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    private ObservableList<Personne> listPersonne;

    private boolean validateFields() {
        return !tbxNom.getText().equals("")
                && !tbxPrenom.getText().equals("")
                && !tbxTelephone.getText().equals("")
                && !tbxAdresse.getText().equals("");
    }

    private void alertError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void alertInformation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        tbxAdresse.setText("");
        tbxNom.setText("");
        tbxPrenom.setText("");
        tbxTelephone.setText("");
    }

    private void cellValueFactory() {
        tcAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tcTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
    }

    private void loadData() {
        listPersonne = FXCollections.observableArrayList();
        Utils utils = new Utils();
        listPersonne.addAll(utils.getPersonneService().personneList());
        tvListPersonne.setItems(listPersonne);
    }

    public void activer() {
        btnAjout.setDisable(false);
        btnActualiser.setDisable(true);
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
    }

    public void desactiver() {
        btnAjout.setDisable(true);
        btnActualiser.setDisable(false);
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    }

    private void refreshTableView() {
        cellValueFactory();
        loadData();
    }

    @FXML
    void getPersonne(MouseEvent event) {
        Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
        tbxTelephone.setText(personne.getTelephone());
        tbxPrenom.setText(personne.getPrenom());
        tbxNom.setText(personne.getNom());
        tbxAdresse.setText(personne.getAdresse());
        desactiver();
    }

    @FXML
    void actualiseInfo(ActionEvent event) {
        activer();
        refreshTableView();
        clearFields();
    }

    @FXML
    void addPersonne(ActionEvent event) {
        try {
            if (validateFields()) {
                Personne personne = new Personne();
                personne.setNom(tbxNom.getText());
                personne.setPrenom(tbxPrenom.getText());
                personne.setTelephone(tbxTelephone.getText());
                personne.setAdresse(tbxAdresse.getText());
                Utils utils = new Utils();
                if (utils.getPersonneService().addPersonne(personne)) {
                    alertInformation(SUCCESS, OPERATIONSUCCESS);
                    clearFields();
                    refreshTableView();
                } else {
                    alertError(ERROR, ECHEC);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }

    @FXML
    void deletePersonne(ActionEvent event) {
        try {
            desactiver();
            Utils utils = new Utils();
            Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
            if (utils.getPersonneService().deletePersonne(personne.getId())) {
                alertInformation(SUCCESS, OPERATIONSUCCESS);
                refreshTableView();
                clearFields();
            } else {
                alertError(ERROR, ECHEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }

    @FXML
    void updatePersonne(ActionEvent event) {
        try {
            desactiver();
            Utils utils = new Utils();
            Personne personne = tvListPersonne.getSelectionModel().getSelectedItem();
            personne.setAdresse(tbxAdresse.getText());
            personne.setTelephone(tbxTelephone.getText());
            personne.setPrenom(tbxPrenom.getText());
            personne.setNom(tbxNom.getText());
            if (utils.getPersonneService().updatePersonne(personne.getId(), personne)) {
                alertInformation(SUCCESS, OPERATIONSUCCESS);
                refreshTableView();
                clearFields();
            } else {
                alertError(ERROR, ECHEC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError(ERROR, ERRORECHEC);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            activer();
            cellValueFactory();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
