package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    private String orderId;
    private LocalDateTime orderTime;
    private String destinationAddress;
    private Users users;
    private Checkbox completed;
}
