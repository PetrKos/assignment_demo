package com.assessment.demo.transport.mappers;

import com.assessment.demo.domain.Match;
import com.assessment.demo.transport.MatchDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * {@link MatchMapper} interface specifies the method that is used to map a {@link MatchDto} to a {@link Match}.
 */
@Mapper
public interface MatchMapper {

  MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

  /**
   * Automatically mappped by Mapstruct.
   * @param matchDto
   * @return
   */
  Match matchDtoToMatch(MatchDto matchDto);

}
