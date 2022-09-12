package model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class Movie {
    int id;
    int weekNo;
    String name;
    LocalDateTime releaseData;
    List<Screen> screens;
}
