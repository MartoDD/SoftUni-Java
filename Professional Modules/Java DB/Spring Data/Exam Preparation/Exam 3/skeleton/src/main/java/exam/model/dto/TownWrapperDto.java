package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownWrapperDto {

    @XmlElement(name = "town")
    private List<TownDto> towns;

    public List<TownDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownDto> towns) {
        this.towns = towns;
    }
}
