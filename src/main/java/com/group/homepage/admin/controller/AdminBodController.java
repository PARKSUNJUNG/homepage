package com.group.homepage.admin.controller;

import com.group.homepage.admin.service.AdminBodService;
import com.group.homepage.dto.BodDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/corporate/bod")
@RequiredArgsConstructor
public class AdminBodController {

    private final AdminBodService adminBodService;

    // 이사회 구성원 등록
    @Transactional
    @PostMapping("/member/register")
    public ResponseEntity<String> createMember(@ModelAttribute BodDTO dto, @RequestPart MultipartFile photo) throws Exception {

        adminBodService.saveMember(dto, photo);

        return ResponseEntity.ok("success");
    }

    // 이사회 구성원 수정
    @Transactional
    @PutMapping("/member/edit")
    public ResponseEntity<String> updateMember(@ModelAttribute BodDTO dto, @RequestPart(value = "photo", required = false) MultipartFile photo) throws Exception {

        adminBodService.updateMember(dto, photo);

        return ResponseEntity.ok("success");
    }

    // 이사회 구성원 삭제
    @Transactional
    @DeleteMapping("/member/delete/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) throws Exception {

        adminBodService.deleteMember(id);

        return ResponseEntity.ok("success");
    }
    
    // 이사회 구성원 조회
    @GetMapping("/member/list")
    public ResponseEntity<List<BodDTO>> getMemberList(){
        List<BodDTO> members = adminBodService.getAllMembers();
        return ResponseEntity.ok(members);
    }





}
