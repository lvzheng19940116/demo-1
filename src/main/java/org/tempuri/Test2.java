package org.tempuri;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Test2 {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(SMBBOMServiceSoap.class);   
        factory.setAddress("http://10.96.39.118:8083/SMBBOMService.asmx");    
            
        factory.setUsername("s_lms");  
        factory.setPassword("1234#a@b!c");  
        SMBBOMServiceSoap t=(SMBBOMServiceSoap )factory.create(); 
        
        
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
        SMBReturnModel smbStandardPriceList = t.getSMBStandardPriceList(parameterList);
        System.out.println("qqq" +smbStandardPriceList);
        System.out.println(smbStandardPriceList.returnFlag);
        System.out.println(smbStandardPriceList.returnMsg);
        System.out.println( smbStandardPriceList.standardPriceList);
        List<SMBStandardPriceModel> smbStandardPriceModel = smbStandardPriceList.getStandardPriceList().getSMBStandardPriceModel();
        
        for (int i = 0; i < smbStandardPriceModel.size(); i++) {
		System.out.println("555"+smbStandardPriceModel.get(i).getBOMCode());
	}
        
        
       // Test s = (Test) factory.create();   
        //System.out.println("connection result:"+s.());  
	}
}
