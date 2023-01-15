package com.assessment.demo.service;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.Sport;

import java.util.List;
import java.util.Optional;

/**
 * {@link MatchService} interface specifies the methods that need to be implemented for handling {@link Match}
 */
public interface MatchService {

  /**
   * Saves the given {@link Match}
   */
  void createMatch(final Match match);

  void createMatches();

  List<Match> getEveryMatch();

  List<Match> getAllMatchesBySport(final Sport sport);

  Optional<Match> getMatchById(final Long matchId);

  boolean matchExists(final Long matchId);

}
