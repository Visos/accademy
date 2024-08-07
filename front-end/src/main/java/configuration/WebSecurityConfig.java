package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((requests) -> requests
		.requestMatchers("/admin", "/admin/**").hasRole("ADMIN")
		.requestMatchers("/").permitAll()
		.anyRequest().authenticated()
		)
		.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
				)
		.logout((logout) -> logout.permitAll()
				);
		return http.build();
	}

	
	@Bean
	public UserDetailsService userDetailservice() {
		UserDetails user = 
				User.withUsername("user")
				.password(passwordEncoder().encode("pwd"))
				.roles("USER")
				.build();
		
		UserDetails admin = 
				User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
