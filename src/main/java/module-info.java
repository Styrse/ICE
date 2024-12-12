module ice.ice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ice.ice to javafx.fxml;
    exports ice.ice;
    exports ice.ice.controllers;
    opens ice.ice.controllers to javafx.fxml;
}