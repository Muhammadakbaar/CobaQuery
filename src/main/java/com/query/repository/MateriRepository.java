package com.query.repository;

import com.query.model.Materi;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface MateriRepository extends CrudRepository<Materi, Long> {
}
