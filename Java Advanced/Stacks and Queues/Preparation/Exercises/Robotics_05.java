package Preparation;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRobots = scanner.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotMap(robotsData);
        LinkedHashMap <String,Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData);

        String startTime = scanner.nextLine();
        int startTimeInSec = getStartTimeInSec(startTime);
        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while(!products.isEmpty()){
            String currentProduct = products.poll();
            startTimeInSec++;
            decreaseWorkingTome(robotsWorkingTime);
            boolean isTaken = false;
            for (Map.Entry<String,Integer> robot:robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0){
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSec) + "]");
                    robotsWorkingTime.put(robot.getKey(),robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken ){
                products.offer(currentProduct);
            }
        }

    }

    private static void decreaseWorkingTome(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot:robotsWorkingTime.entrySet()) {
            if(robot.getValue() > 0){
                robotsWorkingTime.put(robot.getKey(),robot.getValue() -1);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            robots.put(robotName,0);
        }
        return robots;
    }

    private static int getStartTimeInSec(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int min = Integer.parseInt(startTime.split(":")[1]);
        int sec = Integer.parseInt(startTime.split(":")[2]);
        int startTimeInSec = hours * 3600 + min * 60 + sec;
        return startTimeInSec;
    }
    private static String getStartTime(int startTimeInSec){
        int hours = (startTimeInSec / 3600) % 24;
        int min = (startTimeInSec % 3600) / 60;
        int seconds = startTimeInSec % 60;

        return String.format("%02d:%02d:%02d",hours, min ,seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int timeNeeded = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, timeNeeded);
        }
        return robots;
    }
}
