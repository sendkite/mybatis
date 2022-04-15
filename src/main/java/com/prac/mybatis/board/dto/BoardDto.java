package com.prac.mybatis.board.dto;

import lombok.Data;

@Data
public class BoardDto {

    private Long boardIdx;

    private String title;

    private String contents;

    private int hitCnt;

    private String creatorId;

    private String createdDatetime;

    private String updaterId;

    private String updatedDatetime;

}
