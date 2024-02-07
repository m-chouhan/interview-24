package problems;
import java.util.*;
import java.util.stream.*;

/***
 * https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
    class Account {
        String name;
        SortedSet<String> emails = new TreeSet<>();
        boolean isVisited = false;

        Account(List<String> accountInfo) {
            name = accountInfo.get(0);
            for(int i = 1; i < accountInfo.size(); ++i)
                emails.add(accountInfo.get(i));
        }

        List<String> toList() {
            ArrayList<String> list = new ArrayList<>();
            list.add(name);
            for(String email : emails)
                list.add(email);
            return list;
        }

        void include(Account account) {
            if(account != null) {
                emails.addAll(account.emails);
            }
        }
    }

    HashMap<String, List<Account>> reverseMap;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Account> accountList = parse(accounts);
        reverseMap = getReverseMap(accountList);
        List<Account> mergedAccountList = new ArrayList<>();

        for(Account account : accountList) {
            if(!account.isVisited) {
                mergedAccountList.add(mergeAccounts(account));
            }
        }

        return mergedAccountList.stream()
                .map(account -> account.toList())
                .collect(Collectors.toList());
    }

    List<Account> parse(List<List<String>> accounts) {
        return accounts.stream()
                .map(accountInfo -> new Account(accountInfo))
                .collect(Collectors.toList());
    }

    HashMap<String, List<Account>> getReverseMap(List<Account> accountList) {
        HashMap<String, List<Account>> reverseMap = new HashMap<>();
        for(Account a : accountList) {
            for(String email : a.emails) {
                List<Account> list = reverseMap.containsKey(email)
                        ? reverseMap.get(email)
                        : new ArrayList<>();
                list.add(a);
                reverseMap.put(email, list);
            }
        }
        return reverseMap;
    }

    Account mergeAccounts(Account currentAccount) {
        if(currentAccount.isVisited)
            return null;

        Account mergedAccount = new Account(currentAccount.toList());
        currentAccount.isVisited = true;
        for(String email : currentAccount.emails) {
            List<Account> nextAccountsToVisit = getAccountListFromEmail(email);
            for(Account next : nextAccountsToVisit) {
                mergedAccount.include(mergeAccounts(next));
            }
        }
        return mergedAccount;
    }

    List<Account> getAccountListFromEmail(String email) {
        return reverseMap.get(email);
    }
}
