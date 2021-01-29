package API.POJO.Akchabar;

public class AkchaBar {
    private String date;
    private long updated_at;
    private AkchaBarRates rates;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public AkchaBarRates getRates() {
        return rates;
    }

    public void setRates(AkchaBarRates rates) {
        this.rates = rates;
    }
}

