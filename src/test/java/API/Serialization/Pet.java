package API.Serialization;

public class Pet {
    private String name;
    private int age;
    private String status;
    private int id;
    private String photoURL;
    public Pet(String name,String status,int age ){
        this.name=name;
        this.status=status;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

}
