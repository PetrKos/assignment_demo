package com.assessment.demo.transport;

import com.assessment.demo.domain.Sport;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MatchDto {

  @JsonProperty("uuid")
  private String uuid;
  @JsonProperty("id")
  private Long id;
  @JsonProperty("description")
  private String description;
  @JsonProperty("matchDate")
  private String matchDate;
  @JsonProperty("matchTime")
  private String matchTime;
  @JsonProperty("teamA")
  private String teamA;
  @JsonProperty("teamB")
  private String teamB;
  @JsonProperty("sport")
  private Sport sport;
}
