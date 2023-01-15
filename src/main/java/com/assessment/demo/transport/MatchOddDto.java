package com.assessment.demo.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MatchOddDto {
  @JsonProperty("matchId")
  private Long matchId;
  @JsonProperty("specifier")
  private String specifier;
  @JsonProperty("odd")
  private Float odd;

}
