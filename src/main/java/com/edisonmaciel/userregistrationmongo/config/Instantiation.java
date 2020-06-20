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
import com.edisonmaciel.userregistrationmongo.dto.CommentDTO;
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
	
		User tinhoso = new User(null, "Tinhoso Malandro", "chifroneto@gmail.com");
		User thigas = new User(null, "Thigas", "thigas@gmail.com");
		User praieiro = new User(null, "Praieiro Frustrado", "bobweed@gmail.com");
		
		userRepository.saveAll(Arrays.asList(tinhoso, thigas, praieiro));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Popularidade de linguagem de programação", "O que você acha de Java?", new AuthorDTO(tinhoso));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje.", new AuthorDTO(tinhoso));
		
		CommentDTO c1 = new CommentDTO("Uma bosta, parceiro.", sdf.parse("21/03/2018"), new AuthorDTO(thigas));
		CommentDTO c2 = new CommentDTO("Toma jeito, vacião.", sdf.parse("21/03/2018"), new AuthorDTO(praieiro));
		CommentDTO c3 = new CommentDTO("Tenha um bom dia!", sdf.parse("21/03/2018"), new AuthorDTO(thigas));
		
		post1.getComment().addAll(Arrays.asList(c1, c2));
		post2.getComment().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		tinhoso.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(tinhoso);

	}

}
