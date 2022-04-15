package com.prac.mybatis.board.controller;

import com.prac.mybatis.board.dto.BoardDto;
import com.prac.mybatis.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping ("/boards")
    public ResponseEntity<?> insertBoard(@RequestBody BoardDto board) throws Exception{
        log.info("post controller={}", board.getTitle());
        boardService.insertBoard(board);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
