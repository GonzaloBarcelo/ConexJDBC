package icai.pract10.ConexJDBC;

import ch.qos.logback.classic.Logger;
import icai.pract10.ConexJDBC.model.Contact;
import icai.pract10.ConexJDBC.model.User;
import icai.pract10.ConexJDBC.repository.ContactRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

import icai.pract10.ConexJDBC.repository.UserJdbcTemplateRepository;
import icai.pract10.ConexJDBC.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ConexJdbcApplication implements CommandLineRunner {

	private static final ch.qos.logback.classic.Logger LOGGER = (Logger) LoggerFactory.getLogger(ConexJdbcApplication.class);

	@Autowired
	private UserRepository repository;
	@Autowired
	private Database database;
	@Autowired
	private UserJdbcTemplateRepository userJdbcTemplateRepository;
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"jdbcintro");
		SpringApplication.run(ConexJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//INSERT
		//Con jdbc y añadiendo la query pertinente
		database.insertData();
		database.insertUser(new User("Loren","LorenCH"));
		//Insert con Repository
		repository.save(new User("Eva","EvaCS"));


		//SELECT con @query
		LOGGER.info("\n\n");
		LOGGER.info("Mostrando los valores de las tablas mediante dos métodos distintos:");
		//database.selectAllUsers();
		LOGGER.info("Mostrando mediante repository:");
		for (User u:repository.selectAllUser()){
			LOGGER.info("User: "+u.getUserName()+" passw: "+u.getPassword());
		}

		//Update the pasword or different fields with @Querys or repository
		LOGGER.info("\n\n\n Modificando los usuarios:");
		repository.updateByIdTheUserName(1L,"Iñigo");
		userJdbcTemplateRepository.update(new User("Eva","EVA"));

		//Mostrar que los cambios han sido exitosos:
		LOGGER.info("Mostrando mediante repository:");
		for (User u:repository.selectAllUser()){
			LOGGER.info("User: "+u.getUserName()+" passw: "+u.getPassword());
		}

		LOGGER.info("\n\n\n Borrando Usuarios");

		//DELETE FORMA 1 CON DELETE()
		//Borrado mediante ID
		Optional<User> optionalUser = repository.findById(1L);
		optionalUser.ifPresent(user -> repository.delete(user));
		//Borrado mediante User
		//DELETE CON JdbcTemplate
		userJdbcTemplateRepository.delete(new User("Eva","EVA"));

		//COMPROBAMOS los delete
		for(User u : repository.selectAllUser()){
			LOGGER.info("User: "+u.getUserName()+" passw: "+u.getPassword());
		}
		//Adding items to contacts repository
		contactRepository.save(new Contact("695540956",695540956L));

		LOGGER.info("\n\n\nObteniendo los inners:");

		//Inners
		List<Contact> accountList = contactRepository.getContactsByID();
		for(Contact contact : accountList){
			LOGGER.info(contact.toString());
		}











	}
}

