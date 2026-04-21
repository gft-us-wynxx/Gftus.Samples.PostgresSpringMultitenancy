package br.com.fullcustom.postgresmultitenancy.config

import java.text.SimpleDateFormat
import java.util.Arrays
import java.util.TimeZone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import br.com.fullcustom.postgresmultitenancy.domain.Author
import br.com.fullcustom.postgresmultitenancy.domain.Post
import br.com.fullcustom.postgresmultitenancy.repository.AuthorRepository
import br.com.fullcustom.postgresmultitenancy.repository.PostRepository

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private AuthorRepository userRepository

	@Autowired
	private PostRepository postReposiroty

	@Override
	public void run(String... args) throws Exception {

		var sdf = new SimpleDateFormat("ddMMyyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postReposiroty.deleteAll();

		var maria = new Author(null, "Maria Brown", "maria@gmail.com");
		var alex = new Author(null, "Alex Green", "alex@gmail.com");
		var bob = new Author(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		var post1 = new Post(null, sdf.parse("21032018"), "Off on a trip", "Heading to São Paulo. Cheers!", maria);
		var post2 = new Post(null, sdf.parse("23032018"), "Good morning", "Woke up happy today!", maria);
		postReposiroty.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}