package repository;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {

    private Map<String, List<LocalDate>> doctorSchedule = new HashMap<>();

    // This setter takes Map<String, List<String>> and converts to LocalDate
    public void setRawSchedule(Map<String, List<String>> rawSchedule) {
        for (Map.Entry<String, List<String>> entry : rawSchedule.entrySet()) {
            List<LocalDate> dateList = new ArrayList<>();
            for (String dateStr : entry.getValue()) {
                dateList.add(LocalDate.parse(dateStr));
            }
            doctorSchedule.put(entry.getKey(), dateList);
        }
    }

    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        List<LocalDate> availableDates = doctorSchedule.get(doctorId);
        return availableDates != null && availableDates.contains(date);
    }
}