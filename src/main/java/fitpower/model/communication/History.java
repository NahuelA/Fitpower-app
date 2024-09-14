package fitpower.model.communication;

import fitpower.model.base.Date;
import fitpower.model.assessment.ProgressEvaluation;
import fitpower.model.nutrition.NutritionPlan;
import fitpower.model.routine.Routine;

import java.util.HashMap;

public class History extends Date {

    public final HashMap<String, History> historyMap = new HashMap<>();

    private String historyId;
    private HashMap<String, Routine> routines;
    private HashMap<String, NutritionPlan> nutritionPlans;
    private HashMap<String, ProgressEvaluation> progressEvaluations;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public HashMap<String, Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(HashMap<String, Routine> routines) {
        this.routines = routines;
    }

    public HashMap<String, NutritionPlan> getNutritionPlans() {
        return nutritionPlans;
    }

    public void setNutritionPlans(HashMap<String, NutritionPlan> nutritionPlans) {
        this.nutritionPlans = nutritionPlans;
    }

    public HashMap<String, ProgressEvaluation> getProgressEvaluations() {
        return progressEvaluations;
    }

    public void setProgressEvaluations(HashMap<String, ProgressEvaluation> progressEvaluations) {
        this.progressEvaluations = progressEvaluations;
    }
}
