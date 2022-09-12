package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private int userId;
    private String address;
    private String email;
    private String phoneNo;
    private String accountNo;
    
    @Builder
    public User(int userId, String address, String email, String phoneNo, String accountNo) {
        this.userId = userId;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
        this.accountNo = accountNo;
    }

    
}
