package com.lifesemantics.app.controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lifesemantics.app.model.MemberInVO;
import com.lifesemantics.app.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/login")
@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	
	/******************
	 * 2022.11.18
	 * 로그인 화면
	*******************/
	@GetMapping(value = "/")
	public ModelAndView login(ModelAndView mv, 
							  @CookieValue(value="savedId", required=false) Cookie cookie) {
		if(cookie != null) {
			mv.addObject("savedId", cookie.getValue());
		}
		mv.setViewName("login");
		return mv;
	}
	
	/*****************
	 * 2022.11.18
	 * 로그인 처리
	******************/
	@PostMapping(value="/loginProcess")
	public String loginProcess(@RequestBody MemberInVO memberInVo
										, HttpServletResponse response
										, HttpSession session
										, Model model){
		int result = loginService.selectLoginId(memberInVo);
		
		if(result == 1) {
			// 로그인 성공
			session.setAttribute("memberId", memberInVo.getMemberId());
			Cookie saveCookie = new Cookie("savedId", memberInVo.getMemberId());
			if(memberInVo.isRemember() == true) {
				saveCookie.setMaxAge(60*60);
			}else {
				saveCookie.setMaxAge(0);
			}
			response.addCookie(saveCookie);
//			String page = "hospital";
//			return new ResponseEntity<>(page, HttpStatus.OK);
			return "hospital";
		}else {
//			String page = "login";
//			return new ResponseEntity<>(page, HttpStatus.OK);
			model.addAttribute("result", result);
			return "login";
		}
	}
	
}
