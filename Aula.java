public class Aula {
    public Aula() {
        int[] ar = new int[15];
        for (int i = 0; i < 15; i++) {
            System.out.println(memoizedFibo(i, ar));
        }

    }

    public int fibRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = fibRec(n - 1);
            int b = fibRec(n - 2);
            return a + b;
        }
    }

    public int fib(int n){
        if(n < 0) return -1;
        int[] ar = new int[n+2];

        ar[0] = 1;
        ar[1] = 1;

        for (int i = 2; i <= n; i++) {
            ar[i] = ar[i-1] + ar[i-2];
        }

        return ar[n];
    }

    public int memoizedFibo(int n, int[] f){
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(n, f);
    }

    public int lookupFibo(int n, int[] f){
        if(f[n] >= 0){
            return f[n];
        }
        if(n <= 1){
            f[n] = n;
        } else{
            f[n] = lookupFibo(n-1, f) + lookupFibo(n-2, f);
        }
        return f[n];
    }
}