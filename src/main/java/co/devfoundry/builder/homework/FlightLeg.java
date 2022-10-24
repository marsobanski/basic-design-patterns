package co.devfoundry.builder.homework;

import lombok.ToString;

@ToString
public class FlightLeg {

    private String from;
    private String to;
    private boolean delayed;
    private int price;

    private FlightLeg(FlightLegBuilder flightLegBuilder) {
        this.from = flightLegBuilder.from;
        this.to = flightLegBuilder.to;
        this.price = flightLegBuilder.price;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }

    public static class FlightLegBuilder {

        private String from;
        private String to;
        private int price;

        public FlightLeg build() {
            if (this.price == 0) {
                throw new IllegalStateException("Cena nie może być zerowa");
            }
            return new FlightLeg(this);
        }

        public FlightLegBuilder from(String from) {
            this.from = from;
            return this;
        }

        public FlightLegBuilder to(String to) {
            this.to = to;
            return this;
        }

        public FlightLegBuilder price(int price) {
            this.price = price;
            return this;
        }

    }

}
