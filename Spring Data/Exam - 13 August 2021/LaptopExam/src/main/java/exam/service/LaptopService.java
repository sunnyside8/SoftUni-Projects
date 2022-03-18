package exam.service;

import exam.model.entity.Laptop;

import java.io.IOException;
import java.util.List;

//ToDo - Implement all methods
public interface LaptopService {
    boolean areImported();

    String readLaptopsFileContent() throws IOException;

    String importLaptops() throws IOException;

    String exportBestLaptops();

}
