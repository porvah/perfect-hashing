package hash_tables;

public interface IHashTable<T> {

    void insert(T key);
    void delete(T key);
    boolean search(T key);

    boolean batchInsert(T[] keys);

    boolean batchDelete(T[] keys);
}
