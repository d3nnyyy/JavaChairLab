package ua.lviv.iot.algo.part1.lab1;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Chair {

    private int id = 1;
    private int maxWeight;
    private String material;
    private String owner;

    private static Chair instance;


    public static Chair getInstance(){
        if(instance == null){
            instance = new Chair();
        }
        return instance;
    }


    public void occupy(String owner){
        System.out.println(owner + " occupied this chair");
    }

    public void release(){
        this.owner = null;
    }

    public boolean isOccupied(){
        return (this.owner != null);
    }


    public static void main(String[] args) {
        int length = 5;
        Chair[] chairs = new Chair[length];
        chairs[0] = new Chair();
        chairs[1] = new Chair(1,200, "wood", "Petya");
        chairs[2] = new Chair(2,250, "metal", "Vasya");
        Chair chair1 = Chair.getInstance();
        Chair chair2 = Chair.getInstance();
        chairs[3] = chair1;
        chairs[4] = chair2;

        for (Chair chair : chairs){
            System.out.println(chair);
        };

        chair1.occupy("Denys");

        System.out.println(chairs[1].getOwner());
        System.out.println(chairs[2].isOccupied());

    }

}
