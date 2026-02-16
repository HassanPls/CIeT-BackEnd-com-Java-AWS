package poo.herança_e_polimorfismo.Ex3;

public non-sealed class USAClock extends Clock {
    
    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidday() {
        this.periodIndicator = "PM";
    }
    public void setBeforeMidday() {
        this.periodIndicator = "AM";
    }

    public void setHour(int hour) {
        this.periodIndicator = "AM";
        if (hour > 12 && hour <= 23) {
            this.hour = hour - 12;
            setAfterMidday();
            return;
        } else if (hour > 23) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
        this.hour = hour;
    }

    @Override
    Clock convert(Clock clock) {
        
        this.second = clock.getSecond();
        this.minute = clock.getMinute();
        switch (clock) {
            case USAClock usaClock -> {
                this.hour = usaClock.getHour();
                this.periodIndicator = usaClock.getPeriodIndicator();
            }
            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }
        return this;
    }
}
