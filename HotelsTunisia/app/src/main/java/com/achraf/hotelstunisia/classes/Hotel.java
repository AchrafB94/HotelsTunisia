package com.achraf.hotelstunisia.classes;

public class Hotel {
    private final int name;
    private final int ville;
    private final int imageResource;
    private boolean isFavorite = false;

    public Hotel(int name, int ville, int imageResource) {
        this.name = name;
        this.ville = ville;
        this.imageResource = imageResource;
    }

    public int getName() {
        return name;
    }

    public int getVille() {
        return ville;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

}
