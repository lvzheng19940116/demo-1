package ad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ad.bean.AbAdvertiser;

public interface IAbAdvertiserService {

	int saveObject(AbAdvertiser abAdvertiser);

	AbAdvertiser selectMaxId();

	int updateObject(AbAdvertiser abAdvertiser);

	int deleteObject(AbAdvertiser abAdvertiser);

	List<AbAdvertiser> queryList(AbAdvertiser abAdvertiser);

	List<AbAdvertiser> queryAdvertiserIdList();

	long queryTotal();

	AbAdvertiser queryByKek(Integer id);

	AbAdvertiser queryByUserId(AbAdvertiser abAdvertiser);

	AbAdvertiser queryByuserAccount(AbAdvertiser abAdvertiser);

	AbAdvertiser queryByuserAccountId(AbAdvertiser abAdvertiser);

	Integer getByName(AbAdvertiser record);
	
	//modified by caiqp
	String queryAbAdvertiserList(AbAdvertiser record);
	String saveAbAdvertiserObject(AbAdvertiser record, HttpServletRequest req);
	String updateAbAdvertiserObject(AbAdvertiser record, HttpServletRequest req);
	String deleteAbAdvertiserObject(AbAdvertiser record);

}
