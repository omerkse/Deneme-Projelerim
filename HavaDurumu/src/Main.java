import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new WeatherAppGui().setVisible(true);

                //System.out.println(HavaDurumuApp.getLocationData("Gaziantep"));

            }
        });

    }
}