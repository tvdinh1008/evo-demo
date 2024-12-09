1. Common web (security), client
  + Xác thực các client call: đính thêm header request sử dụng FeignClientInterceptor implements RequestInterceptor
2. Multi issuer_url
   + AuthenticationManagerResolver
4. Filter security oauth2
   + BearerTokenAuthenticationFilter(Mặc định: check public-key, thời gian hết hạn)  -> ForbiddenTokenFilter(check blacklist token) -> CustomAuthenticationFilter(Enrich UserAuthentication) -> ActionLogFilter(log)
   + Khi sử dụng thêm custom filter Override hàm shouldNotFilter
5. x
