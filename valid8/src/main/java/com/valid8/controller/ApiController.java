package com.valid8.controller;

import com.valid8.model.*;
import com.valid8.service.Valid8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private Valid8Service service;

    private static final DateTimeFormatter DT_FMT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @GetMapping("/summary")
    public ResponseEntity<List<LotSummary>> summary() {
        return ResponseEntity.ok(service.getLotSummaries());
    }


    @GetMapping("/violations")
    public ResponseEntity<List<ViolationItem>> violations() {
        return ResponseEntity.ok(service.getViolations());
    }

    @GetMapping("/unregistered")
    public ResponseEntity<List<UnregisteredItem>> unregistered() {
        return ResponseEntity.ok(service.getUnregistered());
    }

   
    @PostMapping("/reload")
    public ResponseEntity<Map<String, Object>> reload() {
        service.reload();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("reloadTimestamp", LocalDateTime.now().format(DT_FMT));
        response.put("error", service.getLoadError());
        return ResponseEntity.ok(response);
    }
}
