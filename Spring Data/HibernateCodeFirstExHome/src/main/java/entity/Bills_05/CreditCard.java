package entity.Bills_05;

import javax.persistence.*;

@Entity
@Table(name = "creadit_card")
public class CreditCard extends BillingDetails {

    private CardType cardType;
    private Integer exMonth;
    private Integer exYear;

    public CreditCard() {
    }

    @Enumerated(EnumType.STRING)
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "exp_month")
    public Integer getExMonth() {
        return exMonth;
    }

    public void setExMonth(Integer exMonth) {
        this.exMonth = exMonth;
    }

    @Column(name = "exp_year")
    public Integer getExYear() {
        return exYear;
    }

    public void setExYear(Integer exYear) {
        this.exYear = exYear;
    }
}
