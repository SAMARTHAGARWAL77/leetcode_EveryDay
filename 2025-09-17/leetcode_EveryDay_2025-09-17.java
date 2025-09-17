import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class FoodRatings {
    private HashMap<String,String>foodToCuisine;
    private HashMap<String,Integer>foodToRating;
    private HashMap<String,TreeSet<String>>cuisineToSet;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
     foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToSet = new HashMap<>();
    for(int i=0;i<foods.length;i++)
    {
        foodToCuisine.put(foods[i],cuisines[i]);
        foodToRating.put(foods[i],ratings[i]);
    }
    Comparator<String> comp = (a,b) -> {
        int ra = foodToRating.get(a);
        int rb = foodToRating.get(b);
        if(ra != rb) return Integer.compare(rb,ra);
        return a.compareTo(b);
    };
    

    for(int i=0;i<foods.length;i++)
    {
        String food = foods[i];
        String cuisine = cuisines[i];
        cuisineToSet.computeIfAbsent(cuisine,k -> new TreeSet<>(comp)).add(food);
     

    }
    
    }
    public void changeRating(String food, int newRating) {
    String cuisine = foodToCuisine.get(food);
    TreeSet<String> set = cuisineToSet.get(cuisine);
    set.remove(food);
    foodToRating.put(food,newRating);
    set.add(food);
    }
    
    public String highestRated(String cuisine) {
        TreeSet<String> set = cuisineToSet.get(cuisine);
        return set.first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */