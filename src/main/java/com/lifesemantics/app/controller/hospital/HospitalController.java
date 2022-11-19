package com.lifesemantics.app.controller.hospital;

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
@RequestMapping(value="/hospital")
@Controller
@RequiredArgsConstructor
public class HospitalController {
	
	private final LoginService loginService;
	
	/******************
	 * 2022.11.18
	 * 병원 화면
	*******************/
	@GetMapping(value = "/")
	public String hospital() {
		return null;
	}
	
}
