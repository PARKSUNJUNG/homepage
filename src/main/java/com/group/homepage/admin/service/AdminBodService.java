package com.group.homepage.admin.service;

import com.group.homepage.dto.BodDTO;
import com.group.homepage.entity.Bod;
import com.group.homepage.entity.FileEntity;
import com.group.homepage.repository.BodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminBodService {

    private final BodRepository bodRepository;
    private final FileService fileService;

    // 이사회 구성원 등록
    @Transactional
    public void saveMember(BodDTO dto, MultipartFile photo) throws Exception {
        String content = "image";
        String category = "bod";
        FileEntity savedFile = fileService.saveFile(photo, content, category);

        Bod entity = dto.toEntity();
        entity.setFile(savedFile);

        bodRepository.save(entity);
    }

    // 이사회 구성원 수정
    @Transactional
    public void updateMember(BodDTO dto, MultipartFile photo) throws Exception {
        Bod entity  = bodRepository.findById(dto.getBodmemId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        if(photo != null && !photo.isEmpty()){
            String content = "image";
            String category = "bod";
            FileEntity savedFile = fileService.saveFile(photo, content, category);
            entity.setFile(savedFile);
        }

        entity.setBodmemId(dto.getBodmemId());
        entity.setMenuId(dto.getMenuId());
        entity.setBodType(dto.getBodType());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setCareerHistory1(dto.getCareerHistory1());
        entity.setCareerHistory2(dto.getCareerHistory2());
        entity.setCareerHistory3(dto.getCareerHistory3());

        bodRepository.save(entity);
    }

    // 이사회 구성원 삭제
    @Transactional
    public void deleteMember(Long id) {
        bodRepository.updateUseYn(id);
    }

    // 이사회 구성원 조회
    public List<BodDTO> getAllMembers() {
        return bodRepository.findByUseYn('Y')
                .stream()
                .map(BodDTO::fromEntity)
                .toList();
    }
}
