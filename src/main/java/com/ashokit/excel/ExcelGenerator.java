package com.ashokit.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepo;
@Component
public class ExcelGenerator {
	@Autowired
	private CitizenPlanRepo repo;
	
	public void generate(HttpServletResponse response,List<CitizenPlan> Record) throws Exception {
List<CitizenPlan> records = repo.findAll();
		
		Workbook workbook=new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("citizenName");
		headerRow.createCell(2).setCellValue("planName");
		headerRow.createCell(3).setCellValue("planStatus");
		headerRow.createCell(4).setCellValue("planStartDate");
		headerRow.createCell(5).setCellValue("planEndDate");
		headerRow.createCell(6).setCellValue("benefitAmt");
		
		List<CitizenPlan> record = repo.findAll();
		int dataRowIndex=1;
		for(CitizenPlan plan:record) {
			Row dataRow = sheet.createRow(1);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			if(null!=plan.getPlanStartDate()) {
			dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
			}
			else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			if(null!=plan.getPlanEndDate()) {
			dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
			}
			else {
				dataRow.createCell(5).setCellValue("N/A");
				
			}
			if(null!=plan.getBenefitAmount()) {
			dataRow.createCell(6).setCellValue(plan.getBenefitAmount());
			}
			else {
				dataRow.createCell(6).setCellValue("N/A");
				
			}
			dataRowIndex++;
		
		FileOutputStream fos=new FileOutputStream(new File("Plans.xls"));
		workbook.write(fos);
		workbook.close();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		}
		
		
	}
	

}
	

	


	
