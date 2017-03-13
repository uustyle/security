package sample.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SampleUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		if (username.equals("user")) {
			authorities.add(new SimpleGrantedAuthority("user_role"));
		} else if (username.equals("admin")) {
			authorities.add(new SimpleGrantedAuthority("admin_role"));
		}

		return new User(username, "arakawa", authorities);
	}
}
