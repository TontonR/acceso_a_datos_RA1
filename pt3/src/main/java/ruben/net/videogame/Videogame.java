package ruben.net.videogame;

public class Videogame {
    String title;
    String genre;
    int release_year;
    Platform platform;
    Double price;
    
    public Videogame(String title, String genre, int release_year, Platform platform, Double price) {
        this.title = title;
        this.genre = genre;
        this.release_year = release_year;
        this.platform = platform;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getRelease_year() {
        return release_year;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public Platform getPlatform() {
        return platform;
    }
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Videojoc[");
        sb.append("titol: ").append(title);
        sb.append(", gènere: ").append(genre);
        sb.append(", any de sortida: ").append(release_year);
        sb.append(", plataforma:").append(platform);
        sb.append(", preu:").append(price);
        sb.append(']');
        return sb.toString();
    }
    


}
