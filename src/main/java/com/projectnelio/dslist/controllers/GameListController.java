package com.projectnelio.dslist.controllers;

import com.projectnelio.dslist.dto.GameListDTO;
import com.projectnelio.dslist.dto.GamesDTO;
import com.projectnelio.dslist.dto.GamesMinDTO;
import com.projectnelio.dslist.service.GameListService;
import com.projectnelio.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        return gameListService.findById(id);
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GamesMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }
}
