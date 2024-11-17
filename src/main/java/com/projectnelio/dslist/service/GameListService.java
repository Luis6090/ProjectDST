package com.projectnelio.dslist.service;

import com.projectnelio.dslist.dto.GameListDTO;
import com.projectnelio.dslist.dto.GamesDTO;
import com.projectnelio.dslist.entities.Game;
import com.projectnelio.dslist.entities.GameList;
import com.projectnelio.dslist.projections.GameMinProjection;
import com.projectnelio.dslist.repository.GameListRepository;
import com.projectnelio.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

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

    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }



}
