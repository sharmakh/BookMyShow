package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Screen {
    int screenId;
    int capacity;
    String name;
}
