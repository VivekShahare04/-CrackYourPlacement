class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int numgroups = (len+k-1)/k;
        String[] arr = new String[numgroups];

        int index=0;
        for(int i=0;i<numgroups;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<k;j++){
                if(index<len){
                    sb.append(s.charAt(index));
                    index++;
                }else{
                    sb.append(fill);
                }
            }
            arr[i] = sb.toString();
        }
        return arr;
    }
}