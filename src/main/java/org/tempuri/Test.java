package org.tempuri;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Test {

	private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "SMBBOMService");

	private Test() {
	}

	public static void main(String[] args) {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Test.class);
		factory.setAddress("http://10.96.39.118:8083/SMBBOMService.asmx");

		factory.setUsername("s_lms");
		factory.setPassword("1234#a@b!c");

		Test s = (Test) factory.create();

		URL wsdlURL = SMBBOMService.WSDL_LOCATION;
		SMBBOMService ss = new SMBBOMService(wsdlURL, SERVICE_NAME);
		SMBBOMServiceSoap port = ss.getSMBBOMServiceSoap();

		ArrayOfSMBParameterModel _getSMBStandardPriceList_parameterList = null;

		ArrayOfSMBParameterModel parameterList = new ArrayOfSMBParameterModel();
		List<SMBParameterModel> smbParameterModel = new ArrayList<SMBParameterModel>();
		SMBParameterModel model = new SMBParameterModel();
		model.setBOMCode("SMB260427000004");
		model.setProductGroupCode("03");
		SMBParameterModel model1 = new SMBParameterModel();
		model1.setBOMCode("SMB2160831000004");
		model1.setProductGroupCode("84");
		smbParameterModel.add(model);
		smbParameterModel.add(model1);
		parameterList.setSmbParameterModel(smbParameterModel);
		// GetSMBStandardPriceListResponse send = s.send(parameterList);

		SMBReturnModel _getSMBStandardPriceList__return = port
				.getSMBStandardPriceList(_getSMBStandardPriceList_parameterList);

		System.out.println(_getSMBStandardPriceList__return);
	}

}
