package dictionary;

import hash_tables.HashTableWithN2Space;
import hash_tables.HashTableWithNSpace;
import hash_tables.IHashTable;

public class HashTableFactory {

    public static IHashTable<String> createHashTable(String method) {
        if (method.equals("n2")) {
            return new HashTableWithN2Space<String>();
        } else if (method.equals("n")) {
            return new HashTableWithNSpace<String>();
        } else {
            return null;
        }
    }
}
