package model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Ticket {
    String ticketId;
    LocalDateTime timing;
    int movieId;
    int screenId;
    int theaterId;
    User user;
}
