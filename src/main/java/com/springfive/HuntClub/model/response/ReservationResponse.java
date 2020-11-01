package com.springfive.HuntClub.model.response;

import com.springfive.HuntClub.model.Links;
import lombok.Data;
@Data
public class ReservationResponse {
    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Links links;
}
