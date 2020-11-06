package com.springfive.HuntClub.model.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class ReservationRequest {

    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

    public ReservationRequest() {
        super();
    }

    public ReservationRequest(Long id, LocalDate checkin, LocalDate checkout) {
        super();
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
