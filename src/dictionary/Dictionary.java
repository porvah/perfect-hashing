package dictionary;

import hash_tables.IHashTable;
import utils.KeysReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Dictionary {
    IHashTable<String> hashTable;

    public Dictionary(IHashTable<String> hashTable) {
        this.hashTable = hashTable;
    }

    public boolean insert(String key) {
        return hashTable.insert(key);
    }

    public boolean delete(String key) {
        return hashTable.delete(key);
    }

    public boolean search(String key) {
        return hashTable.search(key);
    }

    public int[] batchInsert(String fileName) {
        String[] keys = KeysReader.getStringsFromFile(fileName);
        int total = keys.length;
        int successful = hashTable.batchInsert(keys);
        return new int[]{successful, total - successful};

    }

    public int[] batchDelete(String fileName) {
        String[] keys = KeysReader.getStringsFromFile(fileName);
        int total = keys.length;
        int successful = hashTable.batchDelete(keys);
        return new int[]{successful, total - successful};

    }




}
