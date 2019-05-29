import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, List<Double>>> dragonTypes = new TreeMap<>();
        Map<String, List<Double>> typeAvg = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] dragonsData = scanner.nextLine().split(" ");
            String type = dragonsData[0];
            String dragon = dragonsData[1];
            double dragonDMG = 0;
            double dragonHealth = 0;
            double dragonArmor = 0;
            if (dragonsData[2].equals("null"))
                dragonDMG = 45;
            else
                dragonDMG = Double.parseDouble(dragonsData[2]);
            if (dragonsData[3].equals("null"))
                dragonHealth = 250;
            else
                dragonHealth = Double.parseDouble(dragonsData[3]);
            if (dragonsData[4].equals("null"))
                dragonArmor = 10;
            else
                dragonArmor = Double.parseDouble(dragonsData[4]);
            if (!dragonTypes.containsKey(type)) {
                dragonTypes.put(type, new TreeMap<>());
                dragonTypes.get(type).put(dragon, new ArrayList<>());
                dragonTypes.get(type).get(dragon).add(dragonDMG);
                dragonTypes.get(type).get(dragon).add(dragonHealth);
                dragonTypes.get(type).get(dragon).add(dragonArmor);
                typeAvg.put(type, new ArrayList<>());
                typeAvg.get(type).add(dragonDMG);
                typeAvg.get(type).add(dragonHealth);
                typeAvg.get(type).add(dragonArmor);
            } else {
                if (!dragonTypes.get(type).containsKey(dragon)) {
                    dragonTypes.get(type).put(dragon, new ArrayList<>());
                    dragonTypes.get(type).get(dragon).add(dragonDMG);
                    dragonTypes.get(type).get(dragon).add(dragonHealth);
                    dragonTypes.get(type).get(dragon).add(dragonArmor);
                    typeAvg.get(type).set(0,typeAvg.get(type).get(0)+dragonDMG);
                    typeAvg.get(type).set(1,typeAvg.get(type).get(1)+dragonHealth);
                    typeAvg.get(type).set(2,typeAvg.get(type).get(2)+dragonArmor);
                }
                else {
                    typeAvg.get(type).set(0, typeAvg.get(type).get(0) - dragonTypes.get(type).get(dragon).get(0));
                    typeAvg.get(type).set(1, typeAvg.get(type).get(1) - dragonTypes.get(type).get(dragon).get(1));
                    typeAvg.get(type).set(2, typeAvg.get(type).get(2) - dragonTypes.get(type).get(dragon).get(2));
                    dragonTypes.get(type).get(dragon).set(0,dragonDMG);
                    dragonTypes.get(type).get(dragon).set(1,dragonHealth);
                    dragonTypes.get(type).get(dragon).set(2,dragonArmor);
                    typeAvg.get(type).set(0,typeAvg.get(type).get(0)+dragonDMG);
                    typeAvg.get(type).set(1,typeAvg.get(type).get(1)+dragonHealth);
                    typeAvg.get(type).set(2,typeAvg.get(type).get(2)+dragonArmor);
                }

            }

        }

        typeAvg.forEach((type, data) ->{
            double dmg = data.get(0)/dragonTypes.get(type).size();
            double health = data.get(1)/dragonTypes.get(type).size();
            double armor = data.get(2)/dragonTypes.get(type).size();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",type,dmg,health,armor));
            dragonTypes.get(type).forEach((dragon, dragonData) ->{
                System.out.println(String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f",
                        dragon,dragonData.get(0),dragonData.get(1),dragonData.get(2)));
            });
        });
    }
}
