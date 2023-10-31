package bt.backend.Datalayer;

import java.util.List;

import bt.entity.Account;

public interface IAccountRepository {
	public List<Account> getListAccount();
}
