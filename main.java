import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Load dataset
        List<SpotifyTrack> tracks = DataLoader.loadTracks("data/spotify_dataset.csv");
        Map<String, List<SpotifyTrack>> genreMap = DataLoader.groupByGenre(tracks);

        // Genre dropdown
        ComboBox<String> genreDropdown = new ComboBox<>();
        genreDropdown.getItems().addAll(genreMap.keySet());
        genreDropdown.setPromptText("Select Genre");
        root.setTop(genreDropdown);

        // Default chart
        ScatterChart<Number, Number> chart = ChartUtils.createEnergyVsDanceabilityChart(tracks);
        root.setCenter(chart);

        // Update on selection
        genreDropdown.setOnAction(e -> {
            String selected = genreDropdown.getValue();
            List<SpotifyTrack> filtered = genreMap.getOrDefault(selected, tracks);
            ScatterChart<Number, Number> updatedChart = ChartUtils.createEnergyVsDanceabilityChart(filtered);
            root.setCenter(updatedChart);
        });

        primaryStage.setTitle("Spotify Visualization - JavaFX");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
