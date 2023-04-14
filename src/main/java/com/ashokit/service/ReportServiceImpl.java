package com.ashokit.service;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.ReportService.ReportService;
import com.ashokit.SearchRequest.SearchRequest;
import com.ashokit.entity.CitizenPlan;
import com.ashokit.excel.ExcelGenerator;
import com.ashokit.pdf.pdfGenerator;
import com.ashokit.repo.CitizenPlanRepo;
import com.ashokit.utils.Emailutils;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private ExcelGenerator excelgenerator;
	
	@Autowired
	private pdfGenerator pdfgenerator;
	
	@Autowired
	private Emailutils emailutils;

	public  List<String> getPlanname(){
		
		List<String> planNames=repo.getPlanName();
		return planNames;
		}

	public List<String> getPlanstatus(){
		List<String> planstatus=repo.getPlanStatus();
		return planstatus;
	}

	public List<CitizenPlan> search (SearchRequest request){
		CitizenPlan entity=new CitizenPlan();
		
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		return repo.findAll(Example.of(entity));
	}
	public boolean exportexcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = repo.findAll();
		excelgenerator.generate(response, plans);
		File f=new File("Plans.xls");
		String subject="Test mail subject";
		String body="<h1> test mail body</h1>";
		String to="neerajsunkari@gmail.com";
		emailutils.sendEMail(subject, body, to,f);
		
		f.delete();
		
		
	return true;
	}
	@Override
	public boolean exportpdf(HttpServletResponse Response) throws Exception {
		File f=new File("Plans.Pdf");
    List<CitizenPlan> Plans = repo.findAll();
    pdfgenerator.generate(Response, Plans,f);
		
		return true;
	}
	
}
	


