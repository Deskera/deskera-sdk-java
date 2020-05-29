package com.deskera.sdk.common.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Filter criteria.
 */
@Data
@AllArgsConstructor
public class FilterCriteria {

  private final String fullTextSearch;
  private final String query;
  private final int page;
  private final int limit;
  private final String sort;
  private final String sortDir;
  private final Date fromDate;
  private final Date toDate;
  private final String filter;
}
