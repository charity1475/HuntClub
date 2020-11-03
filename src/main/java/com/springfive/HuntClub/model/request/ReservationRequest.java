package com.springfive.HuntClub.model.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class ReservationRequest {
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

}
