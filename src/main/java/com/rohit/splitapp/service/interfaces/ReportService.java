package com.rohit.splitapp.service.interfaces;

import java.util.UUID;

import com.rohit.splitapp.persistence.dto.report.ReportDTO;

import java.util.List;

public interface ReportService {

    List<ReportDTO> generateReport(UUID groupId);

    String exportReport(UUID groupId, String fileType);
}
