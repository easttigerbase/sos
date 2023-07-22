package com.ssoptimus.sos.controller.HR;

import com.ssoptimus.sos.domain.User.Member;
import com.ssoptimus.sos.service.HR.MemberCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/member")
@RestController
public class MemberManagementController {

    private final MemberCRUDService memberCRUDService;

    @Autowired
    public MemberManagementController(MemberCRUDService memberCRUDService) {
        this.memberCRUDService = memberCRUDService;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    private Member createNewMember(@RequestBody Member member){
        System.out.println(member.getUserId());
        return memberCRUDService.createMember(member);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    private List<Member> getMember(@RequestParam(required = false) String id){
        return memberCRUDService.getMember(id);
    }




}
