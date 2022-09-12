package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
public class BookingSystem {
    private Map<Integer,User> users;
    private Map<Integer,Theater>theaters;

    public BookingSystem(Map<Integer, User> users, Map<Integer, Theater> theaters) {
        this.users = users;
        this.theaters = theaters;
    }
}
