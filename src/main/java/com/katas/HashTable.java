package com.katas;

import java.util.*;

/**
 * Hash Table Implementation Kata
 * 
 * Problem Description:
 * Implement a hash table (hash map) from scratch with the following features:
 * - Basic operations: put, get, remove
 * - Handle collisions using chaining
 * - Dynamic resizing when load factor exceeds threshold
 * - Support for null keys and values
 * 
 * Requirements:
 * - Initial capacity: 16
 * - Load factor threshold: 0.75
 * - Resize by doubling capacity
 * - Use linked lists for collision handling
 * 
 * Constraints:
 * - Handle hash collisions gracefully
 * - Maintain O(1) average time complexity for basic operations
 * - Support generic key-value pairs
 */
public class HashTable<K, V> {
    
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    
    private Entry<K, V>[] buckets;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.buckets = new Entry[capacity];
    }
    
    /**
     * Associates the specified value with the specified key.
     * @param key the key
     * @param value the value
     * @return the previous value associated with key, or null if none
     */
    public V put(K key, V value) {
        if (getLoadFactor() >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
        
        int index = hash(key);
        Entry<K, V> head = buckets[index];
        
        // Search for existing key
        Entry<K, V> current = head;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        
        // Add new entry at the beginning of the chain
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        buckets[index] = newEntry;
        size++;
        
        return null;
    }
    
    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value, or null if key not found
     */
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = buckets[index];
        
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        
        return null;
    }
    
    /**
     * Removes the mapping for the specified key.
     * @param key the key
     * @return the removed value, or null if key not found
     */
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> head = buckets[index];
        
        if (head == null) return null;
        
        // If head is the target
        if (Objects.equals(head.key, key)) {
            buckets[index] = head.next;
            size--;
            return head.value;
        }
        
        // Search in the chain
        Entry<K, V> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.key, key)) {
                V value = current.next.value;
                current.next = current.next.next;
                size--;
                return value;
            }
            current = current.next;
        }
        
        return null;
    }
    
    /**
     * Returns true if this map contains the specified key.
     * @param key the key
     * @return true if key exists, false otherwise
     */
    public boolean containsKey(K key) {
        return get(key) != null || (get(key) == null && hasNullValueForKey(key));
    }
    
    private boolean hasNullValueForKey(K key) {
        int index = hash(key);
        Entry<K, V> current = buckets[index];
        
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Returns the number of key-value mappings.
     * @return the size
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns a set of all keys.
     * @return set of keys
     */
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
    
    /**
     * Returns a collection of all values.
     * @return collection of values
     */
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> head : buckets) {
            Entry<K, V> current = head;
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
        }
        return values;
    }
    
    /**
     * Removes all mappings.
     */
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
    
    /**
     * Calculates hash code for the given key.
     * @param key the key
     * @return hash code
     */
    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }
    
    /**
     * Resizes the hash table when load factor exceeds threshold.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        size = 0;
        buckets = new Entry[capacity];
        
        // Rehash all existing entries
        for (Entry<K, V> head : oldBuckets) {
            Entry<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    /**
     * Returns the current load factor.
     * @return load factor
     */
    public double getLoadFactor() {
        return capacity == 0 ? 0 : (double) size / capacity;
    }
    
    /**
     * Returns the current capacity.
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
}
