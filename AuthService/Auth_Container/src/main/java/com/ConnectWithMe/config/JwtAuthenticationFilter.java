package com.ConnectWithMe.config;

import com.ConnectWithMe.Domain.ports.input.service.jwtService;
import io.jsonwebtoken.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final jwtService jwtservice;
    @Autowired
    public JwtAuthenticationFilter(jwtService jwtservice) {
        this.jwtservice = jwtservice;
    }

    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        System.out.println("authheader "+authHeader);

        if (authHeader == null || authHeader.startsWith("Bearer ") && request.getRequestURI().equals("Auth/v1/api/Login/")) {
            System.out.println("in if");
            System.out.println(authHeader == null || !authHeader.startsWith("Bearer ") && !request.getRequestURI().equals("/api/v1/employee/login"));
            System.out.println(authHeader == null);
//        System.out.println(!authHeader.startsWith("Bearer "));
//        System.out.println(!request.getRequestURI().equals("/api/v1/employee/login"));
            filterChain.doFilter(request, response);
            System.out.println("filterchain");
            return;
        }
        System.out.println("after if");

        final String token = authHeader.substring(7);
        System.out.println("token"+token);

        try {
            // Change this to your secret key
            String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";
            System.out.println(jwtservice.isTokenValid(token));
            if (jwtservice.isTokenValid(token)) {
                System.out.println("in if of filter");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

            String userID = claims.get("sub", String.class);
            System.out.println(userID);

            String userName = claims.get("userName", String.class);

            request.setAttribute("userName", userName);

            UserDetails userDetails = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    System.out.println("granted authority");
                    Collection<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority(userID));
                    return authorities;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public String getUsername() {
                    return null;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
            System.out.println("before" + (userName != null));
            System.out.println("before" + (SecurityContextHolder.getContext().getAuthentication() == null));

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                System.out.println("in if employeename != null");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userID, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        } catch (ExpiredJwtException e) {
            System.out.println("JWT expired: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("JWT expired: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Error processing JWT: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Error processing JWT: " + e.getMessage());
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("in getauth");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        System.out.println("out getauth");
        filterChain.doFilter(request, response);
        System.out.println("filter");
    }
}
