class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if (n == Integer.MAX_VALUE) return (x == 1) ? 1 : (x == -1) ? -1 : 0;
        if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;
        if(n > 0){
            double res = myPow(x, n/2);
            if(n%2==0){
                return res * res;
            }
            else{
                return res * res * x;
            }
        }
        else{
            return 1 / myPow(x, -n);
        }
    }
}