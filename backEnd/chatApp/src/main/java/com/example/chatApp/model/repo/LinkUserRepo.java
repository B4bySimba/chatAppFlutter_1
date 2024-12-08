package com.example.chatApp.model.repo;

import com.example.chatApp.model.entity.LinkUserEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LinkUserRepo extends JpaRepository<LinkUserEntity,String> {

    @Query(value = "select l.id_ as idLinkUser_, u.name_ as nameFriend_ " +
            "from link_user_ l, user_ u " +
            "where l.id_user_friend_ = u.id_ and l.id_user_ = :idUser_ and u.name_ like %:nameUser_%",nativeQuery = true)
    List<Tuple> getLinkUserByIdUser(@Param("idUser_") String idUser_,
                                    @Param("nameUser_") String nameUser_);

}
