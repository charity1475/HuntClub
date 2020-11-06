package com.springfive.HuntClub.rest;

import com.springfive.HuntClub.convertor.RoomEntityToReservableRoomResponseConverter;
import com.springfive.HuntClub.entity.RoomEntity;
import com.springfive.HuntClub.model.request.ReservationRequest;
import com.springfive.HuntClub.model.response.ReservableRoomResponse;
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

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepo pageableRoomRepo;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private RoomEntityToReservableRoomResponseConverter converter;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReservableRoomResponse getAvailableRooms(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout, Pageable pageable) {

            Page<RoomEntity> roomEntityList=pageableRoomRepo.findAll(pageable);
        //return roomEntityList.map(new RoomEntityToReservableRoomResponseConverter());

        return (ReservableRoomResponse) roomEntityList.map(converter::convert);
    }
    @RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional> getRoomById(
            @PathVariable
                    Long roomId) {

        Optional<RoomEntity> roomEntity = roomRepository.findById(roomId);

        return new ResponseEntity<Optional>(roomEntity, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> createReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> updateReservation(
            @RequestBody
                    ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable
                    long reservationId) {

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

/*
*
* @RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(path ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableRoomResponse> getAvailableRooms (
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate checkout, Pageable pageable) {

        Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);

        return roomEntityList.map(new RoomEntityToReservableRoomResponseConverter());
    }

    @RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomById(
            @PathVariable
                    Long roomId) {

        RoomEntity roomEntity = roomRepository.findById(roomId);

        return new ResponseEntity<>(roomEntity, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> createReservation(
            @RequestBody
            ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> updateReservation(
            @RequestBody
            ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable
            long reservationId) {

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

*
* */