package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CarService carService, SellerService service, SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(OFFERS_PATH,
                OfferSeedRootDto.class);

        offerSeedRootDto.getOffers().stream()
                .filter(offerSeedDto -> {
                    boolean isValid = validationUtil.isValid(offerSeedDto);
                    sb.append(isValid ? String.format("Successfully import offer %s - %s", offerSeedDto.getAddedOn(), offerSeedDto.isHasGoldStatus())
                     : "Invalid offer")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(offerSeedDto -> {
                    Offer offer = modelMapper.map(offerSeedDto,Offer.class);
                    offer.setSeller(sellerService.findById(offerSeedDto.getSeller().getId()));
                    offer.setCar(carService.findById(offerSeedDto.getCar().getId()));
                    return offer;
                })
                .forEach(offerRepository::save);
        return sb.toString();
    }
}
