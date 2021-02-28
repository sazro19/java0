package SimpleClasses;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {

    private final int MAX = 59;

    private final int MAX_HOURS = 23;

    private final int MIN = 0;

    private int hours;

    private int minutes;

    private int seconds;

    public Time() {
        String date = new Date().toString();
        Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher matcher = pattern.matcher(date);
        while (matcher.find()) {
            hours = Integer.parseInt(matcher.group(1));
            minutes = Integer.parseInt(matcher.group(2));
            seconds = Integer.parseInt(matcher.group(3));
        }
    }

    public void changeTimeOn(int hours, int minutes, int seconds) {
        int newSec = seconds + minutes * 60 + hours * 3600;
        int[] format = format(newSec);
        plusSeconds(format[2]);
        plusMinutes(format[1]);
        plusHours(format[0]);
    }

    public void setHours(int hours) {
        if (hours > MAX_HOURS || hours < MIN) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes > MAX || minutes < MIN) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds > MAX || seconds < MIN) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }

    public void printTime() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

    private int[] format(int seconds) {
        int timeInHours = seconds / 3600;
        seconds %= 3600;
        int timeInMinutes = seconds / 60;
        seconds %= 60;
        return new int[]{timeInHours, timeInMinutes, seconds};
    }

    private void plusSeconds(int sec) {
        int seconds = sec;
        while (seconds > 0) {
            if (seconds + this.seconds > MAX) {
                int time = MAX + 1 - this.seconds;
                seconds -= time;
                this.seconds = MIN;
                if (this.minutes < MAX) {
                    this.minutes++;
                } else {
                    this.minutes = MIN;
                    if (this.hours < MAX_HOURS) {
                        this.hours++;
                    } else {
                        this.hours = MIN;
                    }
                }
            } else {
                this.seconds += seconds;
                break;
            }
        }
    }

    private void plusMinutes(int min) {
        int minutes = min;
        while (minutes > 0) {
            if (minutes + this.minutes > MAX) {
                int time = MAX + 1 - this.minutes;
                minutes -= time;
                this.minutes = MIN;
                if (this.hours < MAX_HOURS) {
                    this.hours++;
                } else {
                    this.hours = MIN;
                }
            } else {
                this.minutes += minutes;
                break;
            }
        }
    }

    private void plusHours(int h) {
        int hours = h;
        while (hours > 0) {
            if (hours + this.hours > MAX_HOURS) {
                int time = MAX_HOURS + 1 - this.hours;
                hours -= time;
                this.hours = MIN;
            } else {
                this.hours += hours;
                break;
            }
        }
    }
}
