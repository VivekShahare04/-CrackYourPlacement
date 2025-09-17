class FoodRatings {
    HashMap<String,String> foodtocuisines = new HashMap<>();
    HashMap<String,Integer> foodtorating = new HashMap<>();
    HashMap<String,PriorityQueue<Food>> cuisinetofood = new HashMap<>();

    public static class Food{
        String food;
        int rating;

        public Food(int rating,String food){
            this.food = food;
            this.rating = rating;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for(int i=0;i<foods.length;i++){
            foodtocuisines.put(foods[i],cuisines[i]);
            foodtorating.put(foods[i],ratings[i]);
            cuisinetofood.computeIfAbsent(cuisines[i],k->new PriorityQueue<>(
                (a,b)->a.rating == b.rating?a.food.compareTo(b.food):Integer.compare(b.rating,a.rating)
            )).add(new Food(ratings[i],foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String c = foodtocuisines.get(food);
        foodtorating.put(food,newRating);
        cuisinetofood.get(c).add(new Food(newRating,food));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisinetofood.get(cuisine);
        while(!pq.isEmpty()){
            Food top = pq.peek();
            if(foodtorating.get(top.food)==top.rating)return top.food;
            pq.poll();
        }
        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */