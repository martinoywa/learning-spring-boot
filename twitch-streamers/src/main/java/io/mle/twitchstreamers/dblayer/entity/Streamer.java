package io.mle.twitchstreamers.dblayer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Setter
@Getter
@ToString
public class Streamer {
    private int id;
    private String realName;
    private String twitchName;
    private String nationality;
    private Date birthDate;
    private double followerCount;
    private double netWorthMillions;

    public Streamer() {}

    public Streamer(int id, String realName, String twitchName, String nationality, Date birthDate, double followerCount, double netWorthMillions) {
        this.id = id;
        this.realName = realName;
        this.twitchName = twitchName;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.followerCount = followerCount;
        this.netWorthMillions = netWorthMillions;
    }
}
