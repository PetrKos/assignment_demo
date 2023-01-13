package com.assessment.demo.controller;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.Sport;
import com.assessment.demo.service.MatchService;
import com.assessment.demo.transport.MatchDto;
import com.assessment.demo.transport.mappers.MatchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The {@link MatchController} is the receiving point for the match services.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class MatchController {

  private final MatchService matchService;

  /**
   * Retrieves all matches for all sports.
   */
  @GetMapping(value = "/api/v1/matches",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Match> getAllMatches() {
    return matchService.getEveryMatch();
  }

  /**
   * Retrieves all matches by a certain sport.
   */
  @GetMapping(value = "/api/v1/matches/{sport}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Match> getAllMatchesBySport(@PathVariable Sport sport) {
    return matchService.getAllMatchesBySport(sport);
  }

  /**
   * Retrieves a match witch a specific an id
   * @param matchId the id of the match.
   */
  @GetMapping(value = "/api/v1/matches/{id}", produces = "application/json")
  public String getMatch(@PathVariable("id") Long matchId) {
    return "hello";
  }

  /**
   * CReates a match
   * @param matchDto
   * @return
   */
  @PostMapping(value = "/api/v1/matches", produces = "application/json")
  public String createMatch(@RequestBody MatchDto matchDto) {
    Match match = MatchMapper.INSTANCE.matchDtoToMatch(matchDto);
    matchService.createMatch(match);
    return "created";
  }


  @GetMapping("/populate-matches")
  public String populateMatchTable() {
    matchService.createMatches();
    return "games loaded";
  }



}
