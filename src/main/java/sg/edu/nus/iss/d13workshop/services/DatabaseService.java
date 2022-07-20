package sg.edu.nus.iss.d13workshop.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private File dataDir = new File("some directory");

    public File getDataDir() {
        return dataDir;
    }

    public void setDataDir(File dataDir) {
        this.dataDir = dataDir; // this = class, while the other is local
    }

    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

}
