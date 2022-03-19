class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double avg = 0;
        Arrays.sort(salary);
        for(int i=1; i<n-1; i++){
            avg+=salary[i];
        }
        return avg/(n-2);
    }
}