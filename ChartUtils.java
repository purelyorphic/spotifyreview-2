import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;

import java.util.List;

public class ChartUtils {
    public static ScatterChart<Number, Number> createEnergyVsDanceabilityChart(List<SpotifyTrack> tracks) {
        NumberAxis xAxis = new NumberAxis("Danceability", 0, 1, 0.1);
        NumberAxis yAxis = new NumberAxis("Energy", 0, 1, 0.1);

        ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
        chart.setTitle("Energy vs Danceability");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Tracks");

        for (SpotifyTrack t : tracks) {
            XYChart.Data<Number, Number> point = new XYChart.Data<>(t.danceability, t.energy);
            series.getData().add(point);

            // Add tooltip after scene is rendered
            point.nodeProperty().addListener((obs, oldNode, newNode) -> {
                if (newNode != null) {
                    Tooltip tooltip = new Tooltip(t.trackName + " - " + t.artist);
                    Tooltip.install(newNode, tooltip);
                }
            });
        }

        chart.getData().clear();
        chart.getData().add(series);
        return chart;
    }
}
