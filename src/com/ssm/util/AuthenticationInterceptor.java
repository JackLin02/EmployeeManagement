package com.ssm.util;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * String signinURI = request.getContextPath() + "/sign-in"; // sign in
		 * page path String loginURI = request.getContextPath() + "/login";
		 * String loginFail = request.getContextPath() + "/login-fail"; String
		 * requestURI = request.getRequestURI(); if(requestURI.equals(signinURI)
		 * || requestURI.equals(loginURI) || requestURI.equals(requestURI)){
		 * return true; }
		 */

		String contextPath = request.getContextPath();
		String userRequest = contextPath + "/user";
		String signInRequest = contextPath + "/sign-in";
		String requestURI = request.getRequestURI();
		if (requestURI.equals(userRequest) && request.getMethod().equalsIgnoreCase("POST")) {
			return true;
		}

		Object user = request.getSession().getAttribute("user");

		if (requestURI.equals(signInRequest)) {
			if(user != null) {
				request.getRequestDispatcher("/login-already").forward(request, response);
			} else {
				return true;
			}
		} else {
			if (user == null) {
				// user is not login
				/*
				 * StringBuilder sb = new StringBuilder();
				 * sb.append(request.getContextPath());
				 * sb.append(File.separator); sb.append("sign-in");
				 *
				 * String targetUrl = sb.toString();
				 *
				 * HttpSession session = request.getSession();
				 * session.setAttribute("targetUrl", targetUrl);
				 */

				response.sendRedirect(contextPath + "/login-fail");
				return false;
			}
		}

		// user is login
		return true;
	}

}
