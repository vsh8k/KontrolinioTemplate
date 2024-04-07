module com.kontrolinis.template.kontroliniotemplate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.kontrolinis.template.kontroliniotemplate to javafx.fxml;
    exports com.kontrolinis.template.kontroliniotemplate;
}