package com.trustev.domain.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedDecision extends Decision{
	
	@JsonProperty("CaseNumber")
	private String caseNumber;
    
	@JsonProperty("CaseId")
	private String caseId;
    
	@JsonProperty("RawData")
	private RawData rawData;
    
	@JsonProperty("ComputedData")
	private ComputedData computedData;
	@JsonProperty("Authentication")
	private DigitalAuthenticationResult Authentication;

	@JsonProperty("AuthenticatedDataRequest")
	private AutoFillDetails authenticatedDataRequest;
	
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public RawData getRawData() {
		return rawData;
	}

	public void setRawData(RawData rawData) {
		this.rawData = rawData;
	}

	public ComputedData getComputedData() {
		return computedData;
	}

	public void setComputedData(ComputedData computedData) {
		this.computedData = computedData;
	}


	public DigitalAuthenticationResult getAuthentication() {
		return Authentication;
	}

	public void setAuthentication(DigitalAuthenticationResult authentication) {
		Authentication = authentication;
	}

	public AutoFillDetails getAuthenticatedDataRequest() {
		return authenticatedDataRequest;
	}

	public void setAuthenticatedDataRequest(AutoFillDetails authenticatedDataRequest) {
		this.authenticatedDataRequest = authenticatedDataRequest;
	}
}