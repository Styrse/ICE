module ice.ice {
    requires javafx.controls;
    requires javafx.fxml;


    opens ice.ice to javafx.fxml;
    exports ice.ice;
}