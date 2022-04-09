package JavaseProjects.HouseRent.Server;

import JavaseProjects.HouseRent.domain.House;

import java.net.BindException;

public class Server {
    private static int houseNum=0;
    private static int Id=1;
    private House[] houses;
    public Server(int size){
        houses=new House[size];
    }

    public House getHouse(int index){
        return houses[index];
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

    public int find(int id) {
        for (int i = 0; i < houseNum; i++) {
            if (id==houses[i].getId()){
                return i;
            }
        }
        return -1;
    }

    public boolean del(int id) {
        int index=find(id);
        if(index!=-1){
            for (int i = index; i < houseNum - 1; i++) {
                houses[i]=houses[i+1];
            }
            houses[houseNum--]=null;
            return true;
        }
        return false;
    }

    public boolean update(int id) {
        int index=find(id);
        if(index!=-1){
            for (int i = index; i < houseNum - 1; i++) {
                houses[i]=houses[i+1];
            }
            houses[houseNum--]=null;
            return true;
        }
        return false;
    }
}
