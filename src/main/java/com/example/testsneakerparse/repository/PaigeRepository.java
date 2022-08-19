package com.example.testsneakerparse.repository;

import com.example.testsneakerparse.entity.Paige;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaigeRepository extends JpaRepository<Paige, Long> {
}
