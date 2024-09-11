package fitpower.model.communication;

import fitpower.model.base.Date;
import fitpower.model.assessment.ProgressEvaluation;
import fitpower.model.nutrition.NutritionPlan;
import fitpower.model.routine.Routine;

import java.util.HashMap;
import java.util.Map;

public class History extends Date {

    public Map<String, History> historyMap = new HashMap<String, History>();

    private String historyId;
    private Map<String, Routine> routines;
    private Map<String, NutritionPlan> nutritionPlans;
    private Map<String, ProgressEvaluation> progressEvaluations;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public Map<String, Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(Map<String, Routine> routines) {
        this.routines = routines;
    }

    public Map<String, NutritionPlan> getNutritionPlans() {
        return nutritionPlans;
    }

    public void setNutritionPlans(Map<String, NutritionPlan> nutritionPlans) {
        this.nutritionPlans = nutritionPlans;
    }

    public Map<String, ProgressEvaluation> getProgressEvaluations() {
        return progressEvaluations;
    }

    public void setProgressEvaluations(Map<String, ProgressEvaluation> progressEvaluations) {
        this.progressEvaluations = progressEvaluations;
    }
}
