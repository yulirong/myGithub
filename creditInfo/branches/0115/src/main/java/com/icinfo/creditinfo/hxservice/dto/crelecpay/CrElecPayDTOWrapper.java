package com.icinfo.creditinfo.hxservice.dto.crelecpay;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrElecPayDTOWrapper {
	
	    @XmlElement(name = "crElecPayDTO")
	    @XmlElementWrapper(name = "crElecPayDTOs")
	    private List<CrElecPayDTO>  crElecPayDTOs;
        public CrElecPayDTOWrapper(){
        	
        }
	    
	    public CrElecPayDTOWrapper(List<CrElecPayDTO>  crElecPayDTOs){
	    	this.crElecPayDTOs = crElecPayDTOs;
	    }
		public List<CrElecPayDTO> getCrElecPayDTOs() {
			return crElecPayDTOs;
		}

		public void setCrElecPayDTOs(List<CrElecPayDTO> crElecPayDTOs) {
			this.crElecPayDTOs = crElecPayDTOs;
		}

}
