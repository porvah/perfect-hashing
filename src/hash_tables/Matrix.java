package hash_tables;



import java.util.*;
public class Matrix {
    private int u;
    private int b;
    private int[][] matrix;

    public Matrix(int n) {
        this.u = 160;
        this.b = (int) Math.ceil(Math.log((double) n) / Math.log(2.0));
        this.matrix = new int[b][u];
        this.generate();
    }

    //generate random b-u matrix
    private void generate() {
        Random random = new Random();
        for (int i = 0; i < b; i++)
            for (int j = 0; j < u; j++)
                this.matrix[i][j] = random.nextInt(2);
    }


    //return the index of the key in the hash table
    public int getIndex(Object key) {
        int [] x = new int[u];
        if (key instanceof String)
            return  binaryToDecimal(multiplication(stringToInt((String)key)));
        else if (key instanceof Character)
            x = decimalToBinary((long)(Character)key);
        else if (key instanceof Long)
            x = decimalToBinary((long)(Long)key);
        else if (key instanceof Integer)
            x = decimalToBinary((long)(Integer)key);
        else if (key instanceof Float)
            return binaryToDecimal(multiplication(stringToInt(Float.toString((Float)key))));
        else
            return binaryToDecimal(multiplication(stringToInt(String.valueOf((Double)key))));
        return binaryToDecimal(multiplication(x));
    }

    //convert string to integer value
    private int[] stringToInt(String key) {
        int [] x = new int[u];
        StringBuilder result = new StringBuilder();
        char[] chars = key.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))
                            .replaceAll(" ", "0")
            );
        }
        key = result.toString();
        for (int i = 0; i < u; i++) x[i] = 0;
        for(int i=0;i<key.length();i++) x[i] = key.charAt(i)-'0';
        return x;
    }
    //convert decimal to binary using bitwise operations
    private int[] decimalToBinary(long key) {
        int[] x = new int[u];
        for (int i = 0; i < u; i++) {
            long a = (long)1<<i;
            x[i] = (int) (((key&a) == 0) ? 0 : 1);
        }
        return x;
    }
    //construct a matrix using bitwise operations to reduce the time complexity
    private int [] multiplication(int [] x){
        int [] res = new int[u];
        for(int i = 0;i < b;i++) {
            res[i] = 0;
            for (int j = 0; j < u; j++) {
                res[i] ^= matrix[i][j] & x[j];
            }
        }
        return res;
    }
    //convert binary to decimal using bitwise
    private int binaryToDecimal(int [] res){
        int value = 0;
        for(int i = 0;i < res.length;i++){
            value|=(res[i]<<i);
        }
        return value;
    }
}
