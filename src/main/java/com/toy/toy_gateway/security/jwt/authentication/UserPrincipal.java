package com.toy.toy_gateway.security.jwt.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class UserPrincipal implements Principal {
    private final String userId;
    @Getter
    private final String nickName;

    public boolean hasName(){
        return userId != null;
    }
    public boolean hasMandatory(){
        return userId != null;
    }

    @Override
    public boolean equals(Object another){
        if (this == another) return true;
        if (another == null) return false;
        if (!getClass().isAssignableFrom(another.getClass())) return false;
        UserPrincipal principal = (UserPrincipal) another;
        return Objects.equals(userId, principal.userId);
    }
    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
    @Override
    public String toString() {
        return getName();
    }
    @Override
    public String getName() {
        return userId;
    }

}
