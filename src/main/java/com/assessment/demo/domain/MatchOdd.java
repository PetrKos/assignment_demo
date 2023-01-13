package com.assessment.demo.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * {@link MatchOdd} represent the odds of a game.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "match_odd")
@SequenceGenerator(name = "match_odd_seq", sequenceName = "match_odd_seq", allocationSize = 1)
public class MatchOdd {
  /** The unique id of the match. */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "match_odd_seq")
  @Column(name = "id")
  private Long id;
  /** The specifier of the game. for now its 1,2,X foot and basket*/ //todo can be 1 or 2 for basketball and 1,2,X for footbal
  @Column(name = "specifier")
  private String specifier; //todo make in char?
  @Column(name = "odd")
  private Float odd;
}
