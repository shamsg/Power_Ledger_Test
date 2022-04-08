package com.plt.ws.document;

import java.io.Serializable;
import java.util.Collection;


import org.springframework.data.mongodb.core.mapping.Document;




@Document
public class SubrubDocument implements Serializable {
	 
		private static final long serialVersionUID = 5313493413859894403L;
		

		private String id;

		private String subrubName;

		private String zipCode;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSubrubName() {
			return subrubName;
		}

		public void setSubrubName(String subrubName) {
			this.subrubName = subrubName;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		
}
