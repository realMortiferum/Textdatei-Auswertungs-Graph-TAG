package JUnit;
//import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
public class Currency {
//    @JsonProperty("CurrencyID")
    private Integer currencyID = null;
//    @JsonProperty("CurrencyCharacter")
    private String currencyCharacter = null;
//    @JsonProperty("CurrencyISOCode")
    private String currencyISOCode = null;
//    @JsonProperty("CurrencyName")
    private String currencyName = null;
//    @JsonProperty("ExchangeRate")
    private Double exchangeRate = null;
    private Currency(final Integer currencyID, final String currencyCharacter,
                     final String currencyISOCode, final String currencyName,
                     final Double exchangeRate) {
        this.currencyID = currencyID;
        this.currencyCharacter = currencyCharacter;
        this.currencyISOCode = currencyISOCode;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
    }
    public static Currency of(final Integer currencyID, final String currencyCharacter,
                              final String currencyISOCode, final String currencyName,
                              final Double exchangeRate) {
        return new Currency(currencyID, currencyCharacter, currencyISOCode, currencyName, exchangeRate);
    }
    public Currency currencyID(Integer currencyID) {
        this.currencyID = currencyID;
        return this;
    }
    /**
     * Get currencyID
     *
     * @return currencyID
     **/
    public Integer getCurrencyID() {
        return currencyID;
    }
    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }
    public Currency currencyCharacter(String currencyCharacter) {
        this.currencyCharacter = currencyCharacter;
        return this;
    }
    /**
     * Get currencyCharacter
     *
     * @return currencyCharacter
     **/
    public String getCurrencyCharacter() {
        return currencyCharacter;
    }
    public void setCurrencyCharacter(String currencyCharacter) {
        this.currencyCharacter = currencyCharacter;
    }
    public Currency currencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
        return this;
    }
    /**
     * Get currencyISOCode
     *
     * @return currencyISOCode
     **/
    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }
    public Currency currencyName(String currencyName) {
        this.currencyName = currencyName;
        return this;
    }
    /**
     * Get currencyName
     *
     * @return currencyName
     **/
    public String getCurrencyName() {
        return currencyName;
    }
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    public Currency exchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }
    /**
     * Get exchangeRate
     *
     * @return exchangeRate
     **/
    public Double getExchangeRate() {
        return exchangeRate;
    }
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return Objects.equals(this.currencyID, currency.currencyID) &&
                Objects.equals(this.currencyCharacter, currency.currencyCharacter) &&
                Objects.equals(this.currencyISOCode, currency.currencyISOCode) &&
                Objects.equals(this.currencyName, currency.currencyName) &&
                Objects.equals(this.exchangeRate, currency.exchangeRate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currencyID, currencyCharacter, currencyISOCode, currencyName, exchangeRate);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Currency {\n");
        sb.append("    currencyID: ").append(toIndentedString(currencyID)).append("\n");
        sb.append("    currencyCharacter: ").append(toIndentedString(currencyCharacter)).append("\n");
        sb.append("    currencyISOCode: ").append(toIndentedString(currencyISOCode)).append("\n");
        sb.append("    currencyName: ").append(toIndentedString(currencyName)).append("\n");
        sb.append("    exchangeRate: ").append(toIndentedString(exchangeRate)).append("\n");
        sb.append("}");
        return sb.toString();
    }
    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}