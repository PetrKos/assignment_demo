package com.assessment.demo.service;

import com.assessment.demo.domain.MatchOdd;

import java.util.List;

public interface MatchOddService {

  List<MatchOdd> getMatchOddByMatchId(final Long matchId);

  void createMatchOddForSpecificMatch(final MatchOdd matchOdd);
}
