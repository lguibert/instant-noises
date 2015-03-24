package fr.tpdo.instant_noises;

/**
 * Created by Lucas on 23/03/2015.
 */
public class Noise {
    private String label;
    private String image;
    private String sound;
    private int idCategory;

    public Noise() {
    }

    public Noise(String label, String sound, String image, int idCategory) {
        this.label = label;
        this.sound = sound;
        this.image = image;
        this.idCategory = idCategory;

    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
