package com.edisonmaciel.userregistrationmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.edisonmaciel.userregistrationmongo.domain.Post;
import com.edisonmaciel.userregistrationmongo.domain.User;
import com.edisonmaciel.userregistrationmongo.dto.AuthorDTO;
import com.edisonmaciel.userregistrationmongo.repository.PostRepository;
import com.edisonmaciel.userregistrationmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
	
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post("1", sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou vajar para São Paulo. Abraços.", new AuthorDTO(maria));
		Post post2 = new Post("2", sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje.", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
