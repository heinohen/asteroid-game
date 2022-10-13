module com.astse.astse {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.astse.astse to javafx.fxml;
    exports com.astse.astse;
}