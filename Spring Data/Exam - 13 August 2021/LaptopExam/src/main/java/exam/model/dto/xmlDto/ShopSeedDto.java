package exam.model.dto.xmlDto;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedDto {

    @XmlElement
    @Size(min = 4)
    private String address;


    @XmlElement(name = "employee-count")
    @Min(1)
    @Max(50)
    private Integer employeeCount;

    @XmlElement
    @Min(20000)
    private BigDecimal income;

    @XmlElement
    @Size(min = 4)
    private String name;


    @XmlElement(name = "shop-area")
    @Min(150)
    private Integer shopArea;

    @XmlElement
    private TownNameDto town;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public void setTown(TownNameDto town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public TownNameDto getTown() {
        return town;
    }
}
