package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CharsetFilter",
        urlPatterns = "/*",/*通配符（*）表示对所有的web资源进行拦截*/
        initParams = {
                @WebInitParam(name = "charset", value = "utf-8")/*这里可以放一些初始化的参数*/
        })
public class MyFilter implements Filter {
    private String filterName;
    private String charset;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterName = filterConfig.getFilterName();
        charset = filterConfig.getInitParameter("charset");
    }

    public void destroy() {
        /*销毁时调用*/
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理*/
        req.setCharacterEncoding(charset);
        resp.setCharacterEncoding(charset);

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if(request.getParameter("islogin")!=null) {
        	chain.doFilter(req, resp);
        	return;
        }
        if(request.getRequestURL().indexOf("static")>0) {
        	chain.doFilter(req, resp);
        	return;
        }

        if(request.getRequestURL().indexOf("SendEmailKey")>0) {
        	chain.doFilter(req, resp);
        	return;
        }
        if(request.getRequestURL().indexOf("register.jsp")>0) {
        	chain.doFilter(req, resp);
        	return;
        }
        if(request.getRequestURL().indexOf("CheckUserName")>0) {
        	chain.doFilter(req, resp);
        	return;
        }
        
        if(request.getRequestURL().indexOf("Register")>0) {
        	chain.doFilter(req, resp);
        	return;
        }
        if(request.getSession().getAttribute("user")==null) {
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        	return;
        }
        
        
        
        
        	
        chain.doFilter(req, resp);
        
    }


}
