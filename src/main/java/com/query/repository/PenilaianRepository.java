package com.query.repository;

import com.query.model.Kelas;
import com.query.model.Penilaian;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PenilaianRepository extends CrudRepository<Penilaian, Long> {
}
