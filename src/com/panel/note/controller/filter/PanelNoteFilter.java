package com.panel.note.controller.filter;

import java.io.IOException;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.panel.note.dto.response.RedirectRes;
import com.panel.note.util.Const;
import com.panel.note.util.ResponseUtil;




public class PanelNoteFilter implements Filter{
    
    

    private FilterConfig filterConfig;
    protected static final Logger logger = Logger.getLogger(PanelNoteFilter.class.getName());

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        @SuppressWarnings("unused")
        ServletContext context = this.filterConfig.getServletContext();
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        String requestType = req.getHeader("RequestType");

        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session     = req.getSession();
        if(path != null && (path.contains("/login") || path.contains("auth/logined"))) {
            chain.doFilter(request, response);
            return;
        }
       
        
        
        if (session.getAttribute(Const.LOGIN_DATA) != null) {
            chain.doFilter(request, response);
        } else {
            logger.info("Session null");

            if ("ajax".equals(requestType)) {
                RedirectRes rres = new RedirectRes();
                rres.setTime(System.currentTimeMillis());
                rres.setResult(20);
                rres.setRedirect(Const.PAGE_LOGIN);
                ResponseUtil.dtoToResponse(request.getParameter("format"), rres, req, res);
            } else {
//                RequestDispatcher  rc  = request.getRequestDispatcher("/index.html");
//                rc.forward(request, response);
                res.sendRedirect("/");
                
            }
        }
        
   }

    @Override
    public void destroy() {
        this.filterConfig = null;
        
    }
}