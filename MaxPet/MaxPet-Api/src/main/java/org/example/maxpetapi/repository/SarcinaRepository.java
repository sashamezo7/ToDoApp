package org.example.maxpetapi.repository;

import jakarta.transaction.Transactional;
import org.example.maxpetapi.entity.SarcinaEntity;
import org.example.maxpetapi.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SarcinaRepository extends JpaRepository<SarcinaEntity,Integer> {
    List<SarcinaEntity> findByUserAndActiv(UsersEntity user, int activ);
    List<SarcinaEntity> findByUserOrderByActivDesc(UsersEntity user);
    List<SarcinaEntity> findByUserOrderByActivAsc(UsersEntity user);
    @Transactional
    void deleteByUserAndActiv(UsersEntity user, int activ);


}
