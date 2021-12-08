module com.example.youtubevideosearcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.youtubevideosearcher to javafx.fxml, com.google.gson;
    exports com.example.youtubevideosearcher;
    opens com.example.youtubevideosearcher.Models to javafx.fxml, com.google.gson;
    opens com.example.youtubevideosearcher.Controllers to com.google.gson, javafx.fxml;
    exports com.example.youtubevideosearcher.Models;
    exports com.example.youtubevideosearcher.Controllers;
}