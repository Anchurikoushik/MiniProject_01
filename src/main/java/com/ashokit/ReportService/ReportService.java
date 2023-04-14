package com.ashokit.ReportService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ashokit.SearchRequest.SearchRequest;
import com.ashokit.entity.CitizenPlan;


public interface ReportService {
	
public  List<String> getPlanname();
	
	public List<String> getPlanstatus();
	
public List<CitizenPlan> search (SearchRequest request);



	public boolean exportexcel(HttpServletResponse  Response) throws Exception;
	
	public boolean exportpdf(HttpServletResponse  Response)throws Exception;
	
	
	

}
