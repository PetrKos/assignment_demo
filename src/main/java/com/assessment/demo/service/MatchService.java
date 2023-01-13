package com.assessment.demo.service;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.Sport;

import java.util.List;

/**
 * {@link MatchService} interface specifies the methods that need to be implemented for handling {@link Match}
 */
public interface MatchService {

  /**
   * Saves the given {@link Match}
   */
  void createMatch(Match match);

  void createMatches();

  List<Match> getEveryMatch();

  List<Match> getAllMatchesBySport(final Sport sport);


  List<Match> getMatchById(Long matchId);
}
