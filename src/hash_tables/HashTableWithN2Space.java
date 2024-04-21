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
    public HashTableWithN2Space(){
        n = 10;
        elements = 0;
        size = 2*n*n;
        table = new ArrayList<T>(size);
        for( int i = 0; i < size; i++) table.add(null);
        matrix = new Matrix(size);
        hashCount = 1;
    }
    public int getSize(){ return size;}
    public int getAllSpace() { return getSize();}
    public int getN(){return elements;}
    public int getHashCount(){ return hashCount;}
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
        ArrayList<T> newTable = new ArrayList<>(size);
        while(collision) {
            hashCount++;
            // setting up a new table
            collision = false;
            matrix = new Matrix(size);
            newTable = new ArrayList<>(size);
            for(int i = 0; i < size; i++) newTable.add(null);
            newElementsCount = 0;
            for (T t : table) { //adding original table elements to the new table
                if (t != null) {
                    int index = matrix.getIndex(t) % size;
                    if (newTable.get(index) == null) { //empty slot -> add
                        newTable.set(index, t);
                        newElementsCount++;
                    } else { //collision -> rehash
                        collision = true;
                        break;
                    }
                }
            }
            if(collision) continue;
            for (T newElement : newElements) { //adding new elements to the new table
                int index = matrix.getIndex(newElement) % size;
                if (newTable.get(index) == null) { // empty slot -> add
                    newTable.set(index, newElement);
                    newElementsCount++;
                } else {
                    if (!newElement.equals(newTable.get(index))) { // non unique(already exits)-> ignore
                        //collision happened -> rehash
                        collision = true;
                        break;
                    }
                }
            }
        }
        table = newTable;
        int addedElements = newElementsCount - elements;
        elements = newElementsCount;
        return addedElements;
    }
    public ArrayList<T> getValues(){
        ArrayList<T> values = new ArrayList<>(elements);
        for(int i = 0; i < size; i++){
            if(table.get(i)!= null){
                values.add(table.get(i));
            }
        }
        return values;
    }


    @Override
    public boolean delete(Object key) {
        int index = matrix.getIndex(key) % size;
        if(table.get(index) != null && table.get(index).equals(key)){
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
            return key.equals(table.get(index));
        }
        return false;
    }

    @Override
    public int batchInsert(Object[] keys) {
        int noOfInserts = keys.length;
        int elementsBefore = elements;
        boolean collision = false;
        for(Object key : keys){
            int index = matrix.getIndex(key) % size;
            if(table.get(index) == null){
                table.set(index, (T)key);
                elements++;
            }else if(!table.get(index).equals(key)){
                //collision
                collision = true;
                break;
            } // else ignore
        }
        if(collision){
            ArrayList<T> elementsTobeAdded = new ArrayList<>(noOfInserts);
            for(Object key : keys) elementsTobeAdded.add((T)key);
            if((elementsBefore + noOfInserts) > n){
                //rehash with new size

                rehashWithNewSize(elementsTobeAdded);
            }else{
                // rehash with same size
                rehashSameSize(elementsTobeAdded);
            }
        }
        int elementsAfter = elements;
        return elementsAfter - elementsBefore;
    }

    @Override
    public int batchDelete(Object[] keys) {
        int successful = 0;
        for (Object key : keys) {
            boolean success = delete(key);
            if (success) successful++;
        }
        elements = elements - successful;
        return successful;
    }
}
