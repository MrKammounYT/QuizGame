package tn.Manager;

import tn.Utils.Question;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryManager {

   private  final GameManager manager;
    HashMap<String, ArrayList<Question>> categories = new HashMap<String, ArrayList<Question>>();

    public CategoryManager(GameManager manager){
       this.manager = manager;
    }


    public HashMap<String, ArrayList<Question>> getCategories() {
        return categories;
    }
    public void createCategory(String category, ArrayList<Question> questions){
        categories.put(category, questions);
    }
}
