package com.tk.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

/**授权服务配置
 * @date: 2020/11/3 9:22
 * @author: TK tianchaofa@vmeshou.com
 */
@Configuration
//标志为授权服务
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  /**
   * 象建模认证管理器，用于处理一个认证请求
   */
  @Autowired(required = false)
  private AuthenticationManager authenticationManager;

  /**
   * 用来配置令牌端点(Token Endpoint)的安全约束；
   * @param security
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    security.tokenKeyAccess("permitAll()")  // 开启/oauth/token_key验证端口无权限访问
      .checkTokenAccess("isAuthenticated()")  // 开启/oauth/check_token验证端口认证权限访问
      .allowFormAuthenticationForClients();   //开启校验token
  }

  /**
   * 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化。
   * 可以把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息；
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(new JdbcClientDetailsService(null));
  }

  /**
   * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
   * 还有token的存储方式(tokenStore)；
   * @param endpoints
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    super.configure(endpoints);
  }
}
