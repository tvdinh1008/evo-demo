1. Common web (security), client
   + Xác thực các client call: đính thêm header request sử dụng FeignClientInterceptor implements RequestInterceptor
2. Multi issuer_url(self-idp, keycloak)
   + AuthenticationManagerResolver
4. Filter security oauth2
   + BearerTokenAuthenticationFilter(Mặc định: check public-key, thời gian hết hạn)  -> ForbiddenTokenFilter(check blacklist token) -> CustomAuthenticationFilter(Enrich UserAuthentication) -> ActionLogFilter(log). Khi sử dụng thêm custom filter Override hàm shouldNotFilter
   + UserAuthentication -> phân quyền(grantedPermissions), isRoot(super admin), isClient(client call),...
5. Authorization
   + Sử dụng RegexPermissionEvaluator implements PermissionEvaluator -> lấy được UserAuthentication từ CustomAuthenticationFilter sẽ check được phân quyền, super admin, client,...
