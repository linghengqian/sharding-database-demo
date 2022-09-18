package com.example.shardingdatabasedemo.com.entity;

import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User implements Persistable<String> {


    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "biz_id", updatable = false)
    private String bizId;



    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return null == this.id;
    }
}
