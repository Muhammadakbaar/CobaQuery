package com.query.repository;

import com.query.model.Kelas;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface KelasRepository extends CrudRepository<Kelas, Long> {
}
