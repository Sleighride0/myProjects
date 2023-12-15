BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) VALUES ('player1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('player2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('player3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO game_title(game_name, game_img_url) VALUES ('Treasure Hunt', 'src\assets\treasure.jpg'), ('TicTacToe', 'src\assets\tictactoe.png');

--user played treasure hunt and won
INSERT INTO game_play(game_title_id)VALUES(1);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(1,1);
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(1,1,now());
--user played tic tac toe and won
INSERT INTO game_play(game_title_id)VALUES(2);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(2,1);
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(2,1,now());

--user played tic tac toe against player1 and won 2/3 matches
INSERT INTO game_play(game_title_id)VALUES(2);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(3,1);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(3,3);
--user won match 1
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(3,1,now());
--player 1 won match 2
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(3,3,now());
--user won match 3
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(3,1,now());

--user played tic tac toe against player1 and lost 2/3 matches
INSERT INTO game_play(game_title_id)VALUES(2);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(4,1);
INSERT INTO game_play_player(game_play_id,player_id)VALUES(4,3);
--user won match 1
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(4,1,now());
--player 1 won match 2
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(4,3,now());
--player 1 won match 3
INSERT INTO game_match(game_play_id,match_winner_player_id, match_date_time)VALUES(4,3,now());

UPDATE users SET avatar_img_url = 'https://cdn.pixabay.com/photo/2012/04/26/19/07/crab-42880_640.png' WHERE user_id = 1;
UPDATE users SET avatar_img_url = 'https://cdn.pixabay.com/photo/2013/07/13/11/44/penguin-158551_1280.png' WHERE user_id = 3;
UPDATE users SET avatar_img_url = 'https://cdn.pixabay.com/photo/2012/04/13/21/31/fish-33712_1280.png' WHERE user_id = 4;
UPDATE users SET avatar_img_url = 'https://cdn.pixabay.com/photo/2016/06/16/08/42/monster-1460885_1280.png' WHERE user_id = 5;
COMMIT TRANSACTION;

