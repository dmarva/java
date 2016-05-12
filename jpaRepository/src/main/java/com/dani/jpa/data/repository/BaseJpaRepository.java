package com.dani.jpa.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.dani.jpa.domain.DomainObject;

public interface BaseJpaRepository<T extends DomainObject<PK>, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {

}
