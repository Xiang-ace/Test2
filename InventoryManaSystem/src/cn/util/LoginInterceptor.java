package cn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import cn.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String path=request.getContextPath();
		if(user == null){
			//浏览权限
			response.sendRedirect(path+"/401.jsp");
			return false;
		}
		return true;
	}
	
}
