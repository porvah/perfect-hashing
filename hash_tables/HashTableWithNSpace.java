package hash_tables;

import java.util.ArrayList;

public class HashTableWithNSpace<T> implements IHashTable<T> {

    // Fields HERE
    private HashTableWithN2Space<T>[] table;
    private Matrix matrix;
    private int hash_count;
    private int max_size;
    private int cur_size;

    public HashTableWithNSpace() {
        cur_size = 0;
        max_size = 10;
        hash_count = 0;
        matrix = new Matrix(max_size);
        table = new HashTableWithN2Space[max_size];
    }

    @Override
    public boolean insert(Object key) {
        int index = matrix.getIndex(key) % max_size;
        if (table[index] == null) {
            cur_size++;
            table[index] = new HashTableWithN2Space<>();
        }

        hash_count -= table[index].hashCount;
        boolean res = table[index].insert(key);
        hash_count += table[index].hashCount;

        if (needs_to_rehash())
            hash(getValues().toArray());

        return res;
    }

    @Override
    public boolean delete(Object key) {
        int index = matrix.getIndex(key) % max_size;
        if (table[index] == null)
            return false;
        return table[index].delete(key);
    }

    @Override
    public boolean search(Object key) {
        int index = matrix.getIndex(key) % max_size;
        if (table[index] == null)
            return false;
        return table[index].search(key);
    }

    @Override
    public int batchInsert(Object[] keys) {
        var values = getValues();
        for (var key : keys)
            values.add((T) key);

        hash(values.toArray());

        int unique_values = getValues().size();
        return keys.length - (values.size() - unique_values);
    }

    @Override
    public int batchDelete(Object[] keys) {
        int deleted_items = 0;
        for (Object key : keys)
            if (delete(key))
                deleted_items++;
        return deleted_items;
    }

    private ArrayList<T> getValues() {
        ArrayList<T> values = new ArrayList<>();
        for (int i = 0; i < max_size; ++i) {
            if (table[i] != null)
                values.addAll(table[i].getValues());
        }
        return values;
    }

    private void hash(Object[] keys) {
        cur_size = 0;
        max_size = keys.length * 3;
        matrix = new Matrix(max_size);
        table = new HashTableWithN2Space[max_size];
        hash_count++;

        ArrayList<Object>[] freq_arr = new ArrayList[max_size];
        for (var key : keys) {
            int index = matrix.getIndex(key) % max_size;
            if (freq_arr[index] == null)
                freq_arr[index] = new ArrayList<>();
            freq_arr[index].add(key);
        }

        for (int i = 0; i < max_size; ++i) {
            if (freq_arr[i] != null) {
                cur_size++;
                Object[] cur_arr = freq_arr[i].toArray();
                table[i] = new HashTableWithN2Space<>();
                table[i].batchInsert(cur_arr);
                hash_count += table[i].hashCount;
            }
        }
    }

    private boolean needs_to_rehash() {
        return (1.0 * cur_size / max_size) >= 0.5;
    }
}