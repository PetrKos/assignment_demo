package com.assessment.demo.service;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.MatchRepository;
import com.assessment.demo.domain.Sport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * {@link MatchServiceImpl} implements the methods needed for handling a {@link Match}
 */

@Slf4j
@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {

  /** The corresponding {@link MatchRepository} */
  private final MatchRepository matchRepository;

  /** {@inheritDoc} */
  public List<Match> getEveryMatch(){
    return matchRepository.findAllMatches();
  }

  @Override
  public List<Match> getAllMatchesBySport(final Sport sport) {
    if (Sport.matchesSupportedSports(sport)) {
      log.info("Retrieving matches with sport[{}]",sport);
      return matchRepository.findAllMatchesBySport(sport);
    }
    log.info("Sport[{}] is not supported",sport);
    return Collections.emptyList();
  }


  @Override
  public Optional<Match> getMatchById(Long matchId) {
    return matchRepository.findById(matchId);
  }

  @Override
  public boolean matchExists(Long matchId) {
    return matchRepository.existsById(matchId);
  }


  /** {@inheritDoc} */
  @Override
  public void createMatch(Match match) {
    if (match.getId() == null) {
      log.info("Creating new match with description[{}]", match);
      matchRepository.save(match);
    } else {
      log.info("match with current id already exists. Updating new match with description[{}]", match);
      matchRepository.findById(match.getId());
    }

    log.info("New match created");
  }





  @Override
  public void createMatches() {
    List<Match> matches = List.of(
            Match.builder().description("Detroit Pistons - Philadelphia 76ers").matchDate("10-10-2022").matchTime("21:45").teamA("Detroit Pistons").teamB("Philadelphia 76ers").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Oklahoma City Thunder - Miami Heat").matchDate("10-10-2022").matchTime("21:45").teamA("Oklahoma City Thunder").teamB("Miami Heat").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Charlotte Hornets - Toronto Raptors").matchDate("10-10-2022").matchTime("21:45").teamA("Charlotte Hornets").teamB("Toronto Raptors").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Cleveland Cavaliers - Utah Jazz").matchDate("10-10-2022").matchTime("21:45").teamA("Cleveland Cavaliers").teamB("Utah Jazz").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Phoenix Suns - Golden State Warriors").matchDate("11-10-2022").matchTime("21:45").teamA("Phoenix Suns").teamB("Golden State Warriors").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Orlando Magic - Portland Trail Blazers").matchDate("11-10-2022").matchTime("21:45").teamA("Orlando Magic").teamB("Portland Trail Blazers").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Dallas Mavericks - LA Clippers").matchDate("11-10-2022").matchTime("21:45").teamA("Dallas Mavericks").teamB("LA Clippers").sport(Sport.BASKETBALL).build(),
            Match.builder().description("Minnesota Timberwolves - Detroit Pistons").matchDate("11-10-2022").matchTime("21:45").teamA("Minnesota Timberwolves").teamB("Detroit Pistons").sport(Sport.BASKETBALL).build(),

            Match.builder().description("ΠΑΣ ΛΑΜΙΑ 1964 - ΑΤΡΟΜΗΤΟΣ").matchDate("10-10-2022").matchTime("17:45").teamA("ΠΑΣ ΛΑΜΙΑ 1964").teamB("ΑΤΡΟΜΗΤΟΣ").sport(Sport.FOOTBALL).build(),
            Match.builder().description("Π.Α.Ο.Κ. - Ο.Φ.Η.").matchDate("10-10-2022").matchTime("21:45").teamA("Π.Α.Ο.Κ.").teamB("Ο.Φ.Η.").sport(Sport.FOOTBALL).build(),
            Match.builder().description("A.E.K. - ΠΑΝΑΙΤΩΛΙΚΟΣ").matchDate("10-10-2022").matchTime("21:45").teamA("A.E.K.").teamB("ΠΑΝΑΙΤΩΛΙΚΟΣ").sport(Sport.FOOTBALL).build(),
            Match.builder().description("ΟΛΥΜΠΙΑΚΟΣ - ΑΡΗΣ").matchDate("10-10-2022").matchTime("21:45").teamA("ΟΛΥΜΠΙΑΚΟΣ").teamB("ΑΡΗΣ").sport(Sport.FOOTBALL).build(),
            Match.builder().description("ΠΑΣ ΓΙΑΝΝΙΝΑ - ΠΑΝΑΘΗΝΑΪΚΟΣ").matchDate("11-10-2022").matchTime("21:45").teamA("ΠΑΣ ΓΙΑΝΝΙΝΑ").teamB("ΠΑΝΑΘΗΝΑΪΚΟΣ").sport(Sport.FOOTBALL).build()
            );
    matchRepository.saveAll(matches);
  }
}

