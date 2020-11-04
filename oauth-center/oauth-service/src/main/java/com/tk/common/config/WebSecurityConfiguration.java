package com.tk.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**Security网站安配置
 * @date: 2020/11/3 10:19
 * @author: TK tianchaofa@vmeshou.com
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http    // 配置登陆页/login并允许访问
      .formLogin().permitAll()
      // 登出页
      .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
      // 其余所有请求全部需要鉴权认证
      .and().authorizeRequests().anyRequest().authenticated()
      // 由于使用的是JWT，我们这里不需要csrf
      .and().csrf().disable();
  }
}
