package io.mle.twitchstreamers.dblayer.dao;

import io.mle.twitchstreamers.dblayer.entity.Streamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class StreamerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Streamer> getAllStreamers() {
        String sql = "SELECT * FROM STREAMER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Streamer>(Streamer.class));
    }

    public Streamer getStreamerByID(int id) {
        String sql = "SELECT * FROM STREAMER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Streamer>(Streamer.class), new Object[] {id});
    }

    public int insertStreamer(Streamer streamer) {
        String sql = "INSERT INTO STREAMER ( ID , Real_Name, Twitch_Name, Nationality, Birth_date, Follower_count, Net_worth )" +
                "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
        return jdbcTemplate.update(sql, new Object[]{
                streamer.getId(),
                streamer.getRealName(),
                streamer.getTwitchName(),
                streamer.getNationality(),
                new Timestamp(streamer.getBirthDate().getTime()),
                streamer.getFollowerCount(),
                streamer.getNetWorthMillions()
        });
    }

    public int updateStreamer(Streamer streamer) {
        String sql = "UPDATE STREAMER " +
                "SET Real_Name = ?, Twitch_Name = ?, Nationality = ?, Birth_date = ?, Follower_count = ?, Net_worth = ? " +
                "WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[]{
                streamer.getRealName(),
                streamer.getTwitchName(),
                streamer.getNationality(),
                new Timestamp(streamer.getBirthDate().getTime()),
                streamer.getFollowerCount(),
                streamer.getNetWorthMillions(),
                streamer.getId()
        });
    }

    public int deleteStreamerById(int id) {
        String sql="DELETE FROM STREAMER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }
}
