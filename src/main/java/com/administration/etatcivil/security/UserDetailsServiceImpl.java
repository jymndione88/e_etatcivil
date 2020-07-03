package com.administration.etatcivil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.administration.etatcivil.entities.Internautes;
import com.administration.etatcivil.repositories.InternauteRepository;;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	InternauteRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Internautes user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User non trouvé avec ce login: " + username));

		return UserDetailsImpl.build(user);
	}

}
