package com.group.homepage.repository;

import com.group.homepage.dto.ShareholderDTO;
import com.group.homepage.entity.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
    List<Shareholder> findByUseYn(char useYn);

    @Query(
            value = "select MAX(EXTRACT(year from DATE)::int) from shareholder",
            nativeQuery = true
    )
    Integer findLatestYear();

    @Query(
            value = "select * from shareholder  where extract(year from date) = :year and use_yn = 'Y' order by round",
            nativeQuery = true
    )
    List<Shareholder> findByYear(@Param("year") int year);

    @Query(value = "select distinct extract(year from date) as year\n" +
            "from shareholder\n" +
            "where use_yn='Y'\n" +
            "order by year DESC", nativeQuery = true)
    List<Integer> findYearList();

    @Modifying
    @Query(value = "update shareholder set use_yn='N' where extract(year from date) = :year and use_yn = 'Y' ",
            nativeQuery = true)
    void updateUseYnByYear(@Param("year") int year);
}
