package in.prathamesh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.prathamesh.entity.Plan;
import in.prathamesh.entity.PlanCategory;
import in.prathamesh.repo.PlanCategoryRepo;
import in.prathamesh.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
		
	@Override
	public Map<Integer, String> getPlanCategories() {
	
		List<PlanCategory> categories =  planCategoryRepo.findAll();
		
		Map<Integer, String>categoryMap = new HashMap<>();		
		categories.forEach(category->{
			categoryMap.put(((PlanCategory) category).getCategoryId(), category.getCategoryName());
			});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved =  planRepo.save(plan);
	//	return saved.getPlanId()!=null ?true :false;
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlan() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		//control + 1 + enter to get return type 	
		if(findById.isPresent()) 
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
	    planRepo.save(plan);  //( upsert)
		return plan.getPlanId()!=null;
		
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status = false;	
		try {
			planRepo.deleteById(planId);	
			//delete gives void return type
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);
		//control + 1 + enter to get return type
		if(findById.isPresent()) {
			Plan plan =  findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
