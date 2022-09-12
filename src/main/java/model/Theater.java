package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Theater {
    private int id;
    private String city;
    private String state;
    private int noOfScreens;
    private List<Screen>screenList;
    private Map<Movie,List<Show>> movieList;
    private List<Ticket> ticketList;
}
