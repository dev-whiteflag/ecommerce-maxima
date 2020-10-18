package com.maximatech.ecommerce.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionZuulPreFilter extends ZuulFilter {

    private SessionRepository repository;

    @Autowired
    public SessionZuulPreFilter(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession httpSession = context.getRequest().getSession();
        Session session = repository.findById(httpSession.getId());
        context.addZuulRequestHeader("Cookie", "SESSION=" + httpSession.getId());
        return null;
    }

    @Override
    public String filterType(){
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
