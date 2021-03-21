package com.sheke.walking.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtDataSource {
    private String secretKey;
    private String tokenPrefix;
    private Long expirationDate;
}
