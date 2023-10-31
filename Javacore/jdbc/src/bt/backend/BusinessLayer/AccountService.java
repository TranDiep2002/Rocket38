package bt.backend.BusinessLayer;

import java.util.List;

import bt.backend.Datalayer.AccountRepository;
import bt.entity.Account;

public class AccountService implements IAccountService {

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		AccountRepository repo = new AccountRepository();
		try {
			return repo.getListAccount();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
