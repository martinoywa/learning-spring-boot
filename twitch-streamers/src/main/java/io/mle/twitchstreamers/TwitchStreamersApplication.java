package io.mle.twitchstreamers;

import io.mle.twitchstreamers.dblayer.dao.StreamerDao;
import io.mle.twitchstreamers.dblayer.entity.Streamer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.sql.Date;

@SpringBootApplication
public class TwitchStreamersApplication implements CommandLineRunner {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StreamerDao streamerDao;

    public static void main(String[] args) {
        SpringApplication.run(TwitchStreamersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("Streamer with id 3: {}", streamerDao.getStreamerByID(3));
        // add a streamer
        logger.info("Insert Streamer 4: {}", streamerDao.insertStreamer(
                new Streamer(4, "Raúl Álvarez", "auronplay", "Spanish",
                        Date.valueOf("1988-11-05"), 14.4, 11)
        ));

        // update a streamer
        logger.info("Insert Streamer 2: {}", streamerDao.updateStreamer(
                new Streamer(2, "Richard Tyler Blevins", "Ninja", "American",
                        Date.valueOf("1991-06-05"), 18.4, 40)
        ));
//        logger.info("All Streamer Data: {}", streamerDao.getAllStreamers());
        logger.info("Streamer with id 2: {}", streamerDao.getStreamerByID(2));

        // delete a streamer
        logger.info("Deleting Player with Id 1: {}", streamerDao.deleteStreamerById(1));
        logger.info("All Players Data: {}", streamerDao.getAllStreamers());
    }

}
