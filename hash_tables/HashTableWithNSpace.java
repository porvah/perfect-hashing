package hash_tables;

public class HashTableWithNSpace<T> implements IHashTable {

    // Fields HERE
    private HashTableWithN2Space<T>[] table;
    private Matrix matrix;
    private int hashCount;
    private int max_size;
    private int cur_size;

    public HashTableWithNSpace() {
        cur_size = 0;
        max_size = 10;
        hashCount = 0;
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

        boolean res = table[index].insert(key);
        if (needs_to_rehash())
            rehash();

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
        return 0;
    }

    @Override
    public int batchDelete(Object[] keys) {
        int deleted_items = 0;
        for (Object key : keys)
            if (delete(key))
                deleted_items++;
        return deleted_items;
    }

    private boolean needs_to_rehash() {
        return (1.0 * cur_size / max_size) >= 0.5;
    }

    private void rehash() {

    }
}