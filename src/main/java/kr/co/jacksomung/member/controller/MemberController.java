package kr.co.jacksomung.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jacksomung.member.domain.Member;
import kr.co.jacksomung.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "member/join";
	}
	
	@RequestMapping(value="/member/join.do", method=RequestMethod.POST)
	public String registerMember(@RequestParam("member-id") String memberId
								,@RequestParam("member-pw2") String memberPw
								,@RequestParam("member-name") String memberName
								,@RequestParam("member-email") String memberEmail
								,@RequestParam("member-phone") String memberPhone
								,@RequestParam("member-address") String memberAddress
								, Model model) {
		
		Member member = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberAddress);
		int result = service.insertMember(member);
		if(result > 0) {
			model.addAttribute("msg", "회원가입에 성공하였습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}else {
			model.addAttribute("msg", "회원가입에 실패하였습니다.");
			model.addAttribute("url", "/member/join.do");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String loginCheck() {
		
		return "member/login";
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String loginCheck(@RequestParam("member-id") String memberId
							,@RequestParam("member-pw") String memberPw
							,HttpSession session
							,Model model) {
		Member loginMember = new Member(memberId, memberPw);
		Member mOne = service.selectCheckLogin(loginMember);
		if(mOne != null) {
			session.setAttribute("memberId", memberId);
			session.setAttribute("memberName", mOne.getMemberName());
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg","아이디와 비밀번호를 확인해주세요.");
			model.addAttribute("url","/member/login.do");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/member/myPage.do", method=RequestMethod.GET)
	public String mypageViewMember(@RequestParam("memberId") String memberId
								,Model model) {
		Member mOne = service.selectOneById(memberId);
		if(mOne != null) {
			model.addAttribute("member", mOne);
			return"member/mypage";
		}else {
			model.addAttribute("msg", "정보를 찾을 수 없습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/member/modify.do", method=RequestMethod.GET)
	public String modifyViewMember(@RequestParam("memberId") String memberId
								, Model model) {
		Member mOne = service.selectOneById(memberId);
		if(mOne != null) {
			model.addAttribute("member", mOne);
			return"member/modify";
		}else {
			model.addAttribute("msg", "정보를 찾을 수 없습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession session, Model model) {
		if(session != null) {			
			session.invalidate();
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg", "로그아웃이 완료되지 않았습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/member/modify.do", method=RequestMethod.POST)
	public String modifyMember(@RequestParam("member-id") String memberId
							, @RequestParam("member-pw") String memberPw
							, @RequestParam("member-email") String memberEmail
							, @RequestParam("member-phone") String memberPhone
							, @RequestParam("member-address") String memberAddress
							, Model model) {
		Member mOne = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress);
		int result = service.updateMember(mOne);
		if(result > 0) {
			model.addAttribute("msg", "정보 수정이 완료되었습니다.");
			model.addAttribute("url","/member/modify.do?memberId="+memberId);
			return "member/pop-upNotice";
		}else {
			model.addAttribute("msg", "정보를 빠짐없이 입력해주세요.");
			model.addAttribute("url", "/member/modify.do?memberId="+memberId);
			return "member/pop-upNotice";
		}
	}
	
}
