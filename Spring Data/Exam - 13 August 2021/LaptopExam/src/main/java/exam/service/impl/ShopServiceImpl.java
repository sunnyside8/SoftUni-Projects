package exam.service.impl;

import exam.model.dto.xmlDto.ShopSeedDto;
import exam.model.dto.xmlDto.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOP_FILE = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count()> 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_FILE));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        ShopSeedRootDto shopSeedRootDto = xmlParser.fromFile(SHOP_FILE,
                ShopSeedRootDto.class);
        List<String> shopNames = new ArrayList<>();
        shopSeedRootDto.getShops().stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto);
                    String shopName = shopSeedDto.getName();
                    if(shopNames.contains(shopName)){
                        isValid = false;
                    } else {
                        shopNames.add(shopName);
                    }

                    sb.append(isValid ? String.format("Successfully imported Shop %s - %.0f ",
                                   shopSeedDto.getName(),shopSeedDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = modelMapper.map(shopSeedDto, Shop.class);
                    shop.setTown(townService.findTownByName(shopSeedDto.getTown().getName()));
                    return shop;
                })
                .forEach(shopRepository::save);

        return sb.toString();
    }

    @Override
    public Shop findShopByName(String name) {
        return this.shopRepository.findShopByName(name).orElse(null);
    }

}
