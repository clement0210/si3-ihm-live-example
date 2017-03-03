package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Department;
import fr.polytech.ihm.model.Internship;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;

/**
 * Created by cduffau on 03/02/17.
 */
public class DepartmentController {

    @FXML
    private ListView<Internship> internshipsListView;

    @FXML
    private Label name;

    @FXML
    private BorderPane rootPane;

    @FXML
    private void initialize() {
    }

    public void initDepartement(Department department) {
        this.name.setText(department.getName());
        this.internshipsListView.setItems(department.getInternships());
        this.internshipsListView.setCellFactory(
                new Callback<ListView<Internship>, ListCell<Internship>>() {
                    @Override
                    public ListCell<Internship> call(ListView<Internship> listView) {
                        // Cette cellule personalisée pourrait (devrait) être placée dans une classe à part
                        return new ListCell<Internship>() {
                            @Override
                            protected void updateItem(Internship item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item != null) {
                                    // Load fxml file for this internship
                                    try {
                                        String fxmlFile = "/fxml/dep_internship_list_element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((InternshipController) loader.getController()).initInternship(item);
                                        // Display content of the fxml file
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                });

        // Include from the code a different fxml file
        displayAdBanner(department);
    }

    private void displayAdBanner(Department department) {
        String fxmlFile = "/fxml/dep_ad_banner.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            ((DepartmentAdController) loader.getController()).initDepartment(department);
            this.rootPane.setRight(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
