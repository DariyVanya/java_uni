package org.example;

public class Main {
    public int[] array5 (int n){
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res;
    }

    public boolean boolean5 (int a, int b){
        if (a == 0 || b < -2){
            return true;
        }
        else {
            return false;
        }
    }

    public float case5 (int act, float a, float b){

        if (b == 0) {
            throw new AssertionError("B == 0");
        }
        switch (act){
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                return a/b;
        }
        throw new AssertionError("Action must be 1-4");
    }

    public float[] for5 (float N){
        float[] res = new float[10];
        int k = 0;
        for (float i = N/10; i <= N; i+= N/10, k += 1){
            res[k] = i;
        }
        return res;
    }

    public int[] if5(int a, int b, int c){
        int neg = 0, pos = 0;
        if (a >= 0){
            pos ++;
        }
        else{
            neg ++;
        }
        if (b >= 0){
            pos ++;
        }
        else{
            neg ++;
        }
        if (c >= 0){
            pos ++;
        }
        else{
            neg ++;
        }
        int[] res = new int[2];
        res[0] = pos;
        res[1] = neg;
        return res;
    }

    public int int5  (int a, int b){
        return a%b;
    }

  public int[][] matrix5(int n, int d, int[] m){
        int rowCount = m.length;
        int[][] res = new int[rowCount][n];
        for (int i = 0; i < rowCount; i++){
            res[i][0] = m[i];
            for (int j = 1; j < n; j++){
                res[i][j] = res[i][j-1] + d;
            }
        }

        return res;
  }

    public int while5 (int n){
        int n_i = 1;
        int k = 0;
        while (n_i != n){
            if (n > n_i){
                throw new AssertionError("N is not 2^n value");
            }

            n*=2;
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        int a = new Main().while5( 8);
        //new Main().while5( 10);
        System.out.print(a);

    }
}