package buzz.blobanium.urmothercraft;

import net.fabricmc.api.ModInitializer;

import java.util.Random;

public class UrMotherCraft implements ModInitializer {

    private static Random rndm = new Random();
    @Override
    public void onInitialize() {
        System.out.println("welcome");
    }

    public static String getUrMotherText(){
        return getFirstWord() + " " + getLastWord();
    }

    private static String getFirstWord(){
        int number = Math.abs(rndm.nextInt() % 4);
        return switch (number){
            case 0 -> "ur";
            case 1 -> "your";
            case 2 -> "Ur";
            case 3 -> "Your";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

    private static String getLastWord(){
        int number = Math.abs(rndm.nextInt() % 4);
        return switch (number){
            case 0 -> "mother";
            case 1 -> "mom";
            case 2 -> "Mother";
            case 3 -> "Mom";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }
}
