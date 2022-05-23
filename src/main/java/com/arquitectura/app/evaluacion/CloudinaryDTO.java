package com.arquitectura.app.evaluacion;

public class CloudinaryDTO {
	
	private String urlFile;
	private String nameUniqueFile;
	
	public CloudinaryDTO() {
		super();
	}
	public CloudinaryDTO(String urlFile, String nameUniqueFile) {
		super();
		this.urlFile = urlFile;
		this.nameUniqueFile = nameUniqueFile;
	}
	public String getUrlFile() {
		return urlFile;
	}
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	public String getNameUniqueFile() {
		return nameUniqueFile;
	}
	public void setNameUniqueFile(String nameUniqueFile) {
		this.nameUniqueFile = nameUniqueFile;
	}
	
	
	
}
