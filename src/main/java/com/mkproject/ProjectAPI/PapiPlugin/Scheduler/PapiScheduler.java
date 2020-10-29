package com.mkproject.ProjectAPI.PapiPlugin.Scheduler;

import com.mkproject.ProjectAPI.PapiCore.PapiCore;
import org.bukkit.Bukkit;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Papi scheduler.
 */
public final class PapiScheduler {
    private static Collection<PapiSchedulerTask> papiTasks = new ArrayList<>();

    /**
     * Instantiates a new Papi scheduler.
     */
    public PapiScheduler() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(PapiCore.getPlugin(), PapiScheduler::doCheck, 20L, 20L);
    }

    /**
     * Register repeat task boolean.
     *
     * @param task         the task
     * @param year         the year
     * @param month        the month
     * @param dayOfWeek    the day of week
     * @param hourOfDay    the hour of day
     * @param minute       the minute
     * @param second       the second
     * @param repeatAmount the repeat amount
     * @return the boolean
     */
//int repeatAmount:
    //-1 = infinity
    //0 = never
    //1 = one time
    //2,3,4... = two time, etc.
    public static boolean registerRepeatTask(Runnable task, int year, int month, DayOfWeek dayOfWeek, int hourOfDay, int minute, int second, int repeatAmount) {
        if (!isRegisterParamsValid(year, month, hourOfDay, minute, second)) return false;

        papiTasks.add(new PapiSchedulerTask(task, year, month, dayOfWeek, hourOfDay, minute, second, repeatAmount));
        return true;
    }

    /**
     * Register repeat task boolean.
     *
     * @param task         the task
     * @param year         the year
     * @param month        the month
     * @param dayOfMonth   the day of month
     * @param hourOfDay    the hour of day
     * @param minute       the minute
     * @param second       the second
     * @param repeatAmount the repeat amount
     * @return the boolean
     */
//int repeatAmount:
    //-1 = infinity
    //0 = never
    //1 = one time
    //2,3,4... = two time, etc.
    public static boolean registerRepeatTask(Runnable task, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second, int repeatAmount) {
        if (!isRegisterParamsValid(year, month, hourOfDay, minute, second)) return false;
        if (dayOfMonth != -1 && (dayOfMonth < 1 || dayOfMonth > 31)) return false;

        if (year != -1 && month != -1 && dayOfMonth != -1 && hourOfDay != -1 && minute != -1 && second != -1) {
            if (LocalDateTime.of(year, month, dayOfMonth, hourOfDay, minute, second).isBefore(LocalDateTime.now()))
                return false;
        }

        papiTasks.add(new PapiSchedulerTask(task, year, month, dayOfMonth, hourOfDay, minute, second, repeatAmount));
        return true;
    }

    private static void doCheck() {
        Collection<PapiSchedulerTask> papiTasksToRemove = new ArrayList<>();
        for (PapiSchedulerTask papiTask : papiTasks) {
            if (papiTask.getRepeatAmount() <= 0) {
                papiTasksToRemove.add(papiTask);
                continue;
            }

            if (LocalDateTime.now().isBefore(papiTask.getDateTimeNextRun()))
                continue;

            papiTask.runTask();

            if (papiTask.getRepeatAmount() == 0)
                papiTasksToRemove.add(papiTask);
        }

        for (PapiSchedulerTask papiTaskToRemove : papiTasksToRemove) {
            papiTasks.remove(papiTaskToRemove);
        }
    }

    private static boolean isRegisterParamsValid(int year, int month, int hourOfDay, int minute, int second) {
        if (year != -1 && year < LocalDateTime.now().getYear())
            return false;
        if (month != -1 && (month < 1 || month > 12))
            return false;
        if (hourOfDay != -1 && (hourOfDay < 0 || hourOfDay > 23))
            return false;
        if (minute != -1 && (minute < 0 || minute > 60))
            return false;
        if (second != -1 && (second < 0 || second > 60))
            return false;
        return true;
    }
}
