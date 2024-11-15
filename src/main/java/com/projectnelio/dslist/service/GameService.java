package com.projectnelio.dslist.service;

import com.projectnelio.dslist.dto.GamesMinDTO;
import com.projectnelio.dslist.entities.Game;
import com.projectnelio.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GamesMinDTO> findAll(){
        List<Game> repository = gameRepository.findAll();
        return repository.stream().map(x -> new GamesMinDTO(x)).toList();
    }

}
