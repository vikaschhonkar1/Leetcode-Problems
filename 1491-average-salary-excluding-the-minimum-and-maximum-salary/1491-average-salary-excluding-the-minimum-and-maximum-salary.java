class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double avg = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(salary[i]>max){
                max = salary[i];
            }
            if(salary[i]<min){
                min = salary[i];
            }
        }
        for(int i=0; i<n; i++){
            if(salary[i]!=max && salary[i]!=min){
                avg+=salary[i];
            }
        }
        return avg/(n-2);
    }
}