class Solution {
    public int[] findOriginalArray(int[] changed) {
    //     if (changed.length % 2 != 0) return new int[0];
    //     HashSet<Integer> set =  new HashSet<>();
    //    // int[] n = new int[changed.length];
    //    ArrayList<Integer> ls = new ArrayList<>();
    //     Arrays.sort(changed);
    //     for(int i=changed.length-1;i>=0;i--){
    //         if(set.contains(changed[i]*2)){
    //             ls.add(changed[i]);
    //             //set.remove(changed[i] * 2);
    //         }else{
    //             set.add(changed[i]);
    //         }
    //     }
    //     if (ls.size() * 2 != changed.length) {
    //         return new int[0];
    //     }
    //     int[] arr = new int[ls.size()];

    //     for (int i = 0; i < ls.size(); i++) {
    //         arr[i] = ls.get(i); 
    //     }
    //     return arr;

    if (changed.length % 2 != 0) return new int[0];

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> original = new ArrayList<>();

        for (int x : freq.keySet()) {
            if (freq.get(x) > freq.getOrDefault(x * 2, 0)) {
                return new int[0];
            }

            for (int i = 0; i < freq.get(x); i++) {
                original.add(x);
                freq.put(x * 2, freq.get(x * 2) - 1);
            }
        }

        return original.stream().mapToInt(i -> i).toArray();
    }
}