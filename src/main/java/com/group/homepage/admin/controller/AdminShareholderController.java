package com.group.homepage.admin.controller;

import com.group.homepage.admin.service.AdminShareholderService;
import com.group.homepage.dto.ShareholderDTO;
import com.group.homepage.entity.Shareholder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporate/shareholders")
public class AdminShareholderController {

    private final AdminShareholderService adminShareholderService;

    public AdminShareholderController(AdminShareholderService adminShareholderService) {
        this.adminShareholderService = adminShareholderService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createShareholder(@RequestBody List<ShareholderDTO> dto){
        adminShareholderService.saveShareholder(dto);

        return ResponseEntity.ok("success");
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateShareholder(@RequestBody List<ShareholderDTO> dto) {
        adminShareholderService.updateShareholder(dto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ShareholderDTO>> getShareholderList(@RequestParam String year){
        List<ShareholderDTO> shareholder = null;

        if("latest".equals(year)){
            int latestYear = adminShareholderService.findLatestYear();
            shareholder = adminShareholderService.findByYear(latestYear);
        } else {
            int yearData = Integer.parseInt(year);
            shareholder = adminShareholderService.findByYear(yearData);
        }

        return ResponseEntity.ok(shareholder);
    }

    @GetMapping("/year")
    public List<Integer> getYearList(){
        return adminShareholderService.getYearList();
    }

    @DeleteMapping("/delete/{year}")
    public ResponseEntity<String> deleteShareHolder(@PathVariable int year){
        adminShareholderService.deleteShareholder(year);
        return ResponseEntity.ok("success");
    }
}
