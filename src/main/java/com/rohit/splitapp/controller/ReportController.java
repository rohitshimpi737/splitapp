package com.rohit.splitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rohit.splitapp.configuration.security.LoggedInUser;
import com.rohit.splitapp.persistence.dto.report.ReportDTO;
import com.rohit.splitapp.service.interfaces.ReportService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    LoggedInUser loggedInUser;

    @GetMapping("/{groupId}")
    public ResponseEntity<List<ReportDTO>> generateReport(@PathVariable UUID groupId) {
        List<ReportDTO> response = reportService.generateReport(groupId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{groupId}/export")
    public ResponseEntity<String> exportReport(@PathVariable UUID groupId, @RequestParam String fileType) {
        String response = reportService.exportReport(groupId, fileType);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
