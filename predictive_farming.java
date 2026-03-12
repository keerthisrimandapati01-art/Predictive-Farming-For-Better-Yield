import java.util.*;

class Crop {
    String name;
    int minTemp;
    int maxTemp;
    int minRainfall;
    int maxRainfall;
    double minPH;
    double maxPH;

    Crop(String name, int minTemp, int maxTemp, int minRainfall, int maxRainfall, double minPH, double maxPH) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minRainfall = minRainfall;
        this.maxRainfall = maxRainfall;
        this.minPH = minPH;
        this.maxPH = maxPH;
    }
}

public class PredictiveFarming {

    public static void predictCrop(Crop[] crops, int temp, int rainfall, double ph) {

        System.out.println("\nSuitable Crops for Given Conditions:");

        boolean found = false;

        for (int i = 0; i < crops.length; i++) {

            if (temp >= crops[i].minTemp && temp <= crops[i].maxTemp &&
                rainfall >= crops[i].minRainfall && rainfall <= crops[i].maxRainfall &&
                ph >= crops[i].minPH && ph <= crops[i].maxPH) {

                System.out.println(crops[i].name);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No suitable crop found.");
        }
    }

    public static void sortCropsByRainfall(Crop[] crops) {

        for (int i = 0; i < crops.length - 1; i++) {
            for (int j = 0; j < crops.length - i - 1; j++) {

                if (crops[j].minRainfall > crops[j + 1].minRainfall) {

                    Crop temp = crops[j];
                    crops[j] = crops[j + 1];
                    crops[j + 1] = temp;
                }
            }
        }

        System.out.println("\nCrops sorted by rainfall requirement:");
        for (Crop c : crops) {
            System.out.println(c.name + " - Rainfall: " + c.minRainfall);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Crop[] crops = {
                new Crop("Rice", 20, 35, 100, 200, 5.0, 6.5),
                new Crop("Wheat", 15, 25, 50, 100, 6.0, 7.5),
                new Crop("Maize", 18, 30, 60, 120, 5.5, 7.0),
                new Crop("Cotton", 25, 40, 50, 150, 5.8, 8.0)
        };

        System.out.println("Enter Temperature:");
        int temp = sc.nextInt();

        System.out.println("Enter Rainfall:");
        int rainfall = sc.nextInt();

        System.out.println("Enter Soil pH:");
        double ph = sc.nextDouble();

        predictCrop(crops, temp, rainfall, ph);

        sortCropsByRainfall(crops);
    }
}