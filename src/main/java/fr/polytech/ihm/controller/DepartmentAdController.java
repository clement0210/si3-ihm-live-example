package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Department;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by camillieri on 03/03/17.
 */
public class DepartmentAdController {

    @FXML
    private Label lblName;

    public void initDepartment(Department department) {
        this.lblName.setText(department.getName());
        this.lblName.setTextFill(department.getColor());
    }
}
