package com.assessment.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The {@link MatchRepository} contains the definition of all data-related actions for the {@link Math} entity.
 */
@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

  /**
   * Fetches a specific match
   *
   * @param id
   * @return
   */
  @Query("SELECT m FROM Match m WHERE m.id = :matchId")
  Optional<Match> findById(@Param("matchId") Long id);

  @Query(value = "SELECT m FROM Match m ORDER BY id DESC")
  List<Match> findAllMatches();

  @Query(value = "SELECT m FROM Match m WHERE m.sport =  :sport")
  List<Match> findAllMatchesBySport(@Param("sport") Sport sport);



}
