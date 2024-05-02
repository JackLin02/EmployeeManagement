package com.ssm.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.model.Role;
import com.ssm.model.User;
import com.ssm.model.UserRole;
import com.ssm.service.RoleService;
import com.ssm.service.UserRoleService;
import com.ssm.service.UserService;
import com.ssm.util.MySecurity;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response, Model model){
		boolean loginSuccess = false;
		User user = null;
		try {
			user = userService.getUserByEmail(email);
			if(user.getPassword().equals(MySecurity.generateMD5(password))){
				loginSuccess = true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			// 登录成功之后，将用户信息保存到Session中
			if(loginSuccess){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				return "redirect:/dashboard";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("error", true);
				return "redirect:/login-error";
			}
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		/*// 清除Session中保存的用户信息
		HttpSession session = request.getSession(false);
		//session.removeAttribute("user");
		if(session != null){
			// 使Session失效
			session.invalidate();
		}
		// 清除Cookie中的Session ID
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("JESSIONID")){
					// 设置Cookie的过期时间为0，即立即失效
					cookie.setMaxAge(0);
					// 设置Cookie的路径，保持与设置时一致
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}*/

		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		// 重定向到登出后的页面 （例如主页或登录页面）
		return "redirect:/sign-in";
	}

	@RequestMapping("/User/{id}")
	public boolean getUser(@PathVariable("id") Integer id) {
		User user = userService.getUser(id);
		if (user != null) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveUser(User user, @RequestParam("roleId") Integer roleId, HttpServletRequest request) {
		int result1, result2;
		result1 = result2 = 0;
		User userByEmail = null;

		try {
			user.setPassword(MySecurity.generateMD5(user.getPassword()));
			result1 = userService.insertUser(user);
			userByEmail = userService.getUserByEmail(user.getEmail());
			int uid = userByEmail.getId();
			UserRole userRole = new UserRole();
			userRole.setUid(uid);
			userRole.setRid(roleId);
			result2 = userRoleService.insertUserRole(userRole);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			if(result1 > 0 && result2 > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userByEmail);
				return "redirect:/dashboard";
			}
			return "redirect:/sign-in";
		}
	}

	/*@RequestMapping("/**")
	public String securePage(HttpServletRequest request){
		// 从Session中获取用户信息
		HttpSession session = request.getSession(false); // 参数为false表示不创建新的Session，如果Session不能再则返回null
		if(session != null) {
			Object user = session.getAttribute("user");
			if(user != null){
				return "dashboard";
			}
		}
		return "redirect:/sign-in";
	}*/

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String signIn(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session != null){
			Object error = session.getAttribute("error");
			Object url = session.getAttribute("targetUrl");
			if(error != null){
				session.removeAttribute("error");
			}
			if(url != null){
				session.removeAttribute("url");
			}
		}
		return "pages/sign-in";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String getRoles(Model model){
		List<Role> roles = roleService.getAllRole();
		model.addAttribute("roles", roles);
		return "pages/sign-up";
	}
}