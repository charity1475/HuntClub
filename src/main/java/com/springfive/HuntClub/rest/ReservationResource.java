package com.springfive.HuntClub.rest;

import com.springfive.HuntClub.convertor.RoomEntityToReservationResponseConvertor;
import com.springfive.HuntClub.entity.RoomEntity;
import com.springfive.HuntClub.model.request.ReservationRequest;
import com.springfive.HuntClub.model.response.ReservationResponse;
import com.springfive.HuntClub.repository.PageableRoomRepo;
import com.springfive.HuntClub.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Converter;
import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepo pageableRoomRepo;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private RoomEntityToReservationResponseConvertor converter;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page getAvailableRooms(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout, Pageable pageable) {

            Page<RoomEntity> roomEntityList=pageableRoomRepo.findAll(pageable);
            return  roomEntityList;
        //return (ReservationResponse) roomEntityList.map(converter::convert);
    }
    @RequestMapping(path = "", method =RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest){
            return new ResponseEntity<>(new ReservationResponse(),HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method =RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestBody
                    ReservationRequest reservationRequest){
        return new ResponseEntity<>(new ReservationResponse(),HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable()
            long reservationId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
