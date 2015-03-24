package fr.tpdo.instant_noises;

/**
 * Created by Lucas on 24/03/2015.
 */
public class Category {
    private String name;
    private int id;
    private int idParent;

    public Category(String name, int idParent, int id) {
        this.name = name;
        this.idParent = idParent;
        this.id = id;
    }

    public int getIdParent() {

        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
