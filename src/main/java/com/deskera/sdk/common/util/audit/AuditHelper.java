package com.deskera.sdk.common.util.audit;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class to support audit trail.
 *
 */
public class AuditHelper {


  /**
   * Generates the Difference result holder object holding all the differences for a Dto class object from DiffResult.
   *
   * @param diffResult
   * @return DiffResultObj
   */
  public static DiffResultObj getDiffResultObj(final DiffResult diffResult) {
    return new DiffResultObj(diffResult.getDiffs().stream()
        .map(e -> new DiffObj(e.getFieldName(), e.getLeft(), e.getRight()))
        .collect(Collectors.toList()));
  }

  /**
   * This class holds the Difference for a given field with old/new value.
   *
   */
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class DiffObj implements Serializable {
    private String fieldName;
    private Object oldVal;
    private Object newVal;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }
  }

  /**
   * Holds all the differences for a Dto Object.
   *
   */

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class DiffResultObj {
    private List<DiffObj> diffObjList;

    public void addDiffObj(final DiffObj diffObj) {
      this.diffObjList.add(diffObj);
    }

    public List<DiffObj> getDiffObjList() {
      return Collections.unmodifiableList(diffObjList);
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }

  }
}
