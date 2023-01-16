package com.assessment.demo.controller;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.Sport;
import com.assessment.demo.service.MatchService;
import com.assessment.demo.transport.MatchDto;
import com.assessment.demo.transport.mappers.MatchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * The {@link MatchController} is the receiving point for the match services.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/api/v1/")
public class MatchController {

  private final MatchService matchService;

  /**
   * Retrieves all matches for all sports.
   */
  @GetMapping(value = "/matches", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Match> getAllMatches() {
    return matchService.getEveryMatch();
  }

  /**
   * Retrieves all matches by a certain sport.
   */
  @GetMapping(value = "/matches/{sport}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Match> getAllMatchesBySport(@PathVariable Sport sport) {
    return matchService.getAllMatchesBySport(sport);
  }

  /**
   * Retrieves a match witch a specific an id
   *
   * @param matchId the id of the match.
   */
  @GetMapping(value = "/matches/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MatchDto> getMatch(@PathVariable("id") Long matchId) {
    Optional<Match> matchById = matchService.getMatchById(matchId);
    if(matchById.isPresent()){
      Match match = matchById.get();
      MatchDto matchDto = MatchMapper.INSTANCE.matchToMatchDto(match);
      return new ResponseEntity<>(matchDto, HttpStatus.OK);
    }
    return new ResponseEntity<>(MatchDto.builder().build(), HttpStatus.NOT_FOUND);
  }

  /**
   * CReates a match
   *
   * @param matchDto
   * @return
   */
  @PostMapping(value = "/matches", produces = "application/json")
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
