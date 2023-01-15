package com.assessment.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchOddRepository extends JpaRepository<MatchOdd, Long> {

  @Query("SELECT m FROM MatchOdd m WHERE m.matchId = :matchId")
  List<MatchOdd> findMatchOddsByMatchId(@Param("matchId") Long matchId);

  @Query("SELECT m FROM MatchOdd m WHERE m.matchId = :matchId")
  Optional<MatchOdd> findMatchOddByMatchId(@Param("matchId") Long matchId);

}
