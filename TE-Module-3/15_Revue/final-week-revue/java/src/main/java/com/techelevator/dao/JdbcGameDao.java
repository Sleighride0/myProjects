package com.techelevator.dao;

import com.techelevator.model.GamePlayDto;
import com.techelevator.model.GameTitle;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcGameDao implements GameDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcGameDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<GameTitle> getGameTitles() {
        List<GameTitle> gameTitles = new ArrayList<>();
        String sql = "SELECT game_title_id, game_name, game_img_url FROM game_title;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            GameTitle gameTitle = new GameTitle();
            gameTitle.setGameTitleId(results.getInt("game_title_id"));
            gameTitle.setGameName(results.getString("game_name"));
            gameTitle.setGameImgURL(results.getString("game_img_url"));
            gameTitles.add(gameTitle);
        }
        return gameTitles;
    }

    @Override
    public void addGamePlayRecord(GamePlayDto gamePlayDto, User currentUser) {
        String insertGamePlay = "INSERT INTO game_play(game_title_id)VALUES(?) RETURNING game_play_id;";
        int gamePlayId = jdbcTemplate.queryForObject(insertGamePlay, int.class, gamePlayDto.getGameTitleId());
        String insertPlayer = "INSERT INTO game_play_player(game_play_id,player_id)VALUES(?,?);";

        jdbcTemplate.update(insertPlayer, gamePlayId, currentUser.getId());
        if(gamePlayDto.getOpponentId() !=0) {
            jdbcTemplate.update(insertPlayer, gamePlayId, gamePlayDto.getOpponentId());
        }
    }
}
