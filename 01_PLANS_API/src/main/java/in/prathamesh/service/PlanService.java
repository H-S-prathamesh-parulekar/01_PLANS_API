package in.prathamesh.service;

import java.util.List;
import java.util.Map;


import in.prathamesh.entity.Plan;



public interface PlanService {
//interface
	
	public Map<Integer, String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public  List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId , String status);
	
	
	
}
