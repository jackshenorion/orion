package com.shenpinyi.other.codility.question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 30/05/2017.
 */
public class Solution {

    public int solution(String S) {
        String[] cdrs = split(S);
        int count = cdrs.length;
        if (count == 0) {
            return 0;
        }

        List<CDR> durations = new ArrayList<>();
        HashMap<String, Integer> totalDurations = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String cdr = cdrs[i];
            int duration = getDuration(cdr);
            String phoneNumber = getPhoneNumber(cdr);
            durations.add(new CDR(phoneNumber, duration));
            addDurationToTotal(totalDurations, phoneNumber, duration);
        }

        String freePhoneNumber = getFreePhoneNumber(totalDurations);
        return calcTotalFee(durations, freePhoneNumber);
    }

    public int calcTotalFee(List<CDR> durations, String freePhoneNumber) {
        int totalFee = 0;
        for (CDR cdr : durations) {
            if (cdr.getPhoneNumber().equals(freePhoneNumber)) {
                continue;
            }
            totalFee += calcFeePerCdr(cdr.getDuration());
        }
        return totalFee;
    }

    public int calcFeePerCdr(int duration) {
        if (duration < 300) {
            return calcInSeconds(duration);
        } else {
            return calcInMinutes(duration);
        }
    }

    public int calcInSeconds(int duration) {
        return duration * 3;
    }

    public int calcInMinutes(int duration) {
        int minutes = duration / 60;
        minutes = (duration % 60 == 0) ? minutes : minutes + 1;
        return minutes * 150;
    }

    public String getFreePhoneNumber(HashMap<String, Integer> totalDurations) {
        int maxDuration = 0;
        String phoneNumber = "999-999-999";
        for (Map.Entry<String, Integer> entry : totalDurations.entrySet()) {
            if (entry.getValue() > maxDuration) {
                phoneNumber = entry.getKey();
                maxDuration = entry.getValue();
            } else if (entry.getValue() == maxDuration) {
                phoneNumber = getSmallerPhoneNumber(phoneNumber, entry.getKey());
            }
        }
        return phoneNumber;
    }

    public String getSmallerPhoneNumber(String a, String b) {
        if (a.compareTo(b) < 0) {
            return a;
        } else {
            return b;
        }
    }

    public void addDurationToTotal(HashMap<String, Integer> totalDurations, String phoneNumber, int duration) {
        Integer total = totalDurations.get(phoneNumber);
        if (total == null) {
            totalDurations.put(phoneNumber, duration);
        } else {
            totalDurations.put(phoneNumber, total + duration);
        }
    }

    public int getDuration(String cdr) {
        String duration = cdr.substring(0, 8);
        int hour = Integer.valueOf(duration.substring(0, 2));
        int minute = Integer.valueOf(duration.substring(3, 5));
        int second = Integer.valueOf(duration.substring(6, 8));
        return hour * 3600 + minute * 60 + second;
    }

    public String getPhoneNumber(String cdr) {
        return cdr.substring(9);
    }

    public String[] split(String s) {
        return s.split("\\r?\\n");
    }

    class CDR {
        private String phoneNumber;
        private int duration;

        public CDR(String phoneNumber, int duration) {
            this.phoneNumber = phoneNumber;
            this.duration = duration;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public CDR setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public int getDuration() {
            return duration;
        }

        public CDR setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        @Override
        public String toString() {
            return "CDR{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", duration=" + duration +
                '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(
            new Solution().
                solution("00:01:07,400-234-090\n" +
                    "00:05:01,701-080-080\n" +
                    "00:05:00,400-234-090")
        );

        System.out.println(
            new Solution().getSmallerPhoneNumber("999-999-999", "000-000-000")
        );
    }

}
