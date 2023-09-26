package com.example.budapest_kozut.repo;

import com.example.budapest_kozut.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo extends JpaRepository<Data, Long> {
}
