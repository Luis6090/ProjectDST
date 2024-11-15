package com.projectnelio.dslist.controllers;

import com.projectnelio.dslist.dto.GamesMinDTO;
import com.projectnelio.dslist.entities.Game;
import com.projectnelio.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GamesMinDTO> findAll(){
        return gameService.findAll();
    }
}
