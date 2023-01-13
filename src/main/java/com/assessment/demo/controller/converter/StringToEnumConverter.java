package com.assessment.demo.controller.converter;

import com.assessment.demo.domain.Sport;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Sport> {
  @Override
  public Sport convert(String source) {
    return Sport.valueOf(source.toUpperCase());
  }
}

