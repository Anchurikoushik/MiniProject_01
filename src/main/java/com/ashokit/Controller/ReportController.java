package com.ashokit.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ReportService.ReportService;
import com.ashokit.SearchRequest.SearchRequest;
import com.ashokit.entity.CitizenPlan;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;
	
	@GetMapping("/Pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("content_Disposition", "attachment;filename=plans.pdf");
		service.exportpdf(response);
		
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("content_Disposition", "attachment;filename=plans.xlsx");
		service.exportexcel(response);
		
	}
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search")SearchRequest search ,Model model) {
		List<CitizenPlan> plans = service.search(search);
        model.addAttribute("plans",plans);
		init(model);
	return "index";
	}
	@GetMapping("/")
	public String indexpage(Model model) { 
		model.addAttribute("search",new SearchRequest());
		
		init(model);
		return "index";
	}
	private void init(Model model) {
	//	model.addAttribute("Search",new SearchRequest() );
		model.addAttribute("names",service.getPlanname());
		List<String> planstatus = service.getPlanstatus();
		model.addAttribute("status",planstatus);	
	}
}
