package com.nntk.sb.api;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.nntk.sb.rest.HttpFactory;
import com.nntk.sb.rest.HttpPlusResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HutoolHttpFactory extends HttpFactory {
    @Override
    public HttpPlusResponse post(String url, Map<String, String> header, String body) {
        HttpRequest httpRequest = HttpUtil.createPost(url);

        httpRequest.body(body);
        if (header != null) {
            httpRequest.addHeaders(header);
        }
        HttpResponse response = httpRequest.execute();
        HttpPlusResponse httpPlusResponse = new HttpPlusResponse();
        httpPlusResponse.setHttpStatus(response.getStatus());
        httpPlusResponse.setBody(response.body());
        return httpPlusResponse;
    }

    @Override
    public HttpPlusResponse get(String url, Map<String, String> header) {
        return null;
    }
}
