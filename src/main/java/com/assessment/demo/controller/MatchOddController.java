package com.assessment.demo.controller;

import com.assessment.demo.domain.Match;
import com.assessment.demo.domain.MatchOdd;
import com.assessment.demo.service.MatchOddService;
import com.assessment.demo.service.MatchService;
import com.assessment.demo.transport.MatchOddDto;
import com.assessment.demo.transport.mappers.MatchOddMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class MatchOddController {

  private final MatchService matchService;
  private final MatchOddService matchOddService;

  @GetMapping(value = "/api/v1/matchOdds/{matchId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<MatchOddDto>> getMatchOddsForGame(@PathVariable final Long matchId) {
    Optional<Match> match = Optional.ofNullable(matchService.getMatchById(matchId).orElseThrow(() -> new IllegalArgumentException("Match not found")));//could return custom exception with meaningful message.
    if (match.isEmpty()) {
      return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }
    Long existingMatchId = match.get().getId();
    List<MatchOdd> matchOdds = matchOddService.getMatchOddByMatchId(existingMatchId);
    if (matchOdds.isEmpty()) {
      return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }
    List<MatchOddDto> matchOddDtos = new ArrayList<>();
    for (MatchOdd matchOdd : matchOdds) {
      MatchOddDto matchOddDto = MatchOddMapper.INSTANCE.matchOddToMatchOddDto(matchOdd);//use mapper instead of for loop
      matchOddDtos.add(matchOddDto);
    }

    return new ResponseEntity<>(matchOddDtos, HttpStatus.OK);
  }


  @PostMapping(value = "/api/v1/{matchId}/matchOdd", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> createMatchOddForGame(@PathVariable Long matchId, @RequestBody MatchOddDto matchOddDto) {

    Optional<Match> match = Optional.ofNullable(matchService.getMatchById(matchId).orElseThrow(() -> new IllegalArgumentException("Match not found")));
    if (match.isPresent()) {
      Match existingMatch = match.get();
      log.info("Found match with id[{}] and description[{}]", existingMatch.getId(), existingMatch.getDescription());
      MatchOdd matchOdd = MatchOddMapper.INSTANCE.matchOddDtoToMatchOdd(matchOddDto);
      matchOddService.createMatchOddForSpecificMatch(matchOdd);
      return new ResponseEntity<>("Created", HttpStatus.OK);
    }
    return new ResponseEntity<>(MatchOddDto.builder().build(), HttpStatus.BAD_REQUEST);
  }
}
