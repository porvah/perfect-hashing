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
                ArrayList<T> newElements = new ArrayList<T>();
                newElements.add((T)key);
                int addedElements;
                if(elements+1 > n){
                    //rehash with new sizes
                    addedElements = rehashWithNewSize(newElements);
                }else{
                    //rehash with the same size
                    addedElements = rehashSameSize(newElements);
                }
                elements = elements+addedElements;
                return true;
            }else{
                return false;
            }
        }

    }
    private int rehashWithNewSize(ArrayList<T> newElements){
        n = newElements.size() + elements;
        size = 2*n*n;
        return rehashSameSize(newElements);
    }
    private int rehashSameSize(ArrayList<T> newElements){
        int newElementsCount = 0;
        boolean collision = true;
        while(collision) {
            hashCount++;
            // setting up a new table
            collision = false;
            matrix = new Matrix(size);
            ArrayList<T> newTable = new ArrayList<>(size);
            newTable.set(size - 1, null);
            newElementsCount = 0;
            for(int i = 0; i < table.size(); i++){ //adding original table elements to the new table
                if(table.get(i) != null){
                    int index = matrix.getIndex(table.get(i)) % size;
                    if(newTable.get(index) == null){ //empty slot -> add
                        newTable.set(index, table.get(i));
                        newElementsCount++;
                    }else{ //collision -> rehash
                        collision = true;
                        break;
                    }
                }
            }
            if(collision) continue;
            for(int i = 0; i < newElements.size(); i++){ //adding new elements to the new table
                int index = matrix.getIndex(newElements.get(i))%size;
                if(newTable.get(index) == null){ // empty slot -> add
                    newTable.set(index, newElements.get(i));
                    newElementsCount++;
                }else{
                    if(!newElements.get(i).equals(newTable.get(index))){ // non unique(already exits)-> ignore
                        //collision happened -> rehash
                        collision = true;
                        break;
                    }
                }
            }
        }
        return newElementsCount - elements;
    }
//    private void rehash(){
//
//    }

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
        int successful = 0;
        for(int i = 0; i < keys.length; i++){
            boolean success = delete(keys[i]);
            if(success) successful++;
        }
        return successful;
    }
}
