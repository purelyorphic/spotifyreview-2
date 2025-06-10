public class SpotifyTrack {
    public String trackName;
    public String artist;
    public String genre;
    public double energy;
    public double danceability;
    public int popularity;
    public double tempo;

    public SpotifyTrack(String trackName, String artist, String genre,
                        double energy, double danceability, int popularity, double tempo) {
        this.trackName = trackName;
        this.artist = artist;
        this.genre = genre;
        this.energy = energy;
        this.danceability = danceability;
        this.popularity = popularity;
        this.tempo = tempo;
    }
}
