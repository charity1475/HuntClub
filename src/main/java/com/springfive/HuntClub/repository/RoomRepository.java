package com.springfive.HuntClub.repository;

import com.springfive.HuntClub.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<RoomEntity, Long > {
    Optional<RoomEntity> findById(Long id);
}
