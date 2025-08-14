class Solution {
    public String largestGoodInteger(String num) {
        String str = "";
        // for(int i=1;i<num.length();i++){
        //     if(num.charAt(i-1)==num.charAt(i)){
        //         str = str + num.charAt(i);    
        //     }
        //     if(str.length()==3){
        //         return str;
        //     }
        // }
        // return "";
        int l=0;
        int h=2;
        while(h<num.length()){
            if(num.charAt(l)==num.charAt(l+1) && num.charAt(l+1)==num.charAt(h)){
                String cand = ""+num.charAt(l)+num.charAt(l+1)+num.charAt(h);
                if(cand.compareTo(str)>0){
                    str= cand;
                }
            }
            l++;
            h++;
        }
        return str;
    }
}