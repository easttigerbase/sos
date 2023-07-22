package com.ssoptimus.sos.service.Workflow;

import com.ssoptimus.sos.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprvService {

    /**
     *
     *
     *
     **/
    private final MemberRepository memberRepository;

    @Autowired
    public ApprvService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int getApprvCountByIdStatus(String empId, String status){
        return memberRepository.getApprvCountByIdStatus(empId,status);

    }

}
