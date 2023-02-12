package com.example.testsneakerparse.repository;

import com.example.testsneakerparse.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollectRepository extends JpaRepository<Collect,Long> {
//    Optional<Collect>findAllByName(String name);
}
