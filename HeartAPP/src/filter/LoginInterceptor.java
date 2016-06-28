package filter;

import java.util.Map;
import action.LoginAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4109380456482375572L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//如果是登录action，不拦截
		if(LoginAction.class==invocation.getAction().getClass()){
			return invocation.invoke();
		}
		
		Map<String, Object> map=invocation.getInvocationContext().getSession();//获得session
		if(map.get("adminname")==null){
			return "noLogin";
		}
		
		return invocation.invoke();
	}

}
