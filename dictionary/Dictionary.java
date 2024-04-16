package dictionary;

import hash_tables.IHashTable;

public class Dictionary {
    IHashTable<String> hashTable;

    public Dictionary(IHashTable<String> hashTable) {
        this.hashTable = hashTable;
    }

    public void insert(String key) {
        hashTable.insert(key);
    }

    public void delete(String key) {
        hashTable.delete(key);
    }

    public boolean search(String key) {
        return hashTable.search(key);
    }

    public boolean batchInsert(String[] keys) {
        for (String key : keys) {
            hashTable.insert(key);
        }
        return true;
    }

    public boolean batchDelete(String[] keys) {
        for (String key : keys) {
            hashTable.delete(key);
        }
        return true;
    }



}
