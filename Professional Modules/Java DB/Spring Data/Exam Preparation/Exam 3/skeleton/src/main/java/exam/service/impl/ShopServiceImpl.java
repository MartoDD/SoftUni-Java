package exam.service.impl;

import exam.model.dto.ShopWrapperDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationTool;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static exam.util.Messages.INVALID_SHOP;
import static exam.util.Messages.SHOP_IMPORTED;
import static exam.util.Paths.PATH_OF_SHOPS;

@Service
public class ShopServiceImpl implements ShopService {


    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ValidationTool validationTool;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;


    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ValidationTool validationTool, ModelMapper modelMapper, XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;

        this.validationTool = validationTool;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_SHOPS));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PATH_OF_SHOPS, ShopWrapperDto.class).getShops().stream()
                .filter(shopDto -> {

                    boolean isValid = validationTool.isValid(shopDto);
                    boolean isShopPresent = shopRepository.findShopByName(shopDto.getShopName()).isPresent();

                    if (isShopPresent) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(SHOP_IMPORTED, shopDto.getShopName(), shopDto.getIncome()) : INVALID_SHOP).append(System.lineSeparator());

                    return isValid;
                }).map(shopDto -> {
                    Shop shop = modelMapper.map(shopDto, Shop.class);
                    Town town = townRepository.findTownByName(shopDto.getTown().getTownName()).orElse(null);
                    shop.setTown(town);
                    return shop;
                }).forEach(shopRepository::save);

        return sb.toString();
    }
}
