package com.assessment.demo.domain;

import lombok.Getter;

/**
 * {@link Sport} represents the type of sport in a match.
 */
public enum Sport {
  //TODO if possible do this the right without ordinal.
  INVALID_SPORT(0),
  FOOTBALL(1),
  BASKETBALL(2);

  /**
   * Default constructor
   * @param code the associated code
   */
  Sport(final int code) {
    this.code = code;
  }

  public static Sport get(final int code) {
    for (final Sport sport : Sport.values()) {
      if (code == sport.code) {
        return sport;
      }
    }
    return getInvalidSport();
  }

    /**
     * The {@link Match}'s code.
     */
    @Getter
    private final int code;

    private static Sport getInvalidSport() {
      return Sport.INVALID_SPORT;
    }

  /**
   * Checks weather the sport in question is supported by the application.
   * @param sport the sport
   * @return true if sport is either basket ball or football.
   */
  public static boolean matchesSupportedSports(final Sport sport) {
      return BASKETBALL.equals(sport) || FOOTBALL.equals(sport);
    }
}
