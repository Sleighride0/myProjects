BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO game_title(game_name, game_img_url) VALUES ('Treasure Hunt', 'src\assets\treasure.jpg'), ('TicTacToe', 'src\assets\tictactoe.png');

INSERT INTO game_play(game_title_id)VALUES(1);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(1,1);
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(1,1,now());

INSERT INTO game_play(game_title_id)VALUES(2);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(2,1);
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(2,1,now());

COMMIT TRANSACTION;
