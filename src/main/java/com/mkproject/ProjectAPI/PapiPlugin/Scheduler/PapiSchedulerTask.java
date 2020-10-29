package com.mkproject.ProjectAPI.PapiPlugin.Scheduler;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

enum TaskType {
    DayOfMonth, DayOfWeek
}

final class PapiSchedulerTask {
    private final TaskType type;
    private final Runnable task;
    private final int year;
    private final int month;
    private final int dayOfMonth;
    private final DayOfWeek dayOfWeek;
    private final int hourOfDay;
    private final int minute;
    private final int second;
    private int repeatAmount;
    private LocalDateTime localDateTimeNextRun;

    protected PapiSchedulerTask(Runnable task, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second, int repeatAmount) {
        this.type = TaskType.DayOfMonth;
        this.task = task;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = null;
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
        this.repeatAmount = repeatAmount;
        if (this.repeatAmount != 0)
            this.generateTimeNextRun();
    }

    protected PapiSchedulerTask(Runnable task, int year, int month, DayOfWeek dayOfWeek, int hourOfDay, int minute, int second, int repeatAmount) {
        this.type = TaskType.DayOfWeek;
        this.task = task;
        this.year = year;
        this.month = month;
        this.dayOfMonth = -1;
        this.dayOfWeek = dayOfWeek;
        this.hourOfDay = hourOfDay;
        this.minute = minute;
        this.second = second;
        this.repeatAmount = repeatAmount;
        if (this.repeatAmount != 0)
            this.generateTimeNextRun();
    }

    private void generateTimeNextRun() {
        LocalDateTime dtNow = LocalDateTime.now();
        LocalDateTime dtNext = dtNow;

        boolean isAddedNext = false;

        if (this.second < 0) {
            dtNext = dtNext.plusSeconds(1);
            isAddedNext = true;
        } else dtNext = dtNext.withSecond(this.second);

        if (this.minute < 0) {
            if (!isAddedNext) {
                dtNext = dtNext.plusMinutes(1);
                isAddedNext = true;
            }
        } else dtNext = dtNext.withMinute(this.minute);

        if (this.hourOfDay < 0) {
            if (!isAddedNext) {
                dtNext = dtNext.plusHours(1);
                isAddedNext = true;
            }
        } else dtNext = dtNext.withHour(this.hourOfDay);

        if (this.type == TaskType.DayOfMonth) {
            if (this.dayOfMonth < 0) {
                if (!isAddedNext) {
                    dtNext = dtNext.plusDays(1);
                    isAddedNext = true;
                }
            } else dtNext = dtNext.withDayOfMonth(this.dayOfMonth);
        } else {
            if (this.dayOfWeek == null) {
                if (!isAddedNext) {
                    dtNext = dtNext.plusDays(1);
                    isAddedNext = true;
                }
            } else {
                dtNext = dtNext.plusDays(7 - dtNext.getDayOfWeek().getValue() + this.dayOfWeek.getValue());
            }
        }

        if (this.month < 0) {
            if (!isAddedNext) {
                dtNext = dtNext.plusMonths(1);
                isAddedNext = true;
            }
        } else dtNext = dtNext.withMonth(this.month);

        if (this.year < 0) {
            if (!isAddedNext) {
                dtNext = dtNext.plusYears(1);
            }
        } else dtNext = dtNext.withYear(this.year);

        if (!dtNext.isAfter(dtNow))
            this.repeatAmount = 0;
        else
            this.localDateTimeNextRun = dtNext;
    }

    public void runTask() {
        if (this.repeatAmount == 0)
            return;

        this.generateTimeNextRun();
        this.repeatAmount--;
        this.task.run();
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dayOfWeek;
    }

    public int getHourOfDay() {
        return this.hourOfDay;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public int getRepeatAmount() {
        return this.repeatAmount;
    }

    public LocalDateTime getDateTimeNextRun() {
        return this.localDateTimeNextRun;
    }
}
