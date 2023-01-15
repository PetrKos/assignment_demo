package com.assessment.demo.service;

import com.assessment.demo.domain.MatchOdd;
import com.assessment.demo.domain.MatchOddRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MatchOddServiceImpl implements MatchOddService {

  private final MatchOddRepository matchOddRepository;

  @Override
  public List<MatchOdd> getMatchOddByMatchId(Long matchId) {
    return matchOddRepository.findMatchOddsByMatchId(matchId);

  }

  @Override
  public void createMatchOddForSpecificMatch(MatchOdd matchOdd) {
    log.info("Saving new match odd!");
    MatchOdd savedMatchOdd = matchOddRepository.save(matchOdd);
    log.info("New match odd saved with id[{}] for match[{}], ", savedMatchOdd.getId(), savedMatchOdd.getMatchId());
  }
}
