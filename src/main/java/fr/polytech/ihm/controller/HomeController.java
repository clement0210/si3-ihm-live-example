package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Department;
import fr.polytech.ihm.model.Internship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private TableView<Department> depTable;

    @FXML
    private TableColumn<Department, String> tag;

    @FXML
    private TableColumn<Department, String> name;

    @FXML
    private TableColumn<Department, String> room;

    @FXML
    public void initialize() {
        List<Internship> siInternships = Arrays.asList(new Internship("SI3: Stage ouvrier", "Stage de 3 semaines minimum en été"),
                new Internship("SI4: Stage développeur", "Stage de 5 semaines minimum en été"),
                new Internship("SI5: Stage ingénieur", "Stage de 5 mois minimum entre mars et septembre"));
        List<Internship> elecInternships = Arrays.asList(new Internship("SI3: Stage ouvrier", "Stage de 3 semaines minimum en été"),
                new Internship("SI4: Stage technicien", "Stage de 5 semaines minimum en été"),
                new Internship("SI5: Stage ingénieur", "Stage de 5 mois minimum entre mars et septembre"));

        ObservableList<Department> departments = FXCollections.observableArrayList();
        departments.add(new Department("SI", "Sciences Informatiques", "O+110", Color.BLUEVIOLET, siInternships));
        departments.add(new Department("ELEC", "Electronique", "O+111", Color.ORANGE, elecInternships));

        tag.setCellValueFactory(cellData -> cellData.getValue().tagNameProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        room.setCellValueFactory(cellData -> cellData.getValue().meetingRoomProperty());

        depTable.setItems(departments);
        depTable.setRowFactory(tv -> {
            TableRow<Department> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    displayDepartment(row.getItem());
                }
            });
            return row;
        });
    }

    private void displayDepartment(Department department) {
        String fxmlFile = "/fxml/polytech_department.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Stage stage = (Stage) depTable.getScene().getWindow();
            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootNode);
            stage.setScene(scene);
            ((DepartmentController) loader.getController()).initDepartement(department);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
