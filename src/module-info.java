module java.practice {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    opens sample;
    opens sample.print_screen;
}