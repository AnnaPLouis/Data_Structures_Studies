import java.util.ArrayList;

public class PeopleInTheBus {

    public static void main(String[] args) {

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        list.add(new int[] {2,5});

        System.out.println(countPassengers(list));




    }   public static int countPassengers(ArrayList<int[]> stops){
        int numberOfPassengers = 0;

        for (int i = 0; i < stops.size(); i++) {
            numberOfPassengers+=stops.get(i)[0];
            numberOfPassengers-=stops.get(i)[1];
        }

        return numberOfPassengers;
    }
}
