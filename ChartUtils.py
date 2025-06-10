# chart_utils.py

import matplotlib.pyplot as plt

def create_energy_vs_danceability_chart(tracks):
    fig, ax = plt.subplots(figsize=(8, 6))
    x = [t['danceability'] for t in tracks]
    y = [t['energy'] for t in tracks]
    labels = [f"{t['track_name']} - {t['artist']}" for t in tracks]

    scatter = ax.scatter(x, y, alpha=0.6, c='blue')
    ax.set_title("Energy vs Danceability")
    ax.set_xlabel("Danceability")
    ax.set_ylabel("Energy")
    ax.grid(True)
    return fig

def create_popularity_bar_chart(genre_map):
    genres = list(genre_map.keys())
    avg_popularities = [sum([t['popularity'] for t in genre_map[g]]) / len(genre_map[g]) for g in genres]

    fig, ax = plt.subplots(figsize=(10, 6))
    ax.bar(genres, avg_popularities, color='green')
    ax.set_title("Average Popularity by Genre")
    ax.set_ylabel("Popularity")
    ax.set_xticklabels(genres, rotation=45, ha='right')
    fig.tight_layout()
    return fig
