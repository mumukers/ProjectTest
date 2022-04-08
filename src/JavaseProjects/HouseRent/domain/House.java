package JavaseProjects.HouseRent.domain;

/*
House类的对象表示一个房屋信息
 */
public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getRent() {
        return rent;
    }

    public String getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return
                        id +
                "\t\t" + name +
                "\t" + phone  +
                "\t" + address  +
                "\t" + rent +
                "\t" + state
                ;
    }
}
