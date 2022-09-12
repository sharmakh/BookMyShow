package model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Show {

    private int showId;
    private LocalDateTime start;
    private LocalDateTime end;
}
