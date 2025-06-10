import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class DataLoader {
    public static List<SpotifyTrack> loadTracks(String filePath) {
        List<SpotifyTrack> trackList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < 7) continue; // Safety check

                String name = fields[0];
                String artist = fields[1];
                String genre = fields[2];
                double energy = Double.parseDouble(fields[3]);
                double danceability = Double.parseDouble(fields[4]);
                int popularity = Integer.parseInt(fields[5]);
                double tempo = Double.parseDouble(fields[6]);

                SpotifyTrack track = new SpotifyTrack(name, artist, genre, energy, danceability, popularity, tempo);
                trackList.add(track);
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
        return trackList;
    }

    public static Map<String, List<SpotifyTrack>> groupByGenre(List<SpotifyTrack> tracks) {
        Map<String, List<SpotifyTrack>> genreMap = new HashMap<>();
        for (SpotifyTrack track : tracks) {
            genreMap.computeIfAbsent(track.genre, k -> new ArrayList<>()).add(track);
        }
        return genreMap;
    }
}
