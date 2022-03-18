package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDto;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOP_FILE ="src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_FILE));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();
        LaptopSeedDto[] laptopSeedDtos = gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);

        Arrays.stream(laptopSeedDtos)
                .filter(laptopSeedDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedDto);
                    sb.append(isValid ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                            laptopSeedDto.getMacAddress(),laptopSeedDto.getCpuSpeed(),laptopSeedDto.getRam(),laptopSeedDto.getStorage())
                            : "Invalid Laptop").append(System.lineSeparator());
                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedDto,Laptop.class);
                    laptop.setShop(shopService.findShopByName(laptopSeedDto.getShop().getName()));
                    return laptop;
                })
                .forEach(laptopRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder build = new StringBuilder();
        this.laptopRepository.orderAllLaptops().forEach(laptop->
                build.append(String.format("•\t\"Laptop - %s\n" +
                        "*Cpu speed - %.2f\n" +
                        "**Ram - %d\n" +
                        "***Storage -%d\n" +
                        "****Price - %.2f\n" +
                        "#Shop name - %s\n" +
                        "##Town - %s\n",laptop.getMacAddress(),
                        laptop.getCpuSpeed(),laptop.getRam(),laptop.getStorage(),laptop.getPrice(),
                        laptop.getShop().getName(),laptop.getShop().getTown().getName())));
        return build.toString();
    }

}
