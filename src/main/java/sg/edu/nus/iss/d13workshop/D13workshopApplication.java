package sg.edu.nus.iss.d13workshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.d13workshop.services.DatabaseService;

@SpringBootApplication
public class D13workshopApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(D13workshopApplication.class, args);
	}

	@Autowired // auto instantiate, dont need Class xxx = new Class
	DatabaseService dbSvc;

	@Override // from implements (one of its functions)
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));

			if (!dbSvc.isDataDirValid()) {
				System.out.printf("%s does not exist, is not a directory or writeable", dataDir);
				System.exit(-1); //exit onces theres an error
			}

			System.out.printf("Using %s as data directory\n", dataDir);
		} else {
			dbSvc.setDataDir(new File("C:\\data"));

		}
	}

}
