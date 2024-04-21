package hash_tables;

public interface IHashTable<T> {

    boolean insert(T key);
    boolean delete(T key);
    boolean search(T key);

    int batchInsert(T[] keys);

    int batchDelete(T[] keys);

    int getAllSpace();

    int getHashCount();
}
