# 🎧 Spotify Recommendation Data Visualization (JavaFX)

## 📌 Objective
Visualize and explore audio features from the Spotify recommendation dataset using JavaFX. The project focuses on identifying trends and patterns across genres, tempo, danceability, energy, and popularity.

## 📊 Charts Implemented
- Scatter plot: Energy vs. Danceability
- Bar chart: Top Genres by Average Popularity
- Line chart: Tempo trends across genres (if release year available)
- Filter by Genre (interactive)
- Tooltips on hover

## 🖱️ Interactivity
- Use the dropdown menu to filter by genre.
- Hover over data points to see track details.

## 🚀 How to Run
1. Install Java 11+ and JavaFX SDK.
2. Import the project into your IDE (IntelliJ, Eclipse).
3. Run `Main.java`.

## ✅ Accuracy Checks
- Validated missing/null fields.
- Normalized tempo and loudness for comparison.
- Cross-checked genre consistency.

## 🧠 Insights
- High danceability does not always mean high energy.
- Pop genre dominates in popularity but not always in energy.
- Certain genres like "EDM" and "Hip-Hop" show distinct valence and tempo patterns.
