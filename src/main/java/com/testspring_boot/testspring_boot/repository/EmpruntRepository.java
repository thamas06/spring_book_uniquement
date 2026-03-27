package com.testspring_boot.testspring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testspring_boot.testspring_boot.entity.Emprunt;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    
    List<Emprunt> findByUserId(Long userId);
    
    List<Emprunt> findByBookId(Long bookId);
    
    List<Emprunt> findByReturned(boolean returned);
}
