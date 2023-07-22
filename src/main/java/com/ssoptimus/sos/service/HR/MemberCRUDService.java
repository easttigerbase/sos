package com.ssoptimus.sos.service.HR;


import com.ssoptimus.sos.domain.User.Member;
import com.ssoptimus.sos.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberCRUDService {


    private final MemberRepository memberRepository;

    @Autowired
    public MemberCRUDService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {

        try {
            return memberRepository.save(member);
        }
        catch (Exception ignored){
            return null;
        }
    }

    public List<Member> getMember(String id) {
       return  memberRepository.findAllById(Collections.singleton(id));
    }
}
