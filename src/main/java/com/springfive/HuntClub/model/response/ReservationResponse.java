package com.springfive.HuntClub.model.response;

import lombok.Data;
@Data
public class ReservationResponse {
    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Links links;
}
