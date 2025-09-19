package com.group.homepage.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ShareholderDTO {

    private Long menuId;
    private LocalDate date;
    private Long shareId;
    private int round;
    private String contents;
    private String decision;
    private char useYn;
    private int year;

    public ShareholderDTO(Long menuId, LocalDate date, Long shareId, int round, String contents, String decision, char useYn) {
        this.menuId = menuId;
        this.date = date;
        this.shareId = shareId;
        this.round = round;
        this.contents = contents;
        this.decision = decision;
        this.useYn = useYn;
        this.year = (date != null) ? date.getYear() : 0;
    }

    @Override
    public String toString() {
        return "ShareholderDTO{" +
                "menuId=" + menuId +
                ", date=" + date +
                ", shareId=" + shareId +
                ", round=" + round +
                ", contents='" + contents + '\'' +
                ", decision='" + decision + '\'' +
                ", useYn=" + useYn +
                '}';
    }
}
