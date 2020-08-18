package cn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import cn.entity.User;

public class EmployeeInterceptor extends LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String path=request.getContextPath();
		if(user != null && user.getUserRole() == 3){
			response.sendRedirect(path+"/403.jsp");
			return false;
		}
		return true;
	}
	
}
