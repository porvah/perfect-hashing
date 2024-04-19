package hash_tables;

import java.util.ArrayList;

public class HashTableWithN2Space<T> implements IHashTable{


    // Fields HERE
    ArrayList<T> table;
    int n;
    Matrix matrix;
    int size;
    int elements;
    int hashCount;
    HashTableWithN2Space(){
        n = 10;
        elements = 0;
        size = 2*n*n;
        table = new ArrayList<T>(size);
        table.set(size-1, null);
        matrix = new Matrix(size);
        hashCount = 1;
    }

    @Override
    public boolean insert(Object key) {
        int index = matrix.getIndex(key) % size;
        if(table.get(index) == null){
            table.set(index, (T)key);
            elements++;
            return true;
        }else{
            if(!key.equals(table.get(index))){
                //collision occurred
                if(elements+1 > n){
                    //rehash with new sizes
                    ArrayList<T> newElements = new ArrayList<T>();
                    newElements.add((T)key);
                    rehashSameSize(newElements);
                }else{
                    //rehash with the same size
                }
                return true;
            }else{
                return false;
            }
        }

    }
    private void rehashSameSize(ArrayList<T> newElements){

        boolean collision = true;
        while(collision) {
            int addedElements = 0;
            hashCount++;
            // setting up a new table
            collision = false;
            matrix = new Matrix(size);
            ArrayList<T> newTable = new ArrayList<>(size);
            newTable.set(size - 1, null);
            for(int i = 0; i < table.size(); i++){
                if(table.get(i) != null){
                    int index = matrix.getIndex(table.get(i)) % size;
                    Object key = table.get(i);
                    if(newTable.get(index) == null){

                    }
                }
            }
            if(collision) break;
        }
    }
    private void rehash(){

    }

    @Override
    public boolean delete(Object key) {
        int index = matrix.getIndex(key) % size;
        if(table.get(index) != null){
            table.set(index, null);
            elements--;
            return true;
        }
        return false;
    }

    @Override
    public boolean search(Object key) {
        int index = matrix.getIndex(key) % size;
        if(table.get(index) != null) {
            if(key.equals(table.get(index))) return true;
        }
        return false;
    }

    @Override
    public int batchInsert(Object[] keys) {
        return 0;
    }

    @Override
    public int batchDelete(Object[] keys) {
        return 0;
    }
}
