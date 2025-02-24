package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopWrapperDto {

    @XmlElement(name = "shop")
    private List<ShopDto> shops;

    public List<ShopDto> getShops() {
        return shops;
    }

    public void setShops(List<ShopDto> shops) {
        this.shops = shops;
    }
}
