package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Mark a class as a Redis entity, meaning its instances will be stored in Redis as hashes.
 * The name provided in the annotation ("User") acts as a prefix for the Redis keys.
 * When you store an object annotated with @RedisHash("User"), it will be stored as a Redis hash with keys like this:
 * User:<id>
 */
@RedisHash("User")
public class User implements Serializable {

    @Id // This will generate random String Unique ID, and this becomes the Key
    private String id;

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
