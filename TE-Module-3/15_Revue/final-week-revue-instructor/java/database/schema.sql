BEGIN TRANSACTION;
DROP TABLE IF EXISTS game_title, game_play, users, game_play_player, game_match;

CREATE TABLE game_title(
    game_title_id serial,
    game_name varchar(100),
    game_img_url varchar(200),
    CONSTRAINT PK_game_title_id PRIMARY KEY (game_title_id)
);
CREATE TABLE game_play(
    game_play_id serial,
    game_title_id int,
    CONSTRAINT PK_game_play_id PRIMARY KEY (game_play_id),
    CONSTRAINT FK_game_title_id FOREIGN KEY (game_title_id) REFERENCES game_title(game_title_id)
);
CREATE TABLE users (
    user_id SERIAL,
    username varchar(50) NOT NULL UNIQUE,
    password_hash varchar(200) NOT NULL,
    role varchar(50) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE game_play_player(
    game_play_id int,
    player_id int,
    CONSTRAINT PK_game_play_id_player_id PRIMARY KEY (game_play_id, player_id),
    CONSTRAINT FK_game_play_id FOREIGN KEY (game_play_id) REFERENCES game_play(game_play_id),
    CONSTRAINT FK_player_id FOREIGN KEY (player_id) REFERENCES users(user_id)
);
CREATE TABLE game_match(
    match_id serial,
    game_play_id int,
    match_winner_player_id int,
    match_second_winner_player_id int,
    match_date_time timestamp,
    CONSTRAINT PK_match_id PRIMARY KEY (match_id),
    CONSTRAINT FK_game_play_id FOREIGN KEY (game_play_id) REFERENCES game_play(game_play_id),
    CONSTRAINT FK_match_winner_player_id FOREIGN KEY (match_winner_player_id) REFERENCES users(user_id),
    CONSTRAINT FK_match_second_winner_player_id FOREIGN KEY (match_second_winner_player_id) REFERENCES users(user_id)
);
COMMIT TRANSACTION;
