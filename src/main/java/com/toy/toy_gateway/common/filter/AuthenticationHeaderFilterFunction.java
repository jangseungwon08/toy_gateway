package com.toy.toy_gateway.common.filter;


import com.toy.toy_gateway.common.util.HttpUtils;
import com.toy.toy_gateway.security.jwt.authentication.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.function.ServerRequest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

class AuthenticationHeaderFilterFunction {
//    헤더에다가 값을 넣는 작업을 하는것이니까
    public static Function<ServerRequest, ServerRequest> addHeader() {

        return request -> {

            ServerRequest.Builder requestBuilder = ServerRequest.from(request);
//            중간에 필요한 securtiycontextHolder에 저장되어있는 principal값을 가져온다
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserPrincipal userPrincipal) {
                requestBuilder.header("X-Auth-UserId", userPrincipal.getUserId());
                String encodedNickName = URLEncoder.encode(userPrincipal.getNickName(), StandardCharsets.UTF_8);
                requestBuilder.header("X-Auth-UserNickName", encodedNickName);

// 필요시 권한 정보 입력
//                맆요시 다른 Claims정보들도 적어주면 된다.
// requestBuilder.header("X-Auth-Authorities", ...);
            }
// String remoteAddr = HttpUtils.getRemoteAddr(requestBuildert.servletRequest());

            String remoteAddr = HttpUtils.getRemoteAddr(request.servletRequest());
            requestBuilder.header("X-Client-Address", remoteAddr);
            String device = "WEB";
            requestBuilder.header("X-Client-Device", device);
            return requestBuilder.build();
        };
    }
}