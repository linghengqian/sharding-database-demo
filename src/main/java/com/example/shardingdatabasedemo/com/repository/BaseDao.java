package com.example.shardingdatabasedemo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseDao<T, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}
