package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentWrapperDto {

    @XmlElement(name = "apartment")
    private List<ApartmentDto> apartmentsDto;

    public List<ApartmentDto> getApartmentsDto() {
        return apartmentsDto;
    }

    public void setApartmentsDto(List<ApartmentDto> apartmentsDto) {
        this.apartmentsDto = apartmentsDto;
    }
}
