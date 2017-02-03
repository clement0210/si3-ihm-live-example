package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * Created by cduffau on 03/02/17.
 */
public class DepartmentController {

    @FXML
    private Label name;

    @FXML
    private void initialize(){

    }

    public void initDepartement(Department department){
        name.setText(department.getName());
    }
}
