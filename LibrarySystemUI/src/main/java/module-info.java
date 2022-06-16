module pl.polsl.librarysystemui {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.polsl.librarysystemui to javafx.fxml;
    opens pl.polsl.librarysystemui.model to javafx.base;
    opens pl.polsl.librarysystemui.controller to javafx.base;
    exports pl.polsl.librarysystemui;
    exports pl.polsl.librarysystemui.model;
    requires gson;
    requires java.sql;
    requires javafx.graphicsEmpty;
    requires java.logging;
    requires java.base;
    
}
