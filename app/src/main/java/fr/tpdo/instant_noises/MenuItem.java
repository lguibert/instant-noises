package fr.tpdo.instant_noises;

/**
 * Created by Lucas on 25/03/2015.
 */
import android.content.Context;

import java.util.List;

public class MenuItem {
    List<Category> categories;

    public MenuItem() {
    }

    public MenuItem(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }


}
