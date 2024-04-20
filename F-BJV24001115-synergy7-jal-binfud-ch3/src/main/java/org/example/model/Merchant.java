package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.*;
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)

public class Merchant {
    private Integer merchantId;
    private String merchantName;
    private String merchantLocation;
    private Boolean status;
}
