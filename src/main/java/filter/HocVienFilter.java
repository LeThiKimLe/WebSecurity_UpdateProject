package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utilsclass.JWT_authen;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Servlet Filter implementation class HocVienFilter
 */
@WebFilter(urlPatterns = {"/cart","/pay"})
public class HocVienFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public HocVienFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		Claims claims=null;
		String token="";
    	if(cookies!=null)
    	{
    		for(Cookie cookie : cookies)
	    	{
	    		if(cookie.getName().equals("access_token"))
	    		{
	    			token=cookie.getValue();
	    			if (token!=null)
	    			{
	    				try {
							claims=JWT_authen.parseJwt(token);
							String role= (String) claims.get("role");
							if (role.equals("HV"))
							{
								System.out.print("pass");
								chain.doFilter(request, response);
								return;
							}
							else
							{
								try {
									System.out.print("1");
			    					resp.sendError(401);
			    				} catch (IOException e) {
			    					// ...
			    				}
			    				return;
							}
						} catch (ExpiredJwtException e) {
							{
							// TODO Auto-generated catch block
								e.printStackTrace();
								resp.sendError(401, e.getMessage());
								return;
							}
						} catch (UnsupportedJwtException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						} catch (MalformedJwtException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						} catch (SignatureException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						} catch (InvalidKeySpecException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							resp.sendError(401, e.getMessage());
							return;
						}
	    			}
	    			else
	    			{
	    				try {
	    					System.out.print("2");
	    					resp.sendError(401);
	    				} catch (IOException e) {
	    					// ...
	    				}
	    				return;
	    			}
	    		}
	    		
	    	}
    		try {
    			System.out.print("3");
				resp.sendError(401);
			} catch (IOException e) {
				// ...
			}
			return;
    	}
    	try {
    		System.out.print("3");
			resp.sendError(401);
		} catch (IOException e) {
			// ...
		}
		return;
		// pass the request along the filter chain
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
