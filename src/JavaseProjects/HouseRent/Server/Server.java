package JavaseProjects.HouseRent.Server;

import JavaseProjects.HouseRent.domain.House;

public class Server {
    private static int houseNum=1;
    private static int Id=0;
    private House[] houses;
    public Server(int size){
        houses=new House[size];
        houses[0]=new House(1,"李四","123456789","123456",2000,"未出租");
    }

    public void list(){
        for (int i = 0; i < houseNum; i++) {
            System.out.println(houses[i]);
        }
    }

    public boolean add(House newhouse) {
        if(houseNum==houses.length){
            System.out.println("==========数组已满,添加失败==========");
            return false;
        }
        houses[houseNum++]=newhouse;
        newhouse.setId(Id++);
        return true;
    }

}
