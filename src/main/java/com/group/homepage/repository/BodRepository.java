package com.group.homepage.repository;

import com.group.homepage.entity.Bod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BodRepository extends JpaRepository<Bod, Long> {

    List<Bod> findByUseYn(char useYn);

    @Modifying
    @Query(value = "update bodmem set use_yn='N' where bodmem_id= :id", nativeQuery = true)
    void updateUseYn(@Param("id") Long id);
}
