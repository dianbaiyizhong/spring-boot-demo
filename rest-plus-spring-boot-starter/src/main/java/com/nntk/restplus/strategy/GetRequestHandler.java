package com.nntk.restplus.strategy;

import com.nntk.restplus.AbsHttpFactory;
import com.nntk.restplus.RestPlusResponse;
import org.springframework.stereotype.Component;

@Component
public class GetRequestHandler extends HttpRequestBaseHandler {


    @Override
    public RestPlusResponse executeHttp(HttpExecuteContext context) {
        AbsHttpFactory httpFactory = context.getHttpFactory();
        String url = context.getUrl();
        return httpFactory.get(url, context.getHeaderMap());
    }
}
