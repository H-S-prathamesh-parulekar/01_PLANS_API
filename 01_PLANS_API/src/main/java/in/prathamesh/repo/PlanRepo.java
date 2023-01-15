package in.prathamesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prathamesh.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer>{
	//interface
}
