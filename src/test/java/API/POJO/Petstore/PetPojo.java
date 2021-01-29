package API.POJO.Petstore;

import java.util.List;

public class PetPojo {
    private int id;
    private String name;
    private List<String> photoUrls;
    private List<PetTags> tags;
    private String status;
    private PetCategory category;
    public PetPojo(String name, String status, int id){
        this.name=name;
        this.status=status;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<PetTags> getTags() {
        return tags;
    }

    public void setTags(List<PetTags> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }
}
