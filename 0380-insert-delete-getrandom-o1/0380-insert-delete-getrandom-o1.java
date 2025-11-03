class RandomizedSet {
    //Map<Integer,Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    Random rand = new Random();
    public RandomizedSet() {
        set = new HashSet<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom(){
        int index = rand.nextInt(set.size());
        Iterator<Integer> it = set.iterator();
        int i=0;
        while(it.hasNext()){
            int val = it.next();
            if(i==index)return val;
            i++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */