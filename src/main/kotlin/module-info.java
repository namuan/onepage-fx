module com.github.namuan.onepagefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.github.namuan.onepagefx to javafx.fxml;
    exports com.github.namuan.onepagefx;
}