package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	private final StringProperty name = new SimpleStringProperty();

    public StringProperty textProperty() {
        return name ;
    }

    public final String getName() {
        return textProperty().get();
    }

    public final void setName(String text) {
        textProperty().set(text);
    }
}
