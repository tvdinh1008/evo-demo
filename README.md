1. Common security, client
  + Xác thực các client call: đính thêm header request sử dụng FeignClientInterceptor implements RequestInterceptor
2. Multi isser_url
   + AuthenticationManagerResolver
4. Filter security oauth2
   + BearerTokenAuthenticationFilter(Mặc định: check public-key, thời gian hết hạn)  -> ForbiddenTokenFilter(check blacklist token) -> CustomAuthenticationFilter(Enrich UserAuthentication) -> ActionLogFilter(log)
5. x
