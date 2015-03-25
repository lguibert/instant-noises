package fr.tpdo.instant_noises;

import java.util.List;

/**
 * Created by Lucas on 24/03/2015.
 */
public class  CategoryCtrl  {
    private List<Category> categories;

    public CategoryCtrl(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategoryWithId(int id){
        Category category = null;

        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getId() == id){
                category = new Category(categories.get(i).getName(),categories.get(i).getIdParent(), categories.get(i).getId());
                break;
            }
        }

        return category;
    }

    public String getNameWithId(int id){
        String name = "";

        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getId() == id){
                name = categories.get(i).getName();
                break;
            }
        }

        return name;
    }

    public Category getParentWithId(int id){
        Category category = null;

        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getIdParent() == id){
                category = new Category(categories.get(i).getName(),categories.get(i).getIdParent(), categories.get(i).getId());
                break;
            }
        }

        return category;
    }
}
