package com.info6250.packages.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.info6250.packages.entities.Workspace;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class UserPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
			//      Map<String,String> userData = (Map<String,String>) model.get("userData");
				  
				Map<String,  List<Workspace>>  theModel =  (Map<String,  List<Workspace>>) model.get("userData");
				 
				
				  List<Workspace> workspaces = theModel.get("1");
				  
				  Table table = new Table(4);
			      
				  
				  table.addCell("Date");   
			      table.addCell("Restaurant_Name");
			      table.addCell("Total_Value");
			      table.addCell("Status");
			      
			   
			      for(Workspace theWorkspace: workspaces) {
			    	 
			    	  table.addCell(theWorkspace.getDate());
			    	  table.addCell(theWorkspace.getRestaurantName());
			    	  table.addCell(theWorkspace.getTotal_value()+"");
			    	  table.addCell(theWorkspace.getStatus());
			    	  
			    	  
			      }
			      
			      
			      /*
			      for (Map.Entry<String, String> entry : userData.entrySet()) {
			         table.addCell(entry.getKey());
			         table.addCell(entry.getValue());
			      }
			      
			      */
			      document.add(table);
		
	}
	
	
	
	
	
	

}
