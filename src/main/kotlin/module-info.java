module com.github.namuan.onepagefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.google.gson;


    opens com.github.namuan.onepagefx to javafx.fxml, com.google.gson;
    exports com.github.namuan.onepagefx;
}