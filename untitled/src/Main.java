import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double weight = 0.0;
        double height = 0.0;
        int age = 0;

        double imt = calculateIMT(weight, height);
        double idealWeight = calculateIdealWeight(height);
        double calories = calculateDailyCalories(weight, height, age);

        if (imt > 24.9) {
            double weightToLose = weight - idealWeight;
            System.out.println("Рекомендуется снизить вес для достижения идеального веса.");
            System.out.println("Идеальный вес: " + idealWeight + " кг.");
            System.out.println("Необходимо сбросить: " + weightToLose + " кг.");
            System.out.println("Рекомендуемый дневной прием калорий: " + calories + " калорий.");
        } else if (imt < 18.5) {
            double weightToGain = idealWeight - weight;
            System.out.println("Рекомендуется увеличить потребление пищи для набора веса.");
            System.out.println("Идеальный вес: " + idealWeight + " кг.");
            System.out.println("Необходимо набрать: " + weightToGain + " кг.");
            System.out.println("Рекомендуемый дневной прием калорий: " + calories + " калорий.");
        } else {
            System.out.println("Ваш вес находится в пределах нормы.");
            System.out.println("Идеальный вес: " + idealWeight + " кг.");
            System.out.println("Рекомендуемый дневной прием калорий: " + calories + " калорий.");
        }
    }

    private static double calculateIMT(double weight, double height) {
        return weight / (height * height);
    }

    private static double calculateIdealWeight(double height) {
        return 24.9 * (height * height);
    }

    private static double calculateDailyCalories(double weight, double height, int age) {
        return 655 + (9.6 * weight) + (1.8 * height * 100) - (4.7 * age);
    }
}