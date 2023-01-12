package com.example.testsneakerparse.repository;

import com.example.testsneakerparse.entity.Paige;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaigeRepository extends JpaRepository<Paige,Long>{
    Page<Paige>findAll(Pageable pageable);
    @Query(value = "SELECT * FROM  Paige where name_article ILIKE %:filter% ", nativeQuery = true)
    Page<Paige>findPaigeByNameArticle(@Param("filter")String filter, Pageable pageable);

}
