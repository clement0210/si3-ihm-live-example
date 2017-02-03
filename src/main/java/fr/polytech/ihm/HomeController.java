package fr.polytech.ihm;

import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private TableView<Department> depTable;

    @FXML
    private TableColumn<Department,String> tag;

    @FXML
    private TableColumn<Department,String> name;

    @FXML
    private TableColumn<Department,String> room;


    @FXML
    public void initialize(){
        ObservableList<Department> departments= FXCollections.observableArrayList();
        departments.add(new Department("SI","Sciences Informatiques", "O+110"));
        departments.add(new Department("ELEC","Electronique", "O+111"));

        tag.setCellValueFactory(cellData -> cellData.getValue().tagNameProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        room.setCellValueFactory(cellData -> cellData.getValue().meetingRoomProperty());

        depTable.setItems(departments);
        depTable.setRowFactory(tv -> {
            TableRow<Department> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY) {

                    Department clickedRow = row.getItem();
                    String fxmlFile = "/fxml/polytech_department.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    try {
                        Stage stage=(Stage) depTable.getScene().getWindow();
                        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                        Scene scene = new Scene(rootNode);
                        stage.setScene(scene);
                        ((DepartmentController)loader.getController()).initDepartement(clickedRow);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }


}
