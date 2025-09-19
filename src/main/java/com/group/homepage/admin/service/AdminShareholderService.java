package com.group.homepage.admin.service;

import com.group.homepage.dto.ShareholderDTO;
import com.group.homepage.entity.Shareholder;
import com.group.homepage.repository.ShareholderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminShareholderService {

    private final ShareholderRepository shareholderRepository;

    public AdminShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    // 등록
    public void saveShareholder(List<ShareholderDTO> shareholderDto){
        for(ShareholderDTO dto: shareholderDto){
            Shareholder entity = new Shareholder();
            entity.setMenuId(dto.getMenuId());
            entity.setDate(dto.getDate());
            entity.setShareId(dto.getShareId());
            entity.setRound(dto.getRound());
            entity.setContents(dto.getContents());
            entity.setDecision(dto.getDecision());
            entity.setUseYn('Y');

            shareholderRepository.save(entity);
        }
    }

    // 수정
    public void updateShareholder(List<ShareholderDTO> dto) {

        for(ShareholderDTO d : dto){

            Shareholder entity = d.getShareId() != null
                    ? shareholderRepository.findById(d.getShareId()).orElse(new Shareholder())
                    : new Shareholder();

            entity.setMenuId(d.getMenuId());
            entity.setDate(d.getDate());
            entity.setShareId(d.getShareId());
            entity.setRound(d.getRound());
            entity.setContents(d.getContents());
            entity.setDecision(d.getDecision());
            entity.setUseYn(d.getUseYn());

            shareholderRepository.save(entity);
        }
    }

    // 가장 최근 연도 찾기
    public int findLatestYear() {
        return shareholderRepository.findLatestYear();
    }

    // 조회
    public List<ShareholderDTO> findByYear(int year) {
        return shareholderRepository.findByYear(year)
                .stream()
                .map(entity-> new ShareholderDTO(entity.getMenuId(),
                        entity.getDate(),
                        entity.getShareId(),
                        entity.getRound(),
                        entity.getContents(),
                        entity.getDecision(),
                        entity.getUseYn()))
                .collect(Collectors.toList());
    }

    // 연도 리스트
    public List<Integer> getYearList(){
        return shareholderRepository.findYearList();
    }

    // 삭제
    @Transactional
    public void deleteShareholder(int year) {
        shareholderRepository.updateUseYnByYear(year);
    }
}
