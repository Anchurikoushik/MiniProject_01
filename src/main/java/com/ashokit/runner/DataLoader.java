package com.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepo;
@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		//cash Plan Data
		CitizenPlan p1=new CitizenPlan();
         p1.setCitizenName("rahul");
         p1.setGender("male"); 
         p1.setPlanName("cash");
         p1.setPlanStatus("Approved");
         p1.setPlanStartDate(LocalDate.now());
         p1.setPlanEndDate(LocalDate.now().plusMonths(8));
         p1.setBenefitAmount(50000.00);
         
         CitizenPlan p2=new CitizenPlan();
         p2.setCitizenName("prakash");
         p2.setGender("male");
         p2.setPlanName("cash");
         p2.setPlanStatus("denied");
         p2.setDenialReason("rental Income");
         
         CitizenPlan p3=new CitizenPlan();
         p3.setCitizenName("Shruthi");
         p3.setGender("female");
         p3.setPlanName("cash");
         p3.setPlanStatus("terminated");
         p3.setPlanStartDate(LocalDate.now().minusMonths(6));
         p3.setPlanEndDate(LocalDate.now().plusMonths(2));
         p3.setBenefitAmount(50000.00);
         p3.setTerminatedDate(LocalDate.now());
         p3.setTerminationReason("employeed");
         
          //food plan data
     	//cashPlanData
 		CitizenPlan p4=new CitizenPlan();
          p4.setCitizenName("kiran");
          p4.setGender("male"); 
          p4.setPlanName("food");
          p4.setPlanStatus("Approved");
          p4.setPlanStartDate(LocalDate.now());
          p4.setPlanEndDate(LocalDate.now().plusMonths(8));
          p4.setBenefitAmount(40000.00);
          
          CitizenPlan p5=new CitizenPlan();
          p5.setCitizenName("Suresh");
          p5.setGender("male");
          p5.setPlanName("food");
          p5.setPlanStatus("denied");
          p5.setDenialReason("salaried employ");
          
          CitizenPlan p6=new CitizenPlan();
          p6.setCitizenName("Seetha");
          p6.setGender("female");
          p6.setPlanName("food");
          p6.setPlanStatus("terminated");
          p6.setPlanStartDate(LocalDate.now().minusMonths(6));
          p6.setPlanEndDate(LocalDate.now().plusMonths(2));
          p6.setBenefitAmount(50000.00);
          p6.setTerminatedDate(LocalDate.now());
          p6.setTerminationReason("employeed");
          
      	//Medical planData
          
  		CitizenPlan p7=new CitizenPlan();
           p7.setCitizenName("koushik");
           p7.setGender("male"); 
           p7.setPlanName("medical");
           p7.setPlanStatus("Approved");
           p7.setPlanStartDate(LocalDate.now());
           p7.setPlanEndDate(LocalDate.now().plusMonths(8));
           p7.setBenefitAmount(70000.00);
           
           CitizenPlan p8=new CitizenPlan();
           p8.setCitizenName("tinku");
           p8.setGender("male");
           p8.setPlanName("medical");
           p8.setPlanStatus("denied");
           p8.setDenialReason("property Income");
           
           CitizenPlan p9=new CitizenPlan();
           p9.setCitizenName("madhu");
           p9.setGender("female");
           p9.setPlanName("medical");
           p9.setPlanStatus("terminated");
           p9.setPlanStartDate(LocalDate.now().minusMonths(6));
           p9.setPlanEndDate(LocalDate.now().plusMonths(2));
           p9.setBenefitAmount(50000.00);
           p9.setTerminatedDate(LocalDate.now());
           p9.setTerminationReason("govt job");
           
           //Employment plan data 
          
   		CitizenPlan p10=new CitizenPlan();
            p10.setCitizenName("suraj");
            p10.setGender("male"); 
            p10.setPlanName("Employment");
            p10.setPlanStatus("Approved");
            p10.setPlanStartDate(LocalDate.now());
            p10.setPlanEndDate(LocalDate.now().plusMonths(8));
            p10.setBenefitAmount(90000.00);
            
            CitizenPlan p11=new CitizenPlan();
            p11.setCitizenName("pratap");
            p11.setGender("male");
            p11.setPlanName("employment");
            p11.setPlanStatus("denied");
            p11.setDenialReason("anual Income");
            
            CitizenPlan p12=new CitizenPlan();
            p12.setCitizenName("shivani");
            p12.setGender("female");
            p12.setPlanName("employment");
            p12.setPlanStatus("terminated");
            p12.setPlanStartDate(LocalDate.now().minusMonths(6));
            p12.setPlanEndDate(LocalDate.now().plusMonths(2));
            p12.setBenefitAmount(50000.00);
            p12.setTerminatedDate(LocalDate.now());
            p12.setTerminationReason("family background");
            
            List<CitizenPlan> list = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12);        
         repo.saveAll(list);
         
         
	}
	
	
	

}
