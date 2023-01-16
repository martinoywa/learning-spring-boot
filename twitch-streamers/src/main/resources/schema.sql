CREATE TABLE Streamer (
    ID INTEGER NOT NULL,
    Real_Name VARCHAR(255) NOT NULL,
    Twitch_Name VARCHAR(255) NOT NULL,
    Nationality VARCHAR(255) NOT NULL,
    Birth_date TIMESTAMP,
    Follower_count FLOAT,
    Net_worth FLOAT,
    PRIMARY KEY (ID)
);