package com.mongodbtraining.mongotraining.config;

import com.mongodbtraining.mongotraining.domain.Post;
import com.mongodbtraining.mongotraining.domain.User;
import com.mongodbtraining.mongotraining.dto.AuthorDTO;
import com.mongodbtraining.mongotraining.dto.CommentDTO;
import com.mongodbtraining.mongotraining.repository.PostRepository;
import com.mongodbtraining.mongotraining.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex,bob));

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para SP!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("26/03/2023"), "Bom dia", "O sol já nasceu lá na fazendinha", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2023"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2023"), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(c1));
        post1.getComments().addAll(Arrays.asList(c2));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
