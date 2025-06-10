# main.py

import tkinter as tk
from tkinter import ttk
from chart_utils import create_energy_vs_danceability_chart, create_popularity_bar_chart
from data_loader import load_tracks, group_by_genre

import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg

class SpotifyApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Spotify Data Visualization")

        self.tracks = load_tracks("data/spotify_dataset.csv")
        self.genre_map = group_by_genre(self.tracks)

        # Dropdown
        self.genre_var = tk.StringVar()
        self.genre_dropdown = ttk.Combobox(self.root, textvariable=self.genre_var)
        self.genre_dropdown['values'] = list(self.genre_map.keys())
        self.genre_dropdown.set("Select Genre")
        self.genre_dropdown.pack(pady=10)

        self.chart_frame = tk.Frame(self.root)
        self.chart_frame.pack(fill=tk.BOTH, expand=True)

        # Buttons
        tk.Button(self.root, text="Energy vs Danceability", command=self.show_scatter).pack()
        tk.Button(self.root, text="Avg Popularity by Genre", command=self.show_bar).pack()

    def show_chart(self, fig):
        for widget in self.chart_frame.winfo_children():
            widget.destroy()

        canvas = FigureCanvasTkAgg(fig, master=self.chart_frame)
        canvas.draw()
        canvas.get_tk_widget().pack(fill=tk.BOTH, expand=True)

    def show_scatter(self):
        selected = self.genre_var.get()
        data = self.genre_map.get(selected, self.tracks)
        fig = create_energy_vs_danceability_chart(data)
        self.show_chart(fig)

    def show_bar(self):
        fig = create_popularity_bar_chart(self.genre_map)
        self.show_chart(fig)

if __name__ == "__main__":
    root = tk.Tk()
    app = SpotifyApp(root)
    root.mainloop()
