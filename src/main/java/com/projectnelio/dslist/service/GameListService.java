package com.projectnelio.dslist.service;

import com.projectnelio.dslist.dto.GameListDTO;
import com.projectnelio.dslist.dto.GamesDTO;
import com.projectnelio.dslist.entities.Game;
import com.projectnelio.dslist.entities.GameList;
import com.projectnelio.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList result = gameListRepository.findById(id).get();
        return new GameListDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> repository = gameListRepository.findAll();
        return repository.stream().map(x -> new GameListDTO(x)).toList();
    }



}
