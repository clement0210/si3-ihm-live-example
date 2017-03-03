package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by cduffau on 02/02/17.
 */
public class Department {

    private StringProperty tagName;
    private StringProperty name;
    private StringProperty meetingRoom;
    private Color color;
    private ObservableList<Internship> internships;

    public Department(String tagName, String name, String meetingRoom, Color color, List<Internship> internships) {
        this.tagName = new SimpleStringProperty(tagName);
        this.name = new SimpleStringProperty(name);
        this.meetingRoom = new SimpleStringProperty(meetingRoom);
        this.color = color;
        this.internships = FXCollections.observableArrayList(internships);
    }

    public String getTagName() {
        return tagName.get();
    }

    public StringProperty tagNameProperty() {
        return tagName;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getMeetingRoom() {
        return meetingRoom.get();
    }

    public StringProperty meetingRoomProperty() {
        return meetingRoom;
    }

    public Color getColor() {
        return color;
    }

    public ObservableList<Internship> getInternships() {
        return internships;
    }
}
