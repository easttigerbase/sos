package com.ssoptimus.sos.repository;

import com.ssoptimus.sos.domain.User.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {

    @Query("select count(u.APPRV_ID) from ApprvDocument u where u.DRAFT_EMP_ID = ?1 and u.APPRV_STATUS = ?2")
    int getApprvCountByIdStatus(String empID,String status);

}
