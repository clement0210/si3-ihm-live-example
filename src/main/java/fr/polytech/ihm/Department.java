package fr.polytech.ihm;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by cduffau on 02/02/17.
 */
public class Department {
    private StringProperty tagName;
    private StringProperty name;
    private StringProperty meetingRoom;

    public Department(String tagName, String name, String meetingRoom) {
        this.tagName = new SimpleStringProperty(tagName);
        this.name = new SimpleStringProperty(name);
        this.meetingRoom = new SimpleStringProperty(meetingRoom);
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
}
