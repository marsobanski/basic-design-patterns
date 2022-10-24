package co.devfoundry.builder.homework;

public class BuilderHomeworkMain {

    public static void main(String[] args) {

        FlightLeg flightLeg = new FlightLeg.FlightLegBuilder()
                .from("Wawa")
                .to("WPR")
                .price(50)
                .build();

        System.out.println(flightLeg);

        flightLeg.setDelayed(true);

        System.out.println(flightLeg);
    }
}
