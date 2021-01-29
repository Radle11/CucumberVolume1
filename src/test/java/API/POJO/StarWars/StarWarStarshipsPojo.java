package API.POJO.StarWars;

import java.util.List;

public class StarWarStarshipsPojo {
    private int count;
    private String next;
    private Object previous;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<StarWarsStarshipsResultsPojo> getResults() {
        return results;
    }

    public void setResults(List<StarWarsStarshipsResultsPojo> results) {
        this.results = results;
    }

    private List<StarWarsStarshipsResultsPojo> results;
}
