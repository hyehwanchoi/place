package com.hot.place.member.ui;

import com.hot.place.member.application.MemberService;
import com.hot.place.member.dto.MemberRequest;
import com.hot.place.member.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberRequest memberRequest) {
        MemberResponse memberResponse = memberService.saveMember(memberRequest);
        return ResponseEntity.created(URI.create("/member/" + memberResponse.getId())).body(memberResponse);
    }

    /**
     * 사용자 조회
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity findMemberById(@PathVariable long id) {
        return ResponseEntity.ok(memberService.findMemberById(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> findAllMember() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @PutMapping(value = "/{id}/point")
    public ResponseEntity<MemberResponse> addPoint(@PathVariable long id, @RequestParam int point) {
        memberService.addPoint(id, point);
        return ResponseEntity.ok().build();
    }
}
