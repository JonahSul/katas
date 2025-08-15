package com.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;
import java.util.Collection;

class HashTableTest {
    
    private HashTable<String, Integer> hashTable;
    
    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }
    
    @Test
    void shouldStartEmpty() {
        assertThat(hashTable.isEmpty()).isTrue();
        assertThat(hashTable.size()).isEqualTo(0);
        assertThat(hashTable.getCapacity()).isEqualTo(16);
    }
    
    @Test
    void shouldPutAndGetValues() {
        assertThat(hashTable.put("key1", 100)).isNull();
        assertThat(hashTable.get("key1")).isEqualTo(100);
        assertThat(hashTable.size()).isEqualTo(1);
        assertThat(hashTable.isEmpty()).isFalse();
    }
    
    @Test
    void shouldReturnPreviousValueOnPut() {
        hashTable.put("key1", 100);
        assertThat(hashTable.put("key1", 200)).isEqualTo(100);
        assertThat(hashTable.get("key1")).isEqualTo(200);
        assertThat(hashTable.size()).isEqualTo(1);
    }
    
    @Test
    void shouldReturnNullForNonExistentKey() {
        assertThat(hashTable.get("nonexistent")).isNull();
    }
    
    @Test
    void shouldRemoveValues() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        
        assertThat(hashTable.remove("key1")).isEqualTo(100);
        assertThat(hashTable.get("key1")).isNull();
        assertThat(hashTable.size()).isEqualTo(1);
        
        assertThat(hashTable.remove("nonexistent")).isNull();
    }
    
    @Test
    void shouldCheckContainsKey() {
        assertThat(hashTable.containsKey("key1")).isFalse();
        
        hashTable.put("key1", 100);
        assertThat(hashTable.containsKey("key1")).isTrue();
        
        hashTable.remove("key1");
        assertThat(hashTable.containsKey("key1")).isFalse();
    }
    
    @Test
    void shouldHandleNullKeys() {
        hashTable.put(null, 100);
        assertThat(hashTable.get(null)).isEqualTo(100);
        assertThat(hashTable.containsKey(null)).isTrue();
        
        assertThat(hashTable.remove(null)).isEqualTo(100);
        assertThat(hashTable.containsKey(null)).isFalse();
    }
    
    @Test
    void shouldHandleNullValues() {
        hashTable.put("key1", null);
        assertThat(hashTable.get("key1")).isNull();
        assertThat(hashTable.containsKey("key1")).isTrue();
    }
    
    @Test
    void shouldHandleCollisions() {
        // Add enough items to force collisions
        for (int i = 0; i < 20; i++) {
            hashTable.put("key" + i, i * 10);
        }
        
        for (int i = 0; i < 20; i++) {
            assertThat(hashTable.get("key" + i)).isEqualTo(i * 10);
        }
        
        assertThat(hashTable.size()).isEqualTo(20);
    }
    
    @Test
    void shouldResizeWhenLoadFactorExceeded() {
        // Add items to exceed load factor threshold (0.75)
        for (int i = 0; i < 13; i++) { // 13/16 = 0.8125 > 0.75
            hashTable.put("key" + i, i);
        }
        
        // Should have resized to capacity 32
        assertThat(hashTable.getCapacity()).isGreaterThan(16);
        assertThat(hashTable.getLoadFactor()).isLessThan(0.75);
        
        // All values should still be accessible
        for (int i = 0; i < 13; i++) {
            assertThat(hashTable.get("key" + i)).isEqualTo(i);
        }
    }
    
    @Test
    void shouldReturnKeySet() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        hashTable.put("key3", 300);
        
        Set<String> keys = hashTable.keySet();
        assertThat(keys).hasSize(3);
        assertThat(keys).containsExactlyInAnyOrder("key1", "key2", "key3");
    }
    
    @Test
    void shouldReturnValues() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        hashTable.put("key3", 300);
        
        Collection<Integer> values = hashTable.values();
        assertThat(values).hasSize(3);
        assertThat(values).containsExactlyInAnyOrder(100, 200, 300);
    }
    
    @Test
    void shouldClearAllEntries() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        
        hashTable.clear();
        
        assertThat(hashTable.isEmpty()).isTrue();
        assertThat(hashTable.size()).isEqualTo(0);
        assertThat(hashTable.get("key1")).isNull();
        assertThat(hashTable.get("key2")).isNull();
    }
    
    @Test
    void shouldCalculateLoadFactor() {
        assertThat(hashTable.getLoadFactor()).isEqualTo(0.0);
        
        hashTable.put("key1", 100);
        assertThat(hashTable.getLoadFactor()).isEqualTo(1.0 / 16);
        
        hashTable.put("key2", 200);
        assertThat(hashTable.getLoadFactor()).isEqualTo(2.0 / 16);
    }
}
