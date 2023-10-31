package bt.backend.PresentationLayer;

import java.util.List;

import bt.backend.BusinessLayer.AccountService;
import bt.entity.Account;

public class Controller {
	AccountService as = new AccountService();
	public List<Account> LayAllAccount(){
		return as.getAllAccount();
	}
}
