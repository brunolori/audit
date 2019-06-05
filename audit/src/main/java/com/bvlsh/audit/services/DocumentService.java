package com.bvlsh.audit.services;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvlsh.audit.assemblers.Assembler;
import com.bvlsh.audit.constants.IPath;
import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.dao.CrudDAO;
import com.bvlsh.audit.dao.DocumentDAO;
import com.bvlsh.audit.dao.UserDAO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.entities.Document;
import com.bvlsh.audit.entities.DocumentType;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.entities.User;
import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.utils.CalculatorUtil;
import com.bvlsh.audit.utils.StringUtil;

@Service
@Transactional
public class DocumentService {

	@Autowired CrudDAO crudDAO;
	@Autowired DocumentDAO documentDAO;
	@Autowired UserDAO userDAO;

	public DocumentDTO create(DocumentDTO dto, String uname) throws IOException {
		
		if(dto.getDocumentType() == null || !StringUtil.isValid(dto.getDocumentType().getCode()))
		{
			throw new AppException("Zgjidh llojin e dokumentit!");
		}
		if(!StringUtil.isValid(dto.getName()))
		{
			throw new AppException("Vendos emrin e dokumentit!");
		}
		if(!StringUtil.isValid(dto.getData()))
		{
			throw new AppException("Ngarko dokumentin!");
		}
		
		
		String fileName=dto.getDocumentPath();	
				
		
		FileUtils.writeByteArrayToFile(new File(IPath.DOC_PATH+fileName), CalculatorUtil.decodeBASE64(dto.getData()));
		
		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);
		Dossier dossier = crudDAO.findByKey(Dossier.class, dto.getDossier().getId());

		Document d = new Document();

		d.setName(dto.getName());
		d.setDocumentPath(fileName);
		d.setDocumentContentType(dto.getContentType());
		d.setDocumentType(new DocumentType(dto.getDocumentType().getCode()));
		d.setDossier(dossier);
		d.setCreateTime(time);
		d.setCreateUser(user);
		d.setIsDeleted(IStatus.NO);
		
		d = crudDAO.create(d);
		
		return new Assembler().toDto(d);

	}
	
	
  public DocumentDTO update(DocumentDTO dto, String uname) {
		
		if(dto.getDocumentType() == null || !StringUtil.isValid(dto.getDocumentType().getCode()))
		{
			throw new AppException("Zgjidh llojin e dokumentit!");
		}
		if(!StringUtil.isValid(dto.getName()))
		{
			throw new AppException("Vendos emrin e dokumentit!");
		}
		
		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Document d = crudDAO.findByKey(Document.class, dto.getId());

		d.setName(dto.getName());
		d.setDocumentType(new DocumentType(dto.getDocumentType().getCode()));
		d.setUpdateTime(time);
		d.setUpdateUser(user);
		d.setIsDeleted(IStatus.NO);
		
		d = crudDAO.update(d);
		
		return new Assembler().toDto(d);

	}
  
  public void delete(Integer documentId, String uname)
  {
	    Date time = Calendar.getInstance().getTime();
	    User user = userDAO.findByUsername(uname);

	    Document d = crudDAO.findByKey(Document.class, documentId);
	    d.setUpdateTime(time);
		d.setUpdateUser(user);
		d.setIsDeleted(IStatus.YES);
		
		d = crudDAO.update(d);
		
		File fileToDelete = new File("src/test/resources/fileToDelete_jdk6.txt");
	    boolean success = fileToDelete.delete();
	    if(!success)
	    {
	    	throw new AppException("Dokumenti nuk mund të fshihet!");
	    }
  }
  
  
  public List<DocumentDTO> search(Integer dossierId, String dossierNo, String documentType) {
	  
	  return new Assembler().documentListToDto(documentDAO.search(dossierId, dossierNo, documentType));
  }
  
  
  
}
