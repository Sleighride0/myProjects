package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao{

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
    public int addGamePlayRecord(GamePlayDto gamePlayDto, User currentUser) {
        //make record of game occuring
        String insertGamePlay = "INSERT INTO game_play(game_title_id)VALUES(?) RETURNING game_play_id;";
        int gamePlayId = jdbcTemplate.queryForObject(insertGamePlay, int.class, gamePlayDto.getGameTitleId());
        //make record of user playing above game
        String insertPlayer = "INSERT INTO game_play_player(game_play_id,player_id)VALUES(?,?);";
        jdbcTemplate.update(insertPlayer, gamePlayId, currentUser.getId());
        if(gamePlayDto.getOpponentId() != 0){
            //make record of opponent playing above game
            jdbcTemplate.update(insertPlayer, gamePlayId, gamePlayDto.getOpponentId());
        }
        return gamePlayId;
    }

    @Override
    public List<GameDto> getPlayedGames(int currentUserId) {
        List<GameDto> games = new ArrayList<>();
        String sql = "SELECT game_play.game_play_id AS gp_id,game_title.game_title_id AS gt_id, game_name FROM users \n" +
                "JOIN game_play_player ON users.user_id = game_play_player.player_id \n" +
                "JOIN game_play ON game_play.game_play_id = game_play_player.game_play_id \n" +
                "JOIN game_title ON game_play.game_title_id = game_title.game_title_id \n" +
                "WHERE users.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, currentUserId);
            while(results.next()){
                GameDto gameDto = new GameDto();
                gameDto.setGamePlayId(results.getInt("gp_id"));
                gameDto.setGameTitleId(results.getInt("gt_id"));
                gameDto.setGameName(results.getString("game_name"));
                //need to get opponent data
                Player opponent = getOpponentData(gameDto.getGamePlayId(),currentUserId);
                int gameWinnerId = -1;
                if(opponent != null){
                    gameDto.setOpponentUsername(opponent.getUserName());
                    //set matches for game based on gamePlayId
                    gameDto.setMatches(getMatches(gameDto.getGamePlayId()));
                    //detemine winner id
                    gameWinnerId = getGameWinnerId(gameDto.getMatches(), currentUserId, opponent.getUserId());
                    //determine if user is winner or tied
                    if(gameWinnerId == 0){
                        gameDto.setGameWinner(true);
                        gameDto.setTie(true);
                    }else if(gameWinnerId == currentUserId){
                        gameDto.setGameWinner(true);
                    }else{
                        gameDto.setGameWinner(false);
                    }
                }
                if(gameWinnerId == -1){
                    gameDto.setGameWinner(true);
                }

                games.add(gameDto);
            }


        return games;
    }

    @Override
    public int addMatchForGamePlayRecord(MatchGame matchGame) {
        int matchId = 0;
        String sql = "INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(?,?,now()) RETURNING match_id;";
        if(matchGame.getMatchSecondWinnerId() != 0){
            sql = "INSERT INTO game_match(game_play_id,match_winner_player_id, match_second_winner_player_id, match_date_time)VALUES(?,?,?,now()) RETURNING match_id;";
            matchId = jdbcTemplate.queryForObject(sql, int.class, matchGame.getGamePlayId(), matchGame.getMatchWinnerId(), matchGame.getMatchSecondWinnerId());
        } else{
            matchId = jdbcTemplate.queryForObject(sql, int.class, matchGame.getGamePlayId(), matchGame.getMatchWinnerId());
        }


        return matchId;
    }


    /*getGameWinner returns 0 if the count of wins is a tie*/
    public int getGameWinnerId(List<MatchGame> matches, int currentUserId, int opponentId) {
        int countOfCurrentUserWins = 0;
        int countOfOpponentWins = 0;
        for(MatchGame match : matches){
            if(match.getMatchWinnerId() == currentUserId) {
                countOfCurrentUserWins++;
            }
            if(match.getMatchSecondWinnerId() == currentUserId) {
                countOfCurrentUserWins++;
            }
            if(match.getMatchWinnerId() == opponentId){
                countOfOpponentWins++;
            }
            if(match.getMatchSecondWinnerId() == opponentId){
                countOfOpponentWins++;
            }
        }
        if(countOfCurrentUserWins > countOfOpponentWins){
            return currentUserId;
        }else if(countOfCurrentUserWins < countOfOpponentWins) {
           return opponentId;
        } else{
            return 0;
        }
    }

    private Player getOpponentData(int gamePlayId, int userId){
        String sqlGetOpponent = "SELECT username, user_id FROM users \n" +
                "JOIN game_play_player ON users.user_id = game_play_player.player_id \n" +
                "JOIN game_play ON game_play.game_play_id = game_play_player.game_play_id \n" +
                "JOIN game_title ON game_play.game_title_id = game_title.game_title_id \n" +
                "WHERE game_play.game_play_id = ? AND users.user_id != ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetOpponent,gamePlayId,userId);
        Player player = null;
        if(results.next()){
            player = new Player();
            player.setUserId(results.getInt("user_id"));
            player.setUserName(results.getString("username"));
        }

        return player;
    }
    private List<MatchGame> getMatches(int gamePlayId){
        List<MatchGame> matches = new ArrayList<>();
        String sql = "SELECT * FROM game_match WHERE game_play_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gamePlayId);
        while(results.next()){
            MatchGame matchGame = new MatchGame();
            matchGame.setMatchId(results.getInt("match_id"));
            matchGame.setGamePlayId(results.getInt("game_play_id"));
            matchGame.setMatchWinnerId(results.getInt("match_winner_player_id"));
            matchGame.setMatchSecondWinnerId(results.getInt("match_second_winner_player_id"));
            matchGame.setDateTimeOfMatch(results.getDate("match_date_time").toLocalDate());
            matches.add(matchGame);
        }
        return matches;
    }


}
