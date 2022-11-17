package com.example.springtest.repositories;


import com.example.springtest.entities.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    Sample findByTitle(String title);

    Sample findById(String id);

    List<Sample> findByCreatedDate(Date createdAt);

    Optional<Sample> findOne(String taskName);
}
