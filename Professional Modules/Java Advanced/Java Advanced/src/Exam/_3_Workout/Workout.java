package Exam._3_Workout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        List<Exercise> sorted= exercises.stream().sorted((e1,e2)->Integer.compare(e2.getBurnedCalories(), e1.getBurnedCalories())).collect(Collectors.toList());
        if (sorted.size()!=0){
            return sorted.get(0);
        }else {
            return null;
        }
    }
    public int getExerciseCount(){
        return exercises.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        exercises.forEach(e->sb.append("\n").append(e.toString()));
        return "Workout type: " + this.type + sb;
    }
}
