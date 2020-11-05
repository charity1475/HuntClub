package com.springfive.HuntClub.convertor;

import com.springfive.HuntClub.entity.RoomEntity;
import com.springfive.HuntClub.model.Links;
import com.springfive.HuntClub.model.Self;
import com.springfive.HuntClub.model.response.ReservationResponse;
import com.springfive.HuntClub.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservationResponseConvertor implements Converter<RoomEntity, ReservationResponse> {
    @Override
    public ReservationResponse convert(RoomEntity roomEntity) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(roomEntity.getRoomNumber());
        reservationResponse.setPrice(roomEntity.getPrice());
        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + roomEntity.getId());
        reservationResponse.setLinks(links);
        return null;
    }
}
