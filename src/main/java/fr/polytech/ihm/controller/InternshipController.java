package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Internship;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by camillie on 03/03/17.
 */
public class InternshipController {
    @FXML
    private Label labelTitle;

    @FXML
    private Label labelContent;

    public void initInternship(Internship internship) {
        labelTitle.setText(internship.getTitle());
        labelContent.setText(internship.getDescription());
    }
}
