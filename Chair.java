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

    public void occupy(){
        System.out.println("This chair is currently occupied by " + this.owner);
    }

    public void release(){
        this.owner = null;
    }

    public boolean isOccupied(){
        return (this.owner != null);
    }

    public static void main(String[] args) {
        Chair[] chairs = new Chair[5];
        chairs[0] = new Chair();
        chairs[1] = new Chair(1,200, "wood", "Petya");
        chairs[2] = new Chair(2,250, "metal", "Vasya");

        Chair chair1 = Chair.getInstance();
        chair1.setId(3);
        chair1.setMaxWeight(100);
        chair1.setMaterial("plastic");
        chair1.setOwner(null);

        Chair chair2 = Chair.getInstance();
        chair2.setId(4);
        chair2.setMaxWeight(250);
        chair2.setMaterial("leather");
        chair2.setOwner(null);

        chairs[3] = chair1;
        chairs[4] = chair2;

        for (Chair chair : chairs){
            System.out.println(chair.toString());
        };

        System.out.println(chairs[1].getOwner());
        System.out.println(chairs[2].isOccupied());

    }

}
