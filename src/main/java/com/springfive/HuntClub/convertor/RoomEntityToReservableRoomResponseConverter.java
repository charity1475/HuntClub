package com.springfive.HuntClub.convertor;

import com.springfive.HuntClub.entity.RoomEntity;
import com.springfive.HuntClub.model.Links;
import com.springfive.HuntClub.model.Self;
import com.springfive.HuntClub.model.response.ReservableRoomResponse;
import com.springfive.HuntClub.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {
    @Override
    public ReservableRoomResponse convert(RoomEntity source) {

        ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
        reservationResponse.setRoomNumber(source.getRoomNumber());
        reservationResponse.setPrice( Integer.valueOf(source.getPrice()) );

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);

        reservationResponse.setLinks(links);

        return reservationResponse;
    }

}
