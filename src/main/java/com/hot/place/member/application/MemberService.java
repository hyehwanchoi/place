package com.hot.place.member.application;

import com.hot.place.member.domain.Member;
import com.hot.place.member.domain.MemberRepository;
import com.hot.place.member.dto.MemberRequest;
import com.hot.place.member.dto.MemberResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::of)
                .collect(Collectors.toList());
    }

    public MemberResponse saveMember(MemberRequest request) {
        Member persistMember = memberRepository.save(new Member(request.getName(), request.getEmail(), request.getPassword()));
        return MemberResponse.of(persistMember);
    }

    public Member findMemberResponseById(long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
