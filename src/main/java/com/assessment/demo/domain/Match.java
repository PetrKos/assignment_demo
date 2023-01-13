package com.assessment.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * {@link Match} contains the details of a game.
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
@SequenceGenerator(name = "match_seq", sequenceName = "match_seq", allocationSize = 1)
@Builder
public class Match {
  /** The unique id of the match. */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "match_seq")
  @Column(name = "id")
  private Long id;
  /** The description of the match. */
  @Column(name = "description")
  private String description;

  /** The date of the match. */
  @Column(name = "match_date")
  private String matchDate;

  /** The time of the match. */
  @Column(name = "match_time")
  private String matchTime;

  /** The first team. */
  @Column(name = "team_a")
  private String teamA;

  /** The second team. */
  @Column(name = "team_b")
  private String teamB;

  /** The type of sport. */
  @Column(name = "sport")
  private Sport sport;

  /** The list with all the {@link MatchOdd} played for the respective match. */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "match_id")
  private List<MatchOdd> matchOdds;
}
