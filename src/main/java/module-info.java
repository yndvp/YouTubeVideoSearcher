module com.example.youtubevideosearcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.youtubevideosearcher to javafx.fxml;
    exports com.example.youtubevideosearcher;
    exports com.example.youtubevideosearcher.Controllers;
    opens com.example.youtubevideosearcher.Controllers to javafx.fxml;
    exports com.example.youtubevideosearcher.Models;
    opens com.example.youtubevideosearcher.Models to javafx.fxml;
}