package hash_tables;

public interface IHashTable<T> {

    void insert(T key);
    void delete(T key);
    boolean search(T key);

    boolean batchInsert(String[] keys);

    boolean batchDelete(String[] keys);
}
