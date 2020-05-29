package com.deskera.sdk.common.dto.enums;


import com.deskera.sdk.common.util.exception.BadRequestException;

public enum ExportFileFormat {
  XLSX, PDF, CSV;

  public static String getFileExtension(final ExportFileFormat fileFormat) {
    if (fileFormat == null) {
      throw new BadRequestException("File type is mandatory");
    }

    switch (fileFormat) {
      case CSV:
        return ".csv";
      case PDF:
        return ".pdf";
      case XLSX:
        return ".xlsx";
      default:
        throw new BadRequestException("Export file type could not be recognized.");
    }
  }

  public static String getMediaType(final ExportFileFormat fileFormat) {
    if (fileFormat == null) {
      throw new BadRequestException("File type is mandatory");
    }

    switch (fileFormat) {
      case CSV:
        return "text/csv";
      case PDF:
        return "application/pdf";
      case XLSX:
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
      default:
        return "application/octet-stream";
    }
  }
}
