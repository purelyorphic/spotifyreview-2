# data_loader.py

import csv
from collections import defaultdict

def load_tracks(file_path):
    tracks = []
    with open(file_path, 'r', encoding='utf-8') as f:
        reader = csv.DictReader(f)
        for row in reader:
            try:
                track = {
                    'track_name': row['track_name'],
                    'artist': row['artist'],
                    'genre': row['genre'],
                    'energy': float(row['energy']),
                    'danceability': float(row['danceability']),
                    'popularity': int(row['popularity']),
                    'tempo': float(row['tempo'])
                }
                tracks.append(track)
            except Exception as e:
                continue  # skip rows with errors
    return tracks

def group_by_genre(tracks):
    genre_map = defaultdict(list)
    for track in tracks:
        genre_map[track['genre']].append(track)
    return dict(genre_map)
