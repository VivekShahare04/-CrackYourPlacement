class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //if(denominator==0)return new String(numerator);
        if(numerator==0)return "0";

        String res ="";
        if ((numerator < 0) ^ (denominator < 0)) {
            res += "-";
        }
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        
        res = res+ (a/b);
        long rem = a%b;

        if(rem==0)return res;
        res = res + ".";

        HashMap<Long,Integer> map = new HashMap<>();
        while(rem>0){
            if(map.containsKey(rem)){
                res = res.substring(0,map.get(rem)) + "(" + res.substring(map.get(rem)) + ")";  
                break;
            }
            map.put(rem,res.length());
            rem = rem*10;
            res = res + (rem/b);
            rem = rem%b; 
        }
        return res;
    }
}